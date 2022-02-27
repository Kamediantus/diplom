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
    private final static int COL_RESERVE = 5;

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
        scrollPane.setPrefViewportWidth(800);
        FlowPane result = new FlowPane(scrollPane);
        result.setId(FrameType.PRODUCTS);

        setColumnsWidth(productsList);

        productsList.setGridLinesVisible(true);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Наименование"), 10), 0, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Описание товара"), 10), 1, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Цена"), 10), 2, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Магазин"), 10), 3, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Скидка \nпоставщика"), 10), 4, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Зарезервировать \nтовар"), 10), 5, 0);

        for (int productIndex = 0, rowIndex = 1; productIndex < products.size(); productIndex++, rowIndex++) {
            productsList.add(viewer.addPaddingsAndReturn(new Label(products.get(productIndex).getTitle()), 10), 0, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(products.get(productIndex).getDescription()), 10), 1, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(products.get(productIndex).getStringPrice()), 10), 2, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(products.get(productIndex).getStore().getTitle()), 10), 3, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(Double.toString(products.get(productIndex).getStore().getDiscount())), 10), 4, rowIndex);
            Button buyButton = new Button("Зарезервировать");
            buyButton.setId("buy_" + productIndex);
            buyButton.setOnAction(e -> {

            });
            productsList.add(viewer.addPaddingsAndReturn(buyButton, 10), 5, rowIndex);
        }
        return result;
    }

    private static void setColumnsWidth(GridPane gridPane) {
        gridPane.getColumnConstraints().add(COL_NAME, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_DESCRIPTION, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_PRICE, new ColumnConstraints(60));
        gridPane.getColumnConstraints().add(COL_STORE, new ColumnConstraints(100));
        gridPane.getColumnConstraints().add(COL_STORE_DISCOUNT, new ColumnConstraints(80));
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
