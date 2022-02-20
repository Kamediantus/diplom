package ru.diplom.diplom.components;

import java.util.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.constant.*;
import ru.diplom.diplom.services.*;
import ru.diplom.diplom.services.entity.*;
import ru.diplom.diplom.viewUtils.*;

public class ProductsTable {
    static FancyViewer viewer = new FancyViewer();

    public static GridPane getFrame() {
        GridPane productsGrid = new GridPane();
        productsGrid.setId(FrameType.PRODUCTS);
        List<Product> products = ProductService.getAllProducts();
        GridPane productsList = new GridPane();
        for (int i = 0; i < products.size(); i++) {
            productsList.add(new Label(products.get(i).getTitle()), 0, i);
            productsList.add(new Label(products.get(i).getDescription()), 1, i);
            productsList.add(new Label(products.get(i).getStringPrice()), 2, i);
        }
        Label test = new Label("here will be products");
        productsGrid.add(test, 0, 0);
        productsGrid.add(productsList, 0, 1);
        return productsGrid;
    }
}
