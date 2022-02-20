package ru.diplom.diplom;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;
import ru.diplom.diplom.components.*;


public class HelloApplication extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(WelcomeFrame.getWelcomeFrame());
        stage.setScene(scene);
        stage.setTitle("Магазинчек");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
    }
}