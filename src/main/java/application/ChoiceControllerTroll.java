package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ChoiceControllerTroll {

///////Actions Buttons/////////
  /*  Main main = new Main();
    Wizard wizard = main.getWizard();
    Enemy troll = main.getEnemy(); */

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
    private void handleAttackButtonPress(ActionEvent event) {
      attackTroll.setVisible(true);
        attack.setVisible(false);
        defend.setVisible(false);
        inventory.setVisible(false);
        spell.setVisible(false);
        returnButton.setVisible(true);
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


}
