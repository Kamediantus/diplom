package ru.diplom.diplom.client.components;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.viewUtils.*;
import ru.diplom.diplom.constant.*;
import ru.diplom.diplom.viewUtils.*;

public class OrderTable {
    static FancyViewer viewer = new FancyViewer();

    public static GridPane getFrame() {
        GridPane ordersGrid = new GridPane();
        ordersGrid.setId(FrameType.ORDERS);
        Label test = new Label("here will be your orders");
        ordersGrid.add(test, 0, 0);
        return ordersGrid;
    }
}
