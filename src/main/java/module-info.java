module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires lombok;

    opens application to javafx.fxml;
    exports application;
    exports application.StageTransitions;
    opens application.StageTransitions to javafx.fxml;
    exports application.Shops;
    opens application.Shops to javafx.fxml;
    exports application.Levels;
    opens application.Levels to javafx.fxml;
    exports application.Houses;
    opens application.Houses to javafx.fxml;
    exports application.Characters;
    opens application.Characters to javafx.fxml;
}