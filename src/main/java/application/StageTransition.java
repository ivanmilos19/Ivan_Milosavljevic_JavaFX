package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StageTransition {
    Gaming gaming = new Gaming();
    public void setGaming(Gaming gaming){
        this.gaming = gaming;
    }
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;

    public void handleYesButton() throws IOException {
        gaming.createShop();
        gaming.closeStage();
    }
    public void handleNoButton() throws IOException {
        gaming.createDementorStage();
        gaming.closeStage();
    }
}
