package ru.diplom.diplom.client.components;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.viewUtils.*;

public class EditFrame {
    static FancyViewer viewer = new FancyViewer();
    public static HBox getStringInput(TextField emailTextField, String label) {
        Label emailLabel = new Label(label);
        viewer.addPaddings(emailLabel, 10);
        HBox result = new HBox();
        result.getChildren().addAll(emailLabel, emailTextField);
        return result;
    }

    public static HBox getPasswordInput(TextField passTextField, String label) {
        Label passwordLabel = new Label(label);
        viewer.addPaddings(passwordLabel, 10);
        HBox result = new HBox();
        result.getChildren().addAll(passwordLabel, passTextField);
        return result;
    }

    public static HBox getDropDownSelector(ComboBox comboBox, String stringLabel) {
        Label label = new Label(stringLabel);
        viewer.addPaddings(label, 10);
        HBox result = new HBox();
        result.getChildren().addAll(label, comboBox);
        return result;
    }
}
