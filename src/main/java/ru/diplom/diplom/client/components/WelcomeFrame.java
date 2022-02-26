package ru.diplom.diplom.client.components;

import java.util.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.*;
import ru.diplom.diplom.client.viewUtils.*;

public class WelcomeFrame {
    static FancyViewer viewer = new FancyViewer();

    public static GridPane getFrame() {
        GridPane parent = new GridPane();
        parent.add(getSingInFrame(), 0, 0);
        return parent;
    }

    public static GridPane getSingInFrame() {
        GridPane singInGrid = new GridPane();
        singInGrid.setId(FrameType.SING_IN);
        singInGrid.add(new Label("Sing in"), 0, 0);

        TextField emailTextField = new TextField();
        HBox emailInput = getEmailInput(emailTextField, "Email: ");

        PasswordField passwordTextField = new PasswordField();
        HBox passwordInput = getPasswordInput(passwordTextField, "Password: ");

        Button singIn = new Button("Sing in");
        singIn.setOnAction(e -> {
            if (LoginService.login(emailTextField.getText(), passwordTextField.getText())) {
//            if (true) {
                Stage oldStage = (Stage) singIn.getScene().getWindow();
                oldStage.close();
                Parent root1 = MainShopFrame.getFrame();
                Stage stage = new Stage();
                stage.setTitle("ABC");
                stage.setWidth(800);
                stage.setHeight(600);
                stage.setScene(new Scene(root1));
                stage.show();
            }
        });

        Button singUp = new Button("Sing up");
        singUp.setOnAction(e -> {
            GridPane parent = (GridPane) singInGrid.getParent();
            ((GridPane) singInGrid.getParent()).getChildren().removeIf(child -> child.getId().equalsIgnoreCase(FrameType.SING_IN));
            parent.add(getSingUpFrame(), 0 , 0);
        });

        HBox buttons = new HBox(25);
        viewer.addPaddings(singIn, singUp);
        buttons.getChildren().addAll(singIn, singUp);

        singInGrid.add(emailInput, 0, 1, 2, 1);
        singInGrid.add(passwordInput, 0, 2, 2, 1);
        singInGrid.add(buttons, 0, 3);
        viewer.addPaddings(singInGrid, 100);

        return singInGrid;
    }

    public static GridPane getSingUpFrame() {
        GridPane singUpGrid = new GridPane();
        singUpGrid.setId(FrameType.SING_UP);
        singUpGrid.add(new Label("Sing up"), 0, 0);

        TextField emailTextField = new TextField();
        HBox emailInput = getEmailInput(emailTextField, "Email: ");

        TextField nameTextField = new TextField();
        HBox nameInput = getEmailInput(nameTextField, "Name: ");

        TextField surnameTextField = new TextField();
        HBox surnameInput = getEmailInput(surnameTextField, "Surname: ");

        PasswordField passwordTextField = new PasswordField();
        HBox passwordInput = getPasswordInput(passwordTextField, "Password: ");

        PasswordField passwordConfirmTextField = new PasswordField();
        HBox passwordConfirmInput = getPasswordInput(passwordConfirmTextField, "Confirm password: ");

        Button singIn = new Button("Sing in");
        singIn.setOnAction(e -> {
            GridPane parent = (GridPane) singUpGrid.getParent();
            ((GridPane) singUpGrid.getParent()).getChildren().removeIf(child -> child.getId().equalsIgnoreCase(FrameType.SING_UP));
            parent.add(getSingInFrame(), 0 , 0);
        });

        Button singUp = new Button("Sing up");
        singUp.setOnAction(e -> {
            if (!Objects.equals(passwordTextField.getText(), passwordConfirmTextField.getText())) {
                // password mismatch
            } else {
                if (LoginService.sungUp(emailTextField.getText(), passwordTextField.getText(),
                        nameTextField.getText(), surnameTextField.getText())) {
                    GridPane parent = (GridPane) singUpGrid.getParent();
                    ((GridPane) singUpGrid.getParent()).getChildren().removeIf(child -> child.getId().equalsIgnoreCase(FrameType.SING_UP));
                    parent.add(getSingInFrame(), 0 , 0);
                }
            }
        });

        HBox buttons = new HBox(25);
        viewer.addPaddings(singIn, singUp);
        buttons.getChildren().addAll(singIn, singUp);

        singUpGrid.add(emailInput, 0, 1, 2, 1);
        singUpGrid.add(nameInput, 0, 2, 2, 1);
        singUpGrid.add(surnameInput, 0, 3, 2, 1);
        singUpGrid.add(passwordInput, 0, 4, 2, 1);
        singUpGrid.add(passwordConfirmInput, 0, 5, 2, 1);
        singUpGrid.add(buttons, 0, 6);
        viewer.addPaddings(singUpGrid, 100);

        return singUpGrid;
    }


    private static HBox getEmailInput(TextField emailTextField, String label) {
        Label emailLabel = new Label(label);
        viewer.addPaddings(emailLabel, 10);
        HBox result = new HBox();
        result.getChildren().addAll(emailLabel, emailTextField);
        return result;
    }

    private static HBox getPasswordInput(TextField passTextField, String label) {
        Label passwordLabel = new Label(label);
        viewer.addPaddings(passwordLabel, 10);
        HBox result = new HBox();
        result.getChildren().addAll(passwordLabel, passTextField);
        return result;
    }
}
