package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class wizardCreation implements Initializable {

    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> qualityChoice;
    private String[] qualities = {"Daring", "Curious", "Loyal", "Ambitious"};

    @FXML
    private Label petLabel;
    @FXML
    private ChoiceBox<String> petChoice;
    private String[] pets = {"Snowy owl", "Rat", "Toad", "Cat"};

    @FXML
    private Label wandLabel;
    @FXML
    private ChoiceBox<String> wandChoice;
    private String[] wands = {"Dragon Heartstring", "Unicorn hair", "Phoenix feather"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Auto-generated method stub
        qualityChoice.getItems().addAll(qualities);
        qualityChoice.setOnAction(this::getQuality);
        petChoice.getItems().addAll(pets);
        petChoice.setOnAction(this::getPet);
        wandChoice.getItems().addAll(wands);
        wandChoice.setOnAction(this::getWand);
    }

    public void getQuality(ActionEvent event) {
        String myQuality = qualityChoice.getValue();
        myLabel.setText(myQuality);
    }

    public void getPet(ActionEvent event) {
        String myPet = petChoice.getValue();
        petLabel.setText(myPet);
    }

    public void getWand(ActionEvent event) {
        String myWand = wandChoice.getValue();
        wandLabel.setText(myWand);
    }

}
