package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class LevelTroll {

///////Actions Buttons/////////
  /*  Main main = new Main();
    Wizard wizard = main.getWizard();
    Enemy troll = main.getEnemy(); */


    Gaming gaming = new Gaming();
    public void setGaming(Gaming gaming){
        this.gaming = gaming;
    }
    @FXML
    private Button attack;
    @FXML
    private Button defend;
    @FXML
    private Button inventory;
    @FXML
    private Button spell;
    @FXML
    private Button attackTroll;

    ///////Potions Buttons/////////
    @FXML
    private Button healPotion;
    @FXML
    private Button damagePotion;
    @FXML
    private Button manaPotion;

    /////Return to initial choices//////
    @FXML
    private Button returnButton;



    @FXML
    public void initialize() {
        attackTroll.setVisible(false);
        returnButton.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);

    }


    @FXML
    private void handleInventoryButtonPress(ActionEvent event) {
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        healPotion.setVisible(true);
        damagePotion.setVisible(true);
        manaPotion.setVisible(true);
        returnButton.setVisible(true);
    }


    @FXML
    private void handleReturn(ActionEvent event) {
        attack.setVisible(true);
        defend.setVisible(true);
        inventory.setVisible(true);
        spell.setVisible(true);
        attackTroll.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        returnButton.setVisible(false);
    }

    @FXML
    private void handleAttackButtonPress(ActionEvent event) {
        attackTroll.setVisible(true);
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);
    }

    @FXML
    private void attackTroll(ActionEvent event) throws IOException {
        gaming.wizardAttackTroll();
        gaming.trollAttackWizard();
        gaming.putText();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateTroll()) {
            gaming.closeTrollStage();
        }
    }

    @FXML
    private void handleDefend(ActionEvent event) throws IOException {
        gaming.wizardDefends();
        gaming.trollAttackWizard();
        gaming.wizardStopsDefend();
        gaming.putText();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateTroll()) {
            gaming.closeTrollStage();
        }
    }

    @FXML
    private void handleHealthPotion(ActionEvent event) {
        gaming.wizardUsesHealthPotion();
        gaming.putText();
    }

    @FXML
    private void handleDamagePotion(ActionEvent event) {
        gaming.wizardUsesDamagePotion();
        gaming.putText();
    }

    @FXML
    private void handleManaPotion(ActionEvent event) {
        gaming.wizardUsesManaPotion();
        gaming.putText();
    }


}
