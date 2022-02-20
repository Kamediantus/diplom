module ru.diplom.diplom {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires json;

    opens ru.diplom.diplom to javafx.fxml;
    exports ru.diplom.diplom;
}