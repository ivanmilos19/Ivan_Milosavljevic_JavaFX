module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires lombok;

    opens application to javafx.fxml;
    exports application;
}