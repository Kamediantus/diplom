package ru.diplom.diplom;

import javafx.application.Application;
import javafx.scene.*;

import javafx.scene.layout.*;
import javafx.stage.Stage;
import ru.diplom.diplom.client.components.*;


public class HelloApplication extends Application{
    private WelcomeFrame frame;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.frame = WelcomeFrame.createNew();
        Scene scene = new Scene(frame.getFrame());
        stage.setScene(scene);
        stage.setTitle("Магазинчек");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
    }
}