module com.example.autosimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens com.example.autosimulator to javafx.fxml;
    exports com.example.autosimulator;
}