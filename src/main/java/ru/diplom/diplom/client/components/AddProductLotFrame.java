package ru.diplom.diplom.client.components;

import java.util.*;
import java.util.stream.*;

import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.*;
import ru.diplom.diplom.client.services.entity.*;

public class AddProductLotFrame extends EditFrame {
    private Pane frame;
    private List<Store> storesList;
    private List<Product> productList;

    private ComboBox productInput;
    private HBox productsBox;
    private ComboBox storesInput;
    private HBox storesBox;
    private DatePicker produceDateInput;
    private HBox produceDateBox;
    private TextField countInput;
    private HBox countBox;

    public static AddProductLotFrame createNew() {
        AddProductLotFrame frame = new AddProductLotFrame();
        frame.refreshEntities();
        frame.frame = frame.initFrame();
        return frame;
    }

    private GridPane initFrame() {
        GridPane addProductFrame = new GridPane();
        addProductFrame.setId(FrameType.ADD_PRODUCT_LOT);
        addProductFrame.add(new Label("Добавление новоЙ партии товара"), 0, 0);

        ObservableList<Store> stores = FXCollections.observableArrayList();
        getStoresList().forEach(store -> {
            stores.add(store);
        });

        ObservableList<Product> products = FXCollections.observableArrayList();
        getProductList().forEach(product -> {
            products.add(product);
        });

        productInput = new ComboBox(FXCollections.observableArrayList(productList.stream().map(product -> product.getId() + ". " + product.getTitle()).collect(Collectors.toList())));
        productsBox = getDropDownSelector(productInput, "Товар: ");

        storesInput = new ComboBox(FXCollections.observableArrayList(stores.stream().map(store -> store.getId() + ". " + store.getTitle()).collect(Collectors.toList())));
        storesInput.setOnAction(event -> {
            Long selectedStoreId = getIdFromSelector(storesInput);
            productInput.getItems().clear();
            productInput.getItems().addAll(ProductService.getProductsByStoreId(selectedStoreId).stream().map(product -> product.getId() + ". " + product.getTitle()).collect(Collectors.toList()));
        });
        storesBox = getDropDownSelector(storesInput, "Магазин: ");

        produceDateInput = new DatePicker();
        produceDateBox = getDatePicker(produceDateInput, "Дата производства: ");

        countInput = new TextField();
        countBox = getNumericInput(countInput, "Количество товара: ");


        Button addProduct = new Button("Добавить партию");
        addProduct.setOnAction(e -> {
            ProductLotService.addProduct(getIdFromSelector(storesInput), getIdFromSelector(productInput), Integer.parseInt(countInput.getText()), produceDateInput.getValue());
            produceDateInput.getValue();
        });

        HBox buttons = new HBox(25);
        buttons.getChildren().addAll(viewer.addPaddingsAndReturn(addProduct, 10));

        addProductFrame.add(storesBox, 0, 1, 2, 1);
        addProductFrame.add(productsBox, 0, 2, 2, 1);
        addProductFrame.add(produceDateBox, 0, 3, 2, 1);
        addProductFrame.add(countBox, 0, 4, 2, 1);
        addProductFrame.add(buttons, 0, 5);
        viewer.addPaddings(addProductFrame, 100);

        return addProductFrame;
    }

    public GridPane getFrame() {
        this.refreshEntities();
        return initFrame();
    }

    public void setFrame(GridPane frame) {
        this.frame = frame;
    }

    public void setFrame(Pane frame) {
        this.frame = frame;
    }

    public List<Store> getStoresList() {
        return storesList;
    }

    public void setStoresList(List<Store> storesList) {
        this.storesList = storesList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void refreshEntities() {
        this.storesList = StoreService.getAllStores();
        this.productList = ProductService.getAllProducts();
    }

    public void refreshProductsByStore(Long storeId) {
        this.productList = ProductService.getProductsByStoreId(storeId);
    }
}
