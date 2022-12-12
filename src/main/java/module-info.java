module interfaz.clasroom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens interfaz.clasroom to javafx.fxml;
    exports interfaz.clasroom;
}
