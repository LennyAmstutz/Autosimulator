module com.example.autosimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.autosimulator to javafx.fxml;
    exports com.example.autosimulator;
}