package application.Levels;

import application.Gaming;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class LevelVoldemort {

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
    private Button attackBellatrix;
    @FXML
    private Label warningAvada;

    //attack missed//
    @FXML
    private Label missedAttack;


    // cast spells on specific target ///

    @FXML
    private Button wingardiumVoldemort;
    @FXML
    private Button accioVoldemort;
    @FXML
    private Button expectoVoldemort;
    @FXML
    private Button sectumsempraVoldemort;
    @FXML
    private Button expelliarmusVoldemort;
    @FXML
    private Button wingardiumBellatrix;
    @FXML
    private Button  accioBellatrix;
    @FXML
    private Button expectoBellatrix;
    @FXML
    private Button  sectumsempraBellatrix;
    @FXML
    private Button expelliarmusBellatrix;


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
    private Button expelliarmus;
    @FXML
    private Button sectumsempra;

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
    private Label sectumsempraWarning;
    @FXML
    private Label expelliarmusWarning;
    @FXML
    private Label healthPotionWarning;
    @FXML
    private Label damagePotionWarning;
    @FXML
    private Label manaPotionWarning;



    @FXML
    public void initialize() {
        attackVoldemort.setVisible(false);
        attackBellatrix.setVisible(false);
        returnButton.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        sectumsempra.setVisible(false);
        expelliarmus.setVisible(false);

        wingardiumVoldemort.setVisible(false);
        accioVoldemort.setVisible(false);
        expectoVoldemort.setVisible(false);
        sectumsempraVoldemort.setVisible(false);
        expelliarmusVoldemort.setVisible(false);

        wingardiumBellatrix.setVisible(false);
        accioBellatrix.setVisible(false);
        expectoBellatrix.setVisible(false);
        sectumsempraBellatrix.setVisible(false);
        expelliarmusBellatrix.setVisible(false);


        //messages//
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);

        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        warningAvada.setVisible(false);
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
        expelliarmus.setVisible(true);
        returnButton.setVisible(true);
    }


    @FXML
    private void handleReturn() {
        attack.setVisible(true);
        defend.setVisible(true);
        inventory.setVisible(true);
        spell.setVisible(true);
        attackVoldemort.setVisible(false);
        attackBellatrix.setVisible(false);
        healPotion.setVisible(false);
        damagePotion.setVisible(false);
        manaPotion.setVisible(false);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        sectumsempra.setVisible(false);
        expelliarmus.setVisible(false);
        wingardiumVoldemort.setVisible(false);
        accioVoldemort.setVisible(false);
        expectoVoldemort.setVisible(false);
        sectumsempraVoldemort.setVisible(false);
        expelliarmusVoldemort.setVisible(false);
        wingardiumBellatrix.setVisible(false);
        accioBellatrix.setVisible(false);
        expectoBellatrix.setVisible(false);
        sectumsempraBellatrix.setVisible(false);
        expelliarmusBellatrix.setVisible(false);
        returnButton.setVisible(false);
    }

    @FXML
    private void handleAttackButtonPress() {
        attackVoldemort.setVisible(true);
        attackBellatrix.setVisible(true);
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);
    }

    @FXML
    private void attackVoldemort() throws IOException {
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
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

        if (gaming.checkGameStateBellatrix() && gaming.checkGameStateVoldemort()) {
            gaming.closeVoldemortStage();
        }
    }
    @FXML
    private void attackBellatrix() throws IOException {
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizard.attack(gaming.bellatrix);
        if (gaming.bellatrix.getCurrentHP() == gaming.bellatrix.getPreviousHP()) {
            missedAttack.setVisible(true);
        }
        gaming.bellatrixAttackWizard();
        gaming.putText();
        gaming.putBellatrixInfo();

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateBellatrix() && gaming.checkGameStateVoldemort()) {
            gaming.closeVoldemortStage();
        }
    }

    @FXML
    private void handleDefend() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);



        gaming.wizardDefends();
        gaming.voldemortUsesAvada();
        gaming.bellatrixAttackWizard();
        gaming.wizardStopsDefend();
        gaming.putText();

        if (gaming.warningAvada()) {
            warningAvada.setVisible(true);
        }

        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }
    }

    @FXML
    private void handleWingardium() {
        wingardiumVoldemort.setVisible(true);
        wingardiumBellatrix.setVisible(true);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        sectumsempra.setVisible(false);
        expelliarmus.setVisible(false);

        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);

    }
    @FXML
    private void handleAccio() {
        accioVoldemort.setVisible(true);
        accioBellatrix.setVisible(true);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        sectumsempra.setVisible(false);
        expelliarmus.setVisible(false);

        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);

    }
    @FXML
    private void handleExpecto() {
        expectoBellatrix.setVisible(true);
        expectoVoldemort.setVisible(true);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        sectumsempra.setVisible(false);
        expelliarmus.setVisible(false);


        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);

    }
    @FXML
    private void handleSectumsempra() {
        sectumsempraBellatrix.setVisible(true);
        sectumsempraVoldemort.setVisible(true);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        sectumsempra.setVisible(false);
        expelliarmus.setVisible(false);

        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);

    }
    @FXML
    private void handleExpelliarmus() {
        expelliarmusBellatrix.setVisible(true);
        expelliarmusVoldemort.setVisible(true);
        wingardium.setVisible(false);
        accio.setVisible(false);
        expecto.setVisible(false);
        sectumsempra.setVisible(false);
        expelliarmus.setVisible(false);

        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);

    }

    @FXML
    private boolean handleWingardiumVoldemort() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useWingardiumLeviosa(gaming.voldemort);
        if (!success) {
            wingardiumWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeVoldemortStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return success;
    }

    @FXML
    private boolean handleAccioVoldemort() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useAccio(gaming.voldemort);
        if (!success) {
            accioWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeVoldemortStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return success;
    }
    @FXML
    private boolean handleExpectoVoldemort() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean successExpelliarmus = gaming.wizard.useExpecto(gaming.voldemort);
        if (!successExpelliarmus) {
            expectoWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeVoldemortStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return successExpelliarmus;
    }
    @FXML
    private boolean handleSectumsempraVoldemort() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useSectumsempra(gaming.voldemort);
        if (!success) {
            sectumsempraWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeVoldemortStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return success;
    }
    @FXML
    private boolean handleExpelliarmusVoldemort() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useExpelliarmus(gaming.voldemort);
        if (!success) {
            expelliarmusWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeVoldemortStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return success;
    }

    @FXML
    private boolean handleWingardiumBellatrix() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useWingardiumLeviosa(gaming.bellatrix);
        if (!success) {
            wingardiumWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeVoldemortStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return success;
    }

    @FXML
    private boolean handleAccioBellatrix() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useAccio(gaming.bellatrix);
        if (!success) {
            accioWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeVoldemortStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return success;
    }
    @FXML
    private boolean handleExpectoBellatrix() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useExpecto(gaming.bellatrix);
        if (!success) {
            expectoWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeVoldemortStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return success;
    }
    @FXML
    private boolean handleSectumsempraBellatrix() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useSectumsempra(gaming.bellatrix);
        if (!success) {
            sectumsempraWarning.setVisible(true);
        } else {
            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeHangletonStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return success;
    }
    @FXML
    private boolean handleExpelliarmusBellatrix() throws IOException {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        accioWarning.setVisible(false);
        wingardiumWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);


        boolean success = gaming.wizard.useExpelliarmus(gaming.bellatrix);
        if (!success) {
            expelliarmusWarning.setVisible(true);
        } else {

            gaming.voldemortAttackWizard();
            gaming.bellatrixAttackWizard();
        }
        if (gaming.checkGameStateWizard()) {
            gaming.gameOver();
        }

        if (gaming.checkGameStateVoldemort() && gaming.checkGameStateBellatrix()) {
            gaming.closeHangletonStage();
        }
        gaming.putText();
        gaming.putVoldemortInfo();
        gaming.putBellatrixInfo();
        return success;
    }



    @FXML
    private void handleHealthPotion() {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
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
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
        healthPotionWarning.setVisible(false);
        damagePotionWarning.setVisible(false);
        manaPotionWarning.setVisible(false);

        gaming.wizardUsesDamagePotion();
        gaming.putText();
    }

    @FXML
    private void handleManaPotion() {
        warningAvada.setVisible(false);
        missedAttack.setVisible(false);
        wingardiumWarning.setVisible(false);
        accioWarning.setVisible(false);
        expectoWarning.setVisible(false);
        sectumsempraWarning.setVisible(false);
        expelliarmusWarning.setVisible(false);
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
