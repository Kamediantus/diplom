package ru.diplom.diplom.client.components;

import java.util.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.*;
import ru.diplom.diplom.client.services.entity.*;
import ru.diplom.diplom.client.viewUtils.*;

public class ProductsFrame extends EditFrame{
    static FancyViewer viewer = new FancyViewer();
    private final static int MAX_COL = 6;
    private final static int COL_NAME = 0;
    private final static int COL_DESCRIPTION = 1;
    private final static int COL_PRICE = 2;
    private final static int COL_STORE = 3;
    private final static int COL_STORE_DISCOUNT = 4;
    private final static int COL_PERSONAL_DISCOUNT = 5;
    private final static int COL_PRODUCE_DATE = 6;
    private final static int COL_SHELF_LIFE = 7;
    private final static int COL_COUNT = 8;
    private final static int COL_RESERVE_COUNT = 9;
    private final static int COL_RESERVE = 10;

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
        scrollPane.setPrefViewportWidth(1200);
        FlowPane result = new FlowPane(scrollPane);
        result.setId(FrameType.PRODUCTS);

        setColumnsWidth(productsList);

        productsList.setGridLinesVisible(true);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Наименование"), 10), COL_NAME, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Описание товара"), 10), COL_DESCRIPTION, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Цена"), 10), COL_PRICE, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Магазин"), 10), COL_STORE, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Скидка \nпоставщика"), 10), COL_STORE_DISCOUNT, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Персональная \nскидка"), 10), COL_PERSONAL_DISCOUNT, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Дата \nпроизводства"), 10), COL_PRODUCE_DATE, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Срок годности"), 10), COL_SHELF_LIFE, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Количество \nна складе"), 10), COL_COUNT, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Кол-во \nдля резерва"), 10), COL_RESERVE_COUNT, 0);

        for (int productIndex = 0, rowIndex = 1; productIndex < products.size(); productIndex++, rowIndex++) {
            TextField countInput = new TextField();
            HBox countBox = getNumericInput(countInput);
            Product product = products.get(productIndex);

            Button buyButton = new Button("Заказать");
            buyButton.setId(product.getId().toString());

            productsList.add(viewer.addPaddingsAndReturn(new Label(product.getTitle()), 10), COL_NAME, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(product.getDescription()), 10), COL_DESCRIPTION, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(product.getStringPrice()), 10), COL_PRICE, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(product.getStore().getTitle()), 10), COL_STORE, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(Double.toString(product.getStore().getDiscount())), 10), COL_STORE_DISCOUNT, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(Double.toString(product.getPersonalDiscount())), 10), COL_PERSONAL_DISCOUNT, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(Integer.toString(product.getShelLife())), 10), COL_SHELF_LIFE, rowIndex);
            if (product.getProductLot() != null) {
                productsList.add(viewer.addPaddingsAndReturn(new Label((product.getProductLot().getDateOfProduction()).toString()), 10), COL_PRODUCE_DATE, rowIndex);
                productsList.add(viewer.addPaddingsAndReturn(new Label(Integer.toString(product.getProductLot().getCount())), 10), COL_COUNT, rowIndex);
                productsList.add((countBox), COL_RESERVE_COUNT, rowIndex);
            } else {
                productsList.add(viewer.addPaddingsAndReturn(new Label("-"), 10), COL_PRODUCE_DATE, rowIndex);
                productsList.add(viewer.addPaddingsAndReturn(new Label("0"), 10), COL_COUNT, rowIndex);
                buyButton.setDisable(true);
            }

            buyButton.setOnAction(e -> {
                OrderService.addOrder(product.getId(), product.getStoreId(), countInput.getText());
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
        gridPane.getColumnConstraints().add(COL_PERSONAL_DISCOUNT, new ColumnConstraints(80));
        gridPane.getColumnConstraints().add(COL_PRODUCE_DATE, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_SHELF_LIFE, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_COUNT, new ColumnConstraints(80));
        gridPane.getColumnConstraints().add(COL_RESERVE_COUNT, new ColumnConstraints(80));
        gridPane.getColumnConstraints().add(COL_RESERVE, new ColumnConstraints(100));
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
