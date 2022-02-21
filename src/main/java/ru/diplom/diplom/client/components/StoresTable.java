package ru.diplom.diplom.client.components;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.viewUtils.*;
import ru.diplom.diplom.constant.*;
import ru.diplom.diplom.viewUtils.*;

public class StoresTable {
    static FancyViewer viewer = new FancyViewer();

    public static GridPane getFrame() {
        GridPane storesGrid = new GridPane();
        storesGrid.setId(FrameType.STORES);
        Label test = new Label("here will be shop list");
        storesGrid.add(test, 0, 0);
        return storesGrid;
    }
}
