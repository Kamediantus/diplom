package ru.diplom.diplom.client.components;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.viewUtils.*;

public class MainShopFrame {
    private GridPane frame;
    private StoresFrame storesFrame;
    private AddProductFrame addProductFrame;

    public static MainShopFrame createNew() {
        MainShopFrame frame = new MainShopFrame();
        frame.frame = frame.initFrame();
        frame.storesFrame = StoresFrame.createNew();
        frame.addProductFrame = AddProductFrame.createNew();
        return frame;
    }

    static FancyViewer viewer = new FancyViewer();

    private GridPane initFrame() {
        GridPane shopGrid = new GridPane();
        GridPane content = ProductsTable.getFrame();

        Label label1 = new Label("Менюшка");
        ContextMenu mainToolbar = new ContextMenu();
        MenuItem shops = new MenuItem("Магазины");
        shops.setOnAction(event -> {
            shopGrid.getChildren().removeIf(node -> FrameType.getContentIds().contains(node.getId()));
            shopGrid.add(storesFrame.getFrame(), 1, 2);
        });

        MenuItem products = new MenuItem("Все товары");
        products.setOnAction(event -> {
            shopGrid.getChildren().removeIf(node -> FrameType.getContentIds().contains(node.getId()));
            shopGrid.add(ProductsTable.getFrame(), 1, 2);
        });

        MenuItem orders = new MenuItem("Заказы");
        orders.setOnAction(event -> {
            shopGrid.getChildren().removeIf(node -> FrameType.getContentIds().contains(node.getId()));
            shopGrid.add(OrderTable.getFrame(), 1, 2);
        });

        MenuItem newProduct = new MenuItem("Добавить новый продукт");
        newProduct.setOnAction(event -> {
            shopGrid.getChildren().removeIf(node -> FrameType.getContentIds().contains(node.getId()));
            shopGrid.add(addProductFrame.getFrame(), 1, 2);
        });

        mainToolbar.getItems().addAll(shops, products, orders, newProduct);

        TilePane tilePane = new TilePane(label1);
        viewer.addPaddings(tilePane, 10);
        label1.setContextMenu(mainToolbar);

        shopGrid.add(tilePane, 0, 0);
        shopGrid.add(content, 1, 2);

        return shopGrid;
    }

    public void setFrame(GridPane frame) {
        this.frame = frame;
    }

    public GridPane getFrame() {
        return frame;
    }
}
