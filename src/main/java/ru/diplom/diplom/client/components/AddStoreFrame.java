package ru.diplom.diplom.client.components;

import java.util.*;

import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.*;
import ru.diplom.diplom.client.services.entity.*;

public class AddStoreFrame extends EditFrame{
    private GridPane frame;
    private List<Store> storesList;

    private TextField titleInput;
    private HBox titleBox;
    private TextField discountInput;
    private HBox discountBox;



    public static AddStoreFrame createNew() {
        AddStoreFrame frame = new AddStoreFrame();
        frame.storesList = StoreService.getAllStores();
        frame.frame = frame.initFrame();
        return frame;
    }

    private GridPane initFrame() {
        GridPane addProductFrame = new GridPane();
        addProductFrame.setId(FrameType.ADD_STORE);
        addProductFrame.add(new Label("Добавление нового магазина"), 0, 0);

        titleInput = new TextField();
        titleBox = getStringInput(titleInput, "Название: ");

        ObservableList<Store> stores = FXCollections.observableArrayList();
        getStores().forEach(store -> {
            stores.add(store);
        });


        discountInput = new TextField();
        discountBox = getStringInput(discountInput, "Скидка от магазина: ");

        Button addStore = new Button("Добавить магазин");
        addStore.setOnAction(e -> {
            Map<Boolean, String> response =  StoreService.addStore(titleInput.getText(), discountInput.getText(), storesList);
            if (response.keySet().stream().findFirst().get()) {
                //success
            } else {
                System.out.println(response.get(false));
            }
        });

        HBox buttons = new HBox(25);
        buttons.getChildren().addAll(viewer.addPaddingsAndReturn(addStore, 10));

        addProductFrame.add(titleBox, 0, 1, 2, 1);
        addProductFrame.add(discountBox, 0, 2, 2, 1);
        addProductFrame.add(buttons, 0, 3);
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
        return storesList;
    }

    public void setStores(List<Store> stores) {
        this.storesList = stores;
    }
}
