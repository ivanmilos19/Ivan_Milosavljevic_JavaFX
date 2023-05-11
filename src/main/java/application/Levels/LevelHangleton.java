package application.Levels;

import application.Gaming;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class LevelHangleton {

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
    private Button attackVoldemort;
    @FXML
    private Button attackWormtail;
    @FXML
    private Button accioTrophy;



    // cast spells on specific target ///

    @FXML
    private Button wingardiumVoldemort;
    @FXML
    private Button accioVoldemort;
    @FXML
    private Button expectoVoldemort;
    @FXML
    private Button wingardiumWormtail;
    @FXML
    private Button  accioWormtail;
    @FXML
    private Button expectoWormtail;

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
    private Label missedAttack;



    @FXML
    public void initialize() {
        attackVoldemort.setVisible(false);
        attackWormtail.setVisible(false);
        accioTrophy.setVisible(false);
        returnButton.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);

        wingardiumVoldemort.setVisible(false);
        accioVoldemort.setVisible(false);
        expectoVoldemort.setVisible(false);
        wingardiumWormtail.setVisible(false);
        accioWormtail.setVisible(false);
        expectoWormtail.setVisible(false);

        //messages//
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);

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
        returnButton.setVisible(true);
    }


    @FXML
    private void handleReturn() {
        attack.setVisible(true);
        defend.setVisible(true);
        inventory.setVisible(true);
        spell.setVisible(true);
        attackVoldemort.setVisible(false);
        attackWormtail.setVisible(false);
        accioTrophy.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        wingardiumVoldemort.setVisible(false);
        accioVoldemort.setVisible(false);
        expectoVoldemort.setVisible(false);
        wingardiumWormtail.setVisible(false);
        accioWormtail.setVisible(false);
        expectoWormtail.setVisible(false);
        returnButton.setVisible(false);
    }

    @FXML
    private void handleAttackButtonPress() {
        attackVoldemort.setVisible(true);
        attackWormtail.setVisible(true);
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);
    }

    @FXML
    private void attackVoldemort() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizard.attack(gaming.voldemort);
        if (gaming.voldemort.getCurrentHP() == gaming.voldemort.getPreviousHP()) {
            missedAttack.setVisible(true);
        }
        gaming.voldemortAttackWizard();
        gaming.putText();
        gaming.putVoldemortInfo();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateWormtail() && gaming.checkGameStateVoldemort()) {
            gaming.closeHangletonStage();
        }
    }
    @FXML
    private void attackWormtail() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizard.attack(gaming.wormtail);
        if (gaming.wormtail.getCurrentHP() == gaming.wormtail.getPreviousHP()) {
            missedAttack.setVisible(true);
        }
        gaming.wormtailAttacksWizard();
        gaming.putText();
        gaming.putWormtailInfo();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateWormtail() && gaming.checkGameStateVoldemort()) {
            gaming.closeHangletonStage();
        }
    }

    @FXML
    private void handleDefend() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizardDefends();
        gaming.voldemortAttackWizard();
        gaming.wormtailAttacksWizard();
        gaming.wizardStopsDefend();
        gaming.putText();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }
    }

    @FXML
    private void handleWingardium() {
        missedAttack.setVisible(false);
        wingardiumVoldemort.setVisible(true);
        wingardiumWormtail.setVisible(true);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);

        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);

    }
    @FXML
    private void handleAccio() {
        missedAttack.setVisible(false);
        accioVoldemort.setVisible(true);
        accioWormtail.setVisible(true);
        accioTrophy.setVisible(true);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);

        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);

    }
    @FXML
    private void handleExpecto() {
        missedAttack.setVisible(false);
        expectoWormtail.setVisible(true);
        expectoVoldemort.setVisible(true);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);

        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);

    }


    @FXML
    private boolean handleWingardiumVoldemort() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useWingardiumLeviosa(gaming.voldemort);
        if (!success) {
            wingardiumWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.wormtailAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateWormtail()) {
            gaming.closeHangletonStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putWormtailInfo();
        return success;
    }

    @FXML
    private boolean handleAccioVoldemort() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useAccio(gaming.voldemort);
        if (!success) {
            accioWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.wormtailAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateWormtail()) {
            gaming.closeHangletonStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putWormtailInfo();
        return success;
    }
    @FXML
    private boolean handleExpectoVoldemort() throws IOException {
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useExpecto(gaming.voldemort);
        if (!success) {
            expectoWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.wormtailAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateWormtail()) {
            gaming.closeHangletonStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putWormtailInfo();
        return success;
    }

    @FXML
    private boolean handleWingardiumWormtail() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useWingardiumLeviosa(gaming.wormtail);
        if (!success) {
            wingardiumWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.wormtailAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateWormtail()) {
            gaming.closeHangletonStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putWormtailInfo();
        return success;
    }

    @FXML
    private boolean handleAccioWormtail() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useAccio(gaming.wormtail);
        if (!success) {
            accioWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.wormtailAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateWormtail()) {
            gaming.closeHangletonStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putWormtailInfo();
        return success;
    }
    @FXML
    private boolean handleExpectoWormtail() throws IOException {
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useExpecto(gaming.wormtail);
        if (!success) {
            expectoWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.wormtailAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateWormtail()) {
            gaming.closeHangletonStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putWormtailInfo();
        return success;
    }

    @FXML
    private boolean handleAccioTrophy() throws IOException {
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        boolean success = gaming.wizard.useAccio(gaming.trophy);

        if (!success) {
            accioWarning.setVisible(true);
        } else {
            gaming.closeHangletonStage();
        }
        return success;
    }


    @FXML
    private void handleHealthPotion() {
        missedAttack.setVisible(false);
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
        missedAttack.setVisible(false);
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
        missedAttack.setVisible(false);
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
