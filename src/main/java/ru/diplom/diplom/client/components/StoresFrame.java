package ru.diplom.diplom.client.components;

import java.util.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.*;
import ru.diplom.diplom.client.services.entity.*;
import ru.diplom.diplom.client.viewUtils.*;

public class StoresFrame extends EditFrame {
    private final static int COL_ID = 0;
    private final static int COL_TITLE = 1;
    private final static int COL_DISCOUNT = 2;

    static FancyViewer viewer = new FancyViewer();
    private GridPane frame;
    private List<Store> stores;

    public static StoresFrame createNew() {
        StoresFrame frame = new StoresFrame();
        frame.frame = frame.initFrame();
        return frame;
    }

    public void refreshEntities() {
        this.stores = StoreService.getAllStores();
    }

    private GridPane initFrame() {
        GridPane storesGrid = new GridPane();
        storesGrid.setId(FrameType.STORES);
        GridPane productsList = new GridPane();

        setColumnsWidth(productsList);

        refreshEntities();

        productsList.setGridLinesVisible(true);
        productsList.add(viewer.addPaddingsAndReturn(new Label("id"), 10), COL_ID, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Название"), 10), COL_TITLE, 0);
        productsList.add(viewer.addPaddingsAndReturn(new Label("Скидка магазина"), 10), COL_DISCOUNT, 0);

        for (int productIndex = 0, rowIndex = 1; productIndex < stores.size(); productIndex++, rowIndex++) {
            productsList.add(viewer.addPaddingsAndReturn(new Label(Long.toString(stores.get(productIndex).getId())), 10), COL_ID, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(stores.get(productIndex).getTitle()), 10), COL_TITLE, rowIndex);
            productsList.add(viewer.addPaddingsAndReturn(new Label(Double.toString(stores.get(productIndex).getDiscount())), 10), COL_DISCOUNT, rowIndex);
           Button buyButton = new Button("");
            buyButton.setId("buy_" + productIndex);
            buyButton.setOnAction(e -> {

            });
            productsList.add(viewer.addPaddingsAndReturn(buyButton, 10), 5, rowIndex);
        }
        storesGrid.add(productsList, 0, 0);
        return storesGrid;
    }

    private static void setColumnsWidth(GridPane gridPane) {
        gridPane.getColumnConstraints().add(COL_ID, new ColumnConstraints(50));
        gridPane.getColumnConstraints().add(COL_TITLE, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(COL_DISCOUNT, new ColumnConstraints(60));
    }

    public GridPane getFrame() {
        this.frame = initFrame();
        return frame;
    }

    public void setFrame(GridPane frame) {
        this.frame = frame;
    }
}
