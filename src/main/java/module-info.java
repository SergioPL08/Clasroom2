module interfaz.tareas2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    //requires de.jends.fontawesomefx;
    
    opens interfaz.tareas2 to javafx.fxml;
    exports interfaz.tareas2;
}
