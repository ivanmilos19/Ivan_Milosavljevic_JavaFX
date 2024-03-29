package application.Transitions;

import application.Gaming;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class Shop {
    Gaming gaming = new Gaming();

    public void setGaming(Gaming gaming) {
        this.gaming = gaming;
    }

    @FXML
    private Label noGoldLeft;

    public void initialize() {
        noGoldLeft.setVisible(false);
    }

    public void buyHealthPotion() {
        gaming.putText();
        noGoldLeft.setVisible(false);
        if (gaming.canBuyHealthPotion()) {
            gaming.putText();
            gaming.showGold();
        } else {
            noGoldLeft.setVisible(true);
        }
    }

    public void buyDamagePotion() {
        gaming.putText();
        noGoldLeft.setVisible(false);
        if (gaming.canBuyDamagePotion()) {
            gaming.showGold();
        } else {
            noGoldLeft.setVisible(true);
        }
    }

    public void buyManaPotion() {
        gaming.putText();
        noGoldLeft.setVisible(false);
        if (gaming.canBuyManaPotion()) {
            gaming.showGold();
        } else {
            noGoldLeft.setVisible(true);
        }
    }

    public void leaveShop() throws IOException {
        switch (gaming.wizard.getLevel()) {
            case 2 -> gaming.createBasilicStage();
            case 3 -> gaming.createDementorStage();
            case 4 -> gaming.createHangletonStage();
            case 5 -> gaming.createDoloresStage();
            case 6 -> gaming.createDeatheaterStage();
            case 7 -> gaming.createVoldemortStage();
            default -> {
            }
        }
        gaming.closeShop();
    }
}
