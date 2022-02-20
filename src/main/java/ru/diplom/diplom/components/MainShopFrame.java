package ru.diplom.diplom.components;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.services.*;
import ru.diplom.diplom.viewUtils.*;

public class MainShopFrame {
    static FancyViewer viewer = new FancyViewer();

    public static GridPane getFrame() {
        Label label1 = new Label("Менюшка");

        ContextMenu mainToolbar = new ContextMenu();
        MenuItem shops = new MenuItem("Shops");


        MenuItem products = new MenuItem("All products");
        MenuItem orders = new MenuItem("Orders");
        mainToolbar.getItems().addAll(shops, products, orders);

        TilePane tilePane = new TilePane(label1);
        viewer.addPaddings(tilePane, 10);

        // setContextMenu to label
        label1.setContextMenu(mainToolbar);

        GridPane shopGrid = new GridPane();
        shopGrid.add(tilePane, 1, 1, 2, 1);

        return shopGrid;
    }
}
