package application.Transitions;

import application.Gaming;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class Shop {
    Gaming gaming = new Gaming();
    public void setGaming(Gaming gaming){
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
        if (gaming.wizard.getLevel() == 2) {
            gaming.createBasilicStage();
            gaming.closeShop();
        } if (gaming.wizard.getLevel() == 3) {
            gaming.createDementorStage();
            gaming.closeShop();
        } if (gaming.wizard.getLevel() == 4) {
            gaming.createHangletonStage();
            gaming.closeShop();
        } if (gaming.wizard.getLevel() == 5) {
            gaming.createDoloresStage();
            gaming.closeShop();
        } if (gaming.wizard.getLevel() == 6) {
            gaming.createDeatheaterStage();
            gaming.closeShop();
        }
    }
}
