package ru.diplom.diplom.client.components;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.viewUtils.*;

public class StoresFrame extends EditFrame {
    static FancyViewer viewer = new FancyViewer();
    private GridPane frame;

    public static StoresFrame createNew() {
        StoresFrame frame = new StoresFrame();
        frame.frame = frame.initFrame();
        return frame;
    }

    private GridPane initFrame() {
        GridPane storesGrid = new GridPane();
        storesGrid.setId(FrameType.STORES);
        Label test = new Label("here will be shop list");
        storesGrid.add(test, 0, 0);
        return storesGrid;
    }

    public GridPane getFrame() {
        return frame;
    }

    public void setFrame(GridPane frame) {
        this.frame = frame;
    }
}
