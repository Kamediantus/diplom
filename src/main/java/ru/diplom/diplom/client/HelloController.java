package ru.diplom.diplom.client;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Button btn;

    @FXML
    protected void onClick() {
        btn.setText("Welcome to JavaFX Application!");
    }
}