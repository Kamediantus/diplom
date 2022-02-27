package ru.diplom.diplom.client.components;

import java.util.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.*;
import ru.diplom.diplom.client.services.entity.*;
import ru.diplom.diplom.client.viewUtils.*;

public class ProductsFrame {
    static FancyViewer viewer = new FancyViewer();
    private final static int MAX_COL = 6;
    private final static int COL_NAME = 0;
    private final static int COL_DESCRIPTION = 1;
    private final static int COL_PRICE = 2;
    private final static int COL_STORE = 3;
    private final static int COL_STORE_DISCOUNT = 4;
    private final static int COL_PRODUCE_DATE = 5;
    private final static int COL_SHELF_LIFE = 6;
    private final static int COL_COUNT = 7;
    private final static int COL_RESERVE = 8;

    private List<Product> products;
    private Pane frame;

    public static ProductsFrame createNew() {
        ProductsFrame frame = new ProductsFrame();
        frame.products = ProductService.getAllProductsWithFullInfoAndActualPrices();
        frame.frame = frame.initFrame();
        return frame;
    }

    public Pane initFrame() {
        GridPane productsList = new GridPane();
        ScrollPane scrollPane = new ScrollPane(productsList);
        scrollPane.setPrefViewportHeight(600);
        scrollPane.setPrefViewportWidth(1000);
        FlowPane result = new FlowPane(scrollPane);
        result.setId(FrameType.PRODUCTS);

        setColumnsWidth(productsList);

        productsList.setGridLinesVisible(true);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Наименование"), 10), COL_NAME, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Описание товара"), 10), COL_DESCRIPTION, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Цена"), 10), 2, COL_PRICE);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Магазин"), 10), COL_STORE, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Скидка \nпоставщика"), 10), COL_STORE_DISCOUNT, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Дата производства"), 10), COL_PRODUCE_DATE, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Срок годности"), 10), COL_SHELF_LIFE, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Количество на складе"), 10), COL_COUNT, 0);

        for (int productIndex = 0, rowIndex = 1; productIndex < products.size(); productIndex++, rowIndex++) {
            Product product = products.get(productIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(product.getTitle()), 10), COL_NAME, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(product.getDescription()), 10), COL_DESCRIPTION, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(product.getStringPrice()), 10), COL_PRICE, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(product.getStore().getTitle()), 10), COL_STORE, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(Double.toString(product.getStore().getDiscount())), 10), COL_STORE_DISCOUNT, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(Integer.toString(product.getShelLife())), 10), COL_SHELF_LIFE, rowIndex);
            if (product.getProductLot() != null) {
                productsList.add(viewer.addPaddingsAndReturn(new Label((product.getProductLot().getDateOfProduction()).toString()), 10), COL_PRODUCE_DATE, rowIndex);
                productsList.add(viewer.addPaddingsAndReturn(new Label(Double.toString(product.getProductLot().getCount())), 10), COL_COUNT, rowIndex);
            }
            Button buyButton = new Button("Зарезервировать");
            buyButton.setId("buy_" + productIndex);
            buyButton.setOnAction(e -> {

            });
            productsList.add(viewer.addPaddingsAndReturn(buyButton, 10), COL_RESERVE, rowIndex);
        }
        return result;
    }

    private static void setColumnsWidth(GridPane gridPane) {
        gridPane.getColumnConstraints().add(COL_NAME, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_DESCRIPTION, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_PRICE, new ColumnConstraints(60));
        gridPane.getColumnConstraints().add(COL_STORE, new ColumnConstraints(100));
        gridPane.getColumnConstraints().add(COL_STORE_DISCOUNT, new ColumnConstraints(80));
        gridPane.getColumnConstraints().add(COL_PRODUCE_DATE, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_SHELF_LIFE, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_COUNT, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_RESERVE, new ColumnConstraints(120));
    }

    public void refreshEntities() {
        this.products = ProductService.getAllProductsWithFullInfoAndActualPrices();
    }

    public Pane getFrame() {
        refreshEntities();
        return initFrame();
    }

    public void setFrame(GridPane frame) {
        this.frame = frame;
    }
}
