package ru.diplom.diplom.components;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.services.*;
import ru.diplom.diplom.viewUtils.*;

public class WelcomeFrame {
    static FancyViewer viewer = new FancyViewer();

    public static GridPane getWelcomeFrame() {
        Label emailLabel = new Label("Email:");
        viewer.addPaddings(emailLabel, 10);
        TextField emailTextField = new TextField();
        HBox emailInput = new HBox();
        emailInput.getChildren().addAll(emailLabel, emailTextField);

        Label passwordLabel = new Label("Password:");
        viewer.addPaddings(passwordLabel, 10);
        PasswordField passwordTextField = new PasswordField();
        HBox passwordInput = new HBox();
        passwordInput.getChildren().addAll(passwordLabel, passwordTextField);

        Button singIn = new Button("Sing in");
        singIn.setOnAction(e -> {
            LoginService.login("imail", "pass");
        });

        Button singUp = new Button("Sing up");

        HBox buttons = new HBox(25);
        viewer.addPaddings(singIn, singUp);
        buttons.getChildren().addAll(singIn, singUp);

        GridPane welcomeGrid = new GridPane();
        welcomeGrid.add(emailInput, 0, 1, 2, 1);
        welcomeGrid.add(passwordInput, 0, 2, 2, 1);
        welcomeGrid.add(buttons, 0, 3);
        viewer.addPaddings(welcomeGrid, 100);

        return welcomeGrid;
    }
}
