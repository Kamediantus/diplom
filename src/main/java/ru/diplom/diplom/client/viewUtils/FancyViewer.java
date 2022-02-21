package ru.diplom.diplom.client.viewUtils;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FancyViewer {
    public void addPaddings(Control target, int padding) {
        target.setPadding(new Insets(padding, padding, padding, padding));
    }

    public Control addPaddingsAndReturn(Control target, int padding) {
        target.setPadding(new Insets(padding, padding, padding, padding));
        return target;
    }

    public void addPaddings(Control... targets) {
        for (Control target: targets) {
            addPaddings(target, 25);
        }
    }

    public void addPaddings(Pane target, int padding) {
        target.setPadding(new Insets(padding, padding, padding, padding));
    }

    public Pane addPaddingsAndReturn(Pane target, int padding) {
        target.setPadding(new Insets(padding, padding, padding, padding));
        return target;
    }
}
