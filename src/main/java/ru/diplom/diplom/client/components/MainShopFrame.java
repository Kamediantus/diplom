package ru.diplom.diplom.client.components;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.viewUtils.*;

public class MainShopFrame {
    static FancyViewer viewer = new FancyViewer();

    public static GridPane getFrame() {
        GridPane shopGrid = new GridPane();
        GridPane content = ProductsTable.getFrame();

        Label label1 = new Label("Менюшка");
        ContextMenu mainToolbar = new ContextMenu();
        MenuItem shops = new MenuItem("Shops");
        shops.setOnAction(event -> {
            shopGrid.getChildren().removeIf(node -> FrameType.getContentIds().contains(node.getId()));
            shopGrid.add(StoresTable.getFrame(), 1, 2);
        });

        MenuItem products = new MenuItem("All products");
        products.setOnAction(event -> {
            shopGrid.getChildren().removeIf(node -> FrameType.getContentIds().contains(node.getId()));
            shopGrid.add(ProductsTable.getFrame(), 1, 2);
        });

        MenuItem orders = new MenuItem("Orders");
        orders.setOnAction(event -> {
            shopGrid.getChildren().removeIf(node -> FrameType.getContentIds().contains(node.getId()));
            shopGrid.add(OrderTable.getFrame(), 1, 2);
        });

        mainToolbar.getItems().addAll(shops, products, orders);

        TilePane tilePane = new TilePane(label1);
        viewer.addPaddings(tilePane, 10);
        label1.setContextMenu(mainToolbar);

        shopGrid.add(tilePane, 0, 0);
        shopGrid.add(content, 1, 2);

        return shopGrid;
    }
}
