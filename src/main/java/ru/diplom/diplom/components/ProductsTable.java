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
        Label test = new Label("here will be products");
        productsGrid.add(test, 0, 0);
        return productsGrid;
    }
}
