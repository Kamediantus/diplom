package ru.diplom.diplom.client.components;

import javafx.beans.value.*;
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

    public static HBox getNumericInput(TextField textField, String label) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        Label passwordLabel = new Label(label);
        viewer.addPaddings(passwordLabel, 10);
        HBox result = new HBox();
        result.getChildren().addAll(passwordLabel, textField);
        return result;
    }

    public static HBox getNumericInput(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        HBox result = new HBox();
        result.getChildren().addAll(textField);
        return result;
    }

    public static HBox getDropDownSelector(ComboBox comboBox, String stringLabel) {
        Label label = new Label(stringLabel);
        viewer.addPaddings(label, 10);
        HBox result = new HBox();
        result.getChildren().addAll(label, comboBox);
        return result;
    }

    public static HBox getDatePicker(DatePicker datePicker, String stringLabel) {
        Label label = new Label(stringLabel);
        viewer.addPaddings(label, 10);
        HBox result = new HBox();
        result.getChildren().addAll(label, datePicker);
        return result;
    }

    public static Long getIdFromSelector(ComboBox input) {
        return Long.valueOf(input.getSelectionModel().getSelectedItem().toString().substring(0,input.getSelectionModel().getSelectedItem().toString().indexOf(".")));
    }
}
