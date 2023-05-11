package application.Levels;

import application.Gaming;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class LevelTroll {


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

    /////Spells//////

    @FXML
    private Button wingardium;
    // warning troll crit///
    @FXML
    private Label warningMace;

    //attack missed//
    @FXML
    private Label missedAttack;
    /////Return to initial choices//////
    @FXML
    private Button returnButton;

    //warning messages//
    @FXML
    private Label wingardiumWarning;
    @FXML
    private Label healthPotionWarning;
    @FXML
    private Label damagePotionWarning;
    @FXML
    private Label manaPotionWarning;



    @FXML
    public void initialize() {
        warningMace.setVisible(false);
        missedAttack.setVisible(false);

        attackTroll.setVisible(false);
        returnButton.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);

        //messages//
        wingardiumWarning.setVisible(false);
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
        returnButton.setVisible(true);
    }


    @FXML
    private void handleReturn() {
        attack.setVisible(true);
        defend.setVisible(true);
        inventory.setVisible(true);
        spell.setVisible(true);
        attackTroll.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        returnButton.setVisible(false);
    }

    @FXML
    private void handleAttackButtonPress() {
        attackTroll.setVisible(true);
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);
    }

    @FXML
    private void attackTroll() throws IOException {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);
        warningMace.setVisible(false);

        gaming.wizard.attack(gaming.troll);
        if (gaming.troll.getCurrentHP() == gaming.troll.getPreviousHP()) {
            missedAttack.setVisible(true);
        }

        gaming.trollUsesMace();
        gaming.putText();
        gaming.putTrollInfo();

        if (gaming.warningTrollMace()) {
            warningMace.setVisible(true);
        }

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateTroll()) {
            gaming.closeTrollStage();
        }
    }

    @FXML
    private void handleDefend() throws IOException {
        missedAttack.setVisible(false);
        warningMace.setVisible(false);
        wingardiumWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizardDefends();
        gaming.trollUsesMace();
        gaming.wizardStopsDefend();
        gaming.putText();

        if (gaming.warningTrollMace()) {
            warningMace.setVisible(true);
        }

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateTroll()) {
            gaming.closeTrollStage();
        }
    }

    @FXML
    private boolean handleWingardium() throws IOException {
        missedAttack.setVisible(false);
        warningMace.setVisible(false);
        wingardiumWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useWingardiumLeviosa(gaming.troll);
        if (!success) {
            wingardiumWarning.setVisible(true);
        } else {
            gaming.trollAttacksWizard();
        }


        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateTroll()) {
            gaming.closeTrollStage();
        }
        gaming.putText();
        gaming.putTrollInfo();
        return success;
    }

    @FXML
    private void handleHealthPotion() {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);
        warningMace.setVisible(false);

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
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);
        warningMace.setVisible(false);

        gaming.wizardUsesDamagePotion();
        gaming.putText();
    }

    @FXML
    private void handleManaPotion() {
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);
        warningMace.setVisible(false);


        boolean canUseManaPotion = gaming.manaPotionButtonPress();
        if (canUseManaPotion) {
            gaming.putText();
        } else {
            manaPotionWarning.setVisible(true);
        }
        gaming.putText();
    }


}
