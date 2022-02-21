package ru.diplom.diplom.client.components;

import java.util.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.*;
import ru.diplom.diplom.client.services.entity.*;
import ru.diplom.diplom.client.viewUtils.*;

public class ProductsTable {
    static FancyViewer viewer = new FancyViewer();

    public static GridPane getFrame() {
        GridPane productsGrid = new GridPane();
        productsGrid.setId(FrameType.PRODUCTS);
        List<Product> products = ProductService.getAllProducts();
        GridPane productsList = new GridPane();
        productsList.setGridLinesVisible(true);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Наименование"), 10), 0, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Описание товара"), 10), 1, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Цена"), 10), 2, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Магазин"), 10), 3, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Скидка от магазина"), 10), 4, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Зарезервировать \nтовар"), 10), 5, 0);

        for (int productIndex = 0, rowIndex = 1; productIndex < products.size(); productIndex++, rowIndex++) {
            productsList.add(viewer.addPaddingsAndReturn(new Label(products.get(productIndex).getTitle()), 10), 0, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(products.get(productIndex).getDescription()), 10), 1, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(products.get(productIndex).getStringPrice()), 10), 2, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(products.get(productIndex).getStringPrice()), 10), 3, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(products.get(productIndex).getStringPrice()), 10), 4, rowIndex);
            Button buyButton = new Button("Зарезервировать");
            buyButton.setId("buy_" + productIndex);
            buyButton.setOnAction(e -> {

            });
            productsList.add(viewer.addPaddingsAndReturn(buyButton, 10), 5, rowIndex);
        }
        productsGrid.add(productsList, 0, 0);
        return productsGrid;
    }
}
