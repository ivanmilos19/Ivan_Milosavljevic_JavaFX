package application.Levels;

import application.Gaming;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class LevelDeathEater {

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
    private Button attackDeathEater;

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
    @FXML
    private Button sectumsempra;


    /////Return to initial choices//////
    @FXML
    private Button returnButton;

    //warning messages//
    @FXML
    private Label missedAttack;
    @FXML
    private Label wingardiumWarning;
    @FXML
    private Label accioWarning;
    @FXML
    private Label expectoWarning;
    @FXML
    private Label sectumsempraWarning;
    @FXML
    private Label healthPotionWarning;
    @FXML
    private Label damagePotionWarning;
    @FXML
    private Label manaPotionWarning;



    @FXML
    public void initialize() {
        attackDeathEater.setVisible(false);
        returnButton.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        sectumsempra.setVisible(false);

        //messages//
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);

        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);
        missedAttack.setVisible(false);

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
        sectumsempra.setVisible(true);
        returnButton.setVisible(true);
    }


    @FXML
    private void handleReturn() {
        attack.setVisible(true);
        defend.setVisible(true);
        inventory.setVisible(true);
        spell.setVisible(true);
        attackDeathEater.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        sectumsempra.setVisible(false);
        returnButton.setVisible(false);
    }

    @FXML
    private void handleAttackButtonPress() {

        attackDeathEater.setVisible(true);
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);
    }

    @FXML
    private void attackDeathEater() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizard.attack(gaming.deathEater);
        if (gaming.deathEater.getCurrentHP() == gaming.deathEater.getPreviousHP()) {
            missedAttack.setVisible(true);
        }
        gaming.deathEaterAttacksWizard();
        gaming.putText();
        gaming.putDeathEaterInfo();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDeathEater()) {
            gaming.closeDeathEaterStage();
        }
    }

    @FXML
    private void handleDefend() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizardDefends();
        gaming.deathEaterAttacksWizard();
        gaming.wizardStopsDefend();
        gaming.putText();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDeathEater()) {
            gaming.closeDeathEaterStage();
        }
    }

    @FXML
    private boolean handleWingardium() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useWingardiumLeviosa(gaming.deathEater);
        if (!success) {
            wingardiumWarning.setVisible(true);
        } else {
            gaming.deathEaterAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDeathEater()) {
            gaming.closeDeathEaterStage();
        }
        gaming.putText();
        gaming.putDeathEaterInfo();
        return success;
    }

    @FXML
    private boolean handleAccio() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useAccio(gaming.deathEater);
        if (!success) {
            accioWarning.setVisible(true);
        } else {
            gaming.deathEaterAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDeathEater()) {
            gaming.closeDeathEaterStage();
        }
        gaming.putText();
        gaming.putDeathEaterInfo();
        return success;
    }
    @FXML
    private boolean handleExpecto() throws IOException {
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useExpecto(gaming.deathEater);
        if (!success) {
            expectoWarning.setVisible(true);
        } else {
            gaming.deathEaterAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDeathEater()) {
            gaming.closeDeathEaterStage();
        }
        gaming.putText();
        gaming.putDeathEaterInfo();
        return success;
    }

    @FXML
    private boolean handleSectumsempra() throws IOException {
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useSectumsempra(gaming.deathEater);
        if (!success) {
            sectumsempraWarning.setVisible(true);
        } else {
            gaming.deathEaterAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateDeathEater()) {
            gaming.closeDeathEaterStage();
        }
        gaming.putText();
        gaming.putDeathEaterInfo();
        return success;
    }

    @FXML
    private void handleHealthPotion() {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
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
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizardUsesDamagePotion();
        gaming.putText();
    }

    @FXML
    private void handleManaPotion() {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
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
