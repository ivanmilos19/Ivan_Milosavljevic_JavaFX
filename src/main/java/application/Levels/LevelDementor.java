package application.Levels;

import application.Gaming;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class LevelDementor {



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
    private Button attackDementor;

    ///////Potions Buttons/////////
    @FXML
    private Button healPotion;
    @FXML
    private Button damagePotion;
    @FXML
    private Button manaPotion;

    /////Spells//////

    @FXML
    private Button wingardium;
    @FXML
    private Button accio;
    @FXML
    private Button expecto;


    /////Return to initial choices//////
    @FXML
    private Button returnButton;

    //warning messages//
    @FXML
    private Label wingardiumWarning;
    @FXML
    private Label accioWarning;
    @FXML
    private Label expectoWarning;
    @FXML
    private Label healthPotionWarning;
    @FXML
    private Label damagePotionWarning;
    @FXML
    private Label manaPotionWarning;



    @FXML
    public void initialize() {
        attackDementor.setVisible(false);
        returnButton.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);

        //messages//
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);

        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);
    }


    @FXML
    private void handleInventoryButtonPress() {
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
    private void handleSpellPress() {
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        wingardium.setVisible(true);
        accio.setVisible(true);
        expecto.setVisible(true);
        returnButton.setVisible(true);
    }


    @FXML
    private void handleReturn() {
        attack.setVisible(true);
        defend.setVisible(true);
        inventory.setVisible(true);
        spell.setVisible(true);
        attackDementor.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        returnButton.setVisible(false);
    }

    @FXML
    private void handleAttackButtonPress() {
        attackDementor.setVisible(true);
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);
    }

    @FXML
    private void attackDementor() throws IOException {
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizard.attack(gaming.dementor);
        gaming.dementorAttacksWizard();
        gaming.putText();
        gaming.putDementorInfo();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDementor()) {
            gaming.closeDementorStage();
        }
    }

    @FXML
    private void handleDefend() throws IOException {
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizardDefends();
        gaming.dementorAttacksWizard();
        gaming.wizardStopsDefend();
        gaming.putText();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDementor()) {
            gaming.closeDementorStage();
        }
    }

    @FXML
    private boolean handleWingardium() throws IOException {
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useWingardiumLeviosa(gaming.dementor);
        if (!success) {
            wingardiumWarning.setVisible(true);
        } else {
            gaming.dementorAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDementor()) {
            gaming.closeDementorStage();
        }
        gaming.putText();
        gaming.putDementorInfo();
        return success;
    }

    @FXML
    private boolean handleAccio() throws IOException {
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useAccio(gaming.dementor);
        if (!success) {
            accioWarning.setVisible(true);
        } else {
            gaming.dementorAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDementor()) {
            gaming.closeDementorStage();
        }
        gaming.putText();
        gaming.putDementorInfo();
        return success;
    }
    @FXML
    private boolean handleExpecto() throws IOException {
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useExpecto(gaming.dementor);
        if (!success) {
            expectoWarning.setVisible(true);
        } else {
            gaming.dementorAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDementor()) {
            gaming.closeDementorStage();
        }
        gaming.putText();
        gaming.putDementorInfo();
        return success;
    }


    @FXML
    private void handleHealthPotion() {
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        boolean canUseHealthPotion = gaming.healthPotionButtonPress();
        if (canUseHealthPotion) {
            gaming.putText();
        } else {
            healthPotionWarning.setVisible(true);
        }
        gaming.putText();
    }

    @FXML
    private void handleDamagePotion() {
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizardUsesDamagePotion();
        gaming.putText();
    }

    @FXML
    private void handleManaPotion() {
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        boolean canUseManaPotion = gaming.manaPotionButtonPress();
        if (canUseManaPotion) {
            gaming.putText();
        } else {
            manaPotionWarning.setVisible(true);
        }
        gaming.putText();
    }
}
