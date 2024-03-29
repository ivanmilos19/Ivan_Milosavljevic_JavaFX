package application.Levels;

import application.Gaming;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class LevelBasilic {

    Gaming gaming;
    public LevelBasilic(Gaming gaming) {
        this.gaming = gaming;
    }
    @FXML
    private Button attack;
    @FXML
    private Button godric;
    @FXML
    private Button defend;
    @FXML
    private Button inventory;
    @FXML
    private Button spell;
    @FXML
    private Button attackBasilic;
    @FXML
    private Label warningBite;
    @FXML
    private Label missedAttack;

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


    /////Return to initial choices//////
    @FXML
    private Button returnButton;

    //warning messages//
    @FXML
    private Label wingardiumWarning;
    @FXML
    private Label accioWarning;
    @FXML
    private Label healthPotionWarning;
    @FXML
    private Label damagePotionWarning;
    @FXML
    private Label manaPotionWarning;



    @FXML
    public void initialize() {
        if (gaming.godricSword()) {
            godric.setVisible(true);
            attack.setVisible(false);
        } else {
            attack.setVisible(true);
            godric.setVisible(false);
        }
        attackBasilic.setVisible(false);
        returnButton.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);

        //messages//
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);
        missedAttack.setVisible(false);
        warningBite.setVisible(false);

    }


    @FXML
    private void handleInventoryButtonPress() {
        godric.setVisible(false);
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
        godric.setVisible(false);
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        wingardium.setVisible(true);
        accio.setVisible(true);
        returnButton.setVisible(true);
    }


    @FXML
    private void handleReturn() {
        if (gaming.godricSword()) {
            godric.setVisible(true);
            attack.setVisible(false);
        } else {
            attack.setVisible(true);
            godric.setVisible(false);
        }
        defend.setVisible(true);
        inventory.setVisible(true);
        spell.setVisible(true);
        attackBasilic.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);
        returnButton.setVisible(false);
    }

    @FXML
    private void handleAttackButtonPress() {
        attackBasilic.setVisible(true);
        godric.setVisible(false);
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);
    }

    @FXML
    private void attackBasilic() throws IOException {
        missedAttack.setVisible(false);
        warningBite.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizard.attack(gaming.basilic);
        if (gaming.basilic.getCurrentHP() == gaming.basilic.getPreviousHP()) {
            missedAttack.setVisible(true);
        }
        gaming.basilicUsesBite();
        if (gaming.warningBite()) {
            warningBite.setVisible(true);
        }

        gaming.putText();
        gaming.putBasilicInfo();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateBasilic()) {
            gaming.closeBasilicStage();
        }
    }

    @FXML
    private void handleDefend() throws IOException {
        missedAttack.setVisible(false);
        warningBite.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizardDefends();
        gaming.basilicUsesBite();

        if (gaming.warningBite()) {
            warningBite.setVisible(true);
        }

        gaming.wizardStopsDefend();
        gaming.putText();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateBasilic()) {
            gaming.closeBasilicStage();
        }
    }

    @FXML
    private boolean handleWingardium() throws IOException {
        missedAttack.setVisible(false);
        warningBite.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useWingardiumLeviosa(gaming.basilic);
        if (!success) {
            wingardiumWarning.setVisible(true);
        } else {
            gaming.basilicAttacksWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateBasilic()) {
            gaming.closeBasilicStage();
        }
        gaming.putText();
        gaming.putBasilicInfo();
        return success;
    }

    @FXML
    private boolean handleAccio() throws IOException {
        missedAttack.setVisible(false);
        warningBite.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useAccio(gaming.basilic);
        if (!success) {
            accioWarning.setVisible(true);
        } else {
            gaming.basilicAttacksWizard();
        }

        gaming.basilicUsesBite();
        if (gaming.warningBite()) {
            warningBite.setVisible(true);
        }

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateBasilic()) {
            gaming.closeBasilicStage();
        }
        gaming.putText();
        gaming.putBasilicInfo();
        return success;
    }


    @FXML
    private void handleHealthPotion() {
        missedAttack.setVisible(false);
        warningBite.setVisible(false);
        wingardiumWarning.setVisible(false);
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
        warningBite.setVisible(false);
        wingardiumWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizardUsesDamagePotion();
        gaming.putText();
    }

    @FXML
    private void handleManaPotion() {
        missedAttack.setVisible(false);
        warningBite.setVisible(false);
        wingardiumWarning.setVisible(false);
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
