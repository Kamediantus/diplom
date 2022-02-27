package ru.diplom.diplom.client.components;

import java.util.*;
import java.util.stream.*;

import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.*;
import ru.diplom.diplom.client.services.entity.*;

public class AddProductFrame extends EditFrame{
    private GridPane frame;
    private List<Store> storesList;

    private TextField titleInput;
    private HBox emailBox;
    private TextField descriptionInput;
    private HBox nameBox;
    private ComboBox storesInput;
    private HBox storesBox;
    private TextField priceInput;
    private HBox priceBox;
    private TextField selfLifeInput;
    private HBox selfLifeBox;


    public static AddProductFrame createNew() {
        AddProductFrame frame = new AddProductFrame();
        frame.refreshEntities();
        frame.frame = frame.initFrame();
        return frame;
    }

    private GridPane initFrame() {
        GridPane addProductFrame = new GridPane();
        addProductFrame.setId(FrameType.ADD_PRODUCT);
        addProductFrame.add(new Label("Добавление нового товара"), 0, 0);

        titleInput = new TextField();
        emailBox = getStringInput(titleInput, "Название: ");

        descriptionInput = new TextField();
        nameBox = getStringInput(descriptionInput, "Описание: ");

        ObservableList<Store> stores = FXCollections.observableArrayList();
        getStores().forEach(store -> {
            stores.add(store);
        });

        storesInput = new ComboBox(FXCollections.observableArrayList(stores.stream().map(store -> store.getTitle()).collect(Collectors.toList())));
        storesBox = getDropDownSelector(storesInput, "Магазин: ");

        priceInput = new TextField();
        priceBox = getStringInput(priceInput, "Цена: ");

        selfLifeInput = new TextField();
        selfLifeBox = getNumericInput(selfLifeInput, "Срок годности в часах: ");

        Button addProduct = new Button("Добавить товар");
        addProduct.setOnAction(e -> {
            Map<Boolean, String> response =  ProductService.addProduct(titleInput.getText(), descriptionInput.getText(), priceInput.getText(),
                    selfLifeInput.getText(), storesInput.getSelectionModel().getSelectedItem().toString(), storesList);
            if (response.keySet().stream().findFirst().get()) {
                //success
            } else {
                System.out.println(response.get(false));
            }
        });

        HBox buttons = new HBox(25);
        buttons.getChildren().addAll(viewer.addPaddingsAndReturn(addProduct, 10));

        addProductFrame.add(emailBox, 0, 1, 2, 1);
        addProductFrame.add(nameBox, 0, 2, 2, 1);
        addProductFrame.add(storesBox, 0, 3, 2, 1);
        addProductFrame.add(priceBox, 0, 4, 2, 1);
        addProductFrame.add(selfLifeBox, 0, 5, 2, 1);
        addProductFrame.add(buttons, 0, 6);
        viewer.addPaddings(addProductFrame, 100);

        return addProductFrame;
    }

    public GridPane getFrame() {
        this.refreshEntities();
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

    public void refreshEntities() {
        this.storesList = StoreService.getAllStores();
    }
}
