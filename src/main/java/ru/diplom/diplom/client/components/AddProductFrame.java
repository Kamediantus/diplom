package ru.diplom.diplom.client.components;

import java.util.*;

import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.*;
import ru.diplom.diplom.client.services.entity.*;

public class AddProductFrame extends EditFrame{
    private GridPane frame;
    private List<Store> stores;

    public static AddProductFrame createNew() {
        AddProductFrame frame = new AddProductFrame();
        frame.frame = frame.initFrame();
        frame.stores = StoreService.getAllStores();
        return frame;
    }

    private GridPane initFrame() {
        GridPane addProductFrame = new GridPane();
        addProductFrame.setId(FrameType.ADD_PRODUCT);
        addProductFrame.add(new Label("Добавление нового товара"), 0, 0);

        TextField title = new TextField();
        HBox emailInput = getStringInput(title, "Название: ");

        TextField description = new TextField();
        HBox nameInput = getStringInput(description, "Описание: ");

        ObservableList<String> stores = FXCollections.observableArrayList();

        final ComboBox comboBox = new ComboBox();
        TextField surnameTextField = new TextField();
        HBox surnameInput = getDropDownSelector(comboBox, "Surname: ");

        PasswordField passwordTextField = new PasswordField();
        HBox passwordInput = getPasswordInput(passwordTextField, "Password: ");

        PasswordField passwordConfirmTextField = new PasswordField();
        HBox passwordConfirmInput = getPasswordInput(passwordConfirmTextField, "Confirm password: ");

        Button singIn = new Button("Sing in");
        singIn.setOnAction(e -> {
            //
        });

        Button singUp = new Button("Sing up");
        singUp.setOnAction(e -> {
            //
        });

        HBox buttons = new HBox(25);
        viewer.addPaddings(singIn, singUp);
        buttons.getChildren().addAll(singIn, singUp);

        addProductFrame.add(emailInput, 0, 1, 2, 1);
        addProductFrame.add(nameInput, 0, 2, 2, 1);
        addProductFrame.add(surnameInput, 0, 3, 2, 1);
        addProductFrame.add(passwordInput, 0, 4, 2, 1);
        addProductFrame.add(passwordConfirmInput, 0, 5, 2, 1);
        addProductFrame.add(buttons, 0, 6);
        viewer.addPaddings(addProductFrame, 100);

        return addProductFrame;
    }

    public GridPane getFrame() {
        return frame;
    }

    public void setFrame(GridPane frame) {
        this.frame = frame;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
