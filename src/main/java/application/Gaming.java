package application;

import application.Characters.Boss;
import application.Characters.Enemy;
import application.Characters.Wizard;
import application.Houses.*;
import application.Levels.LevelBasilic;
import application.Levels.LevelDementor;
import application.Levels.LevelTroll;
import application.Shops.ShopStageBasilic;
import application.StageTransitions.StageTransitionBasilic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Gaming implements Initializable {

    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> qualityChoice;
    private String[] qualities = {"Daring", "Curious", "Loyal", "Ambitious"};

    @FXML
    private Label petLabel;
    @FXML
    private ChoiceBox<String> petChoice;
    private String[] pets = {"Snowy owl", "Rat", "Toad", "Cat"};

    @FXML
    private Label wandLabel;
    @FXML
    private ChoiceBox<String> wandChoice;
    private String[] wands = {"Dragon Heartstring", "Unicorn hair", "Phoenix feather"};


    @FXML
    private Button startGame;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Auto-generated method stub
        qualityChoice.getItems().addAll(qualities);
        qualityChoice.setOnAction(this::getQuality);
        petChoice.getItems().addAll(pets);
        petChoice.setOnAction(this::getPet);
        wandChoice.getItems().addAll(wands);
        wandChoice.setOnAction(this::getWand);
        startGame.setVisible(false);
    }

    private House house;

    public void getQuality(ActionEvent event) {
        String myQuality = qualityChoice.getValue();
        myLabel.setText(myQuality);
        if (myQuality == "Daring")
            house = new Gryffindor();
        else if (myQuality == "Curious") {
            house = new Ravenclaw();
        } else if (myQuality == "Loyal") {
            house = new Hufflepuff();
        } else if (myQuality == "Ambitious") {
            house = new Slytherin();
        }
    }

    public void getPet(ActionEvent event) {
        String myPet = petChoice.getValue();
        petLabel.setText(myPet);
    }

    public void getWand(ActionEvent event) {
        String myWand = wandChoice.getValue();
        wandLabel.setText(myWand);
    }


    public Wizard wizard;
    public Enemy troll;
    public Boss basilic;
    public Enemy dementor;

    public void createWizard(ActionEvent event) {
        if (house != null) {
            wizard = Wizard.builder().currentHP(500)
                    .previousHP(500)
                    .baseHP(500)
                    .level(1)
                    .accuracy(0.85 + house.precision())
                    .joinedEnemy(false)


                    .healthPotions(new ArrayList<>())
                    .manaPotions(new ArrayList<>())
                    .damagePotions(new ArrayList<>())

                    .wingardiumLeviosa(new ArrayList<>())
                    .expectoPatronum(new ArrayList<>())
                    .accio(new ArrayList<>())
                    .sectumsempra(new ArrayList<>())
                    .expelliarmus(new ArrayList<>())

                    .attack_strength((int) (400 * house.attackMultiplier()))
                    .manaPool(150)
                    .currentmanaPool(150)

                    .wingardiumManaUsage(15)
                    .wingardiumCrit(5)
                    .wingardiumDmg(70)

                    .expectoCrit(99999)
                    .expectoDmg(40)
                    .expectoManaUsage(80)

                    .expelliarmusDmg(250)
                    .expellarmusManaUsg(30)

                    .accioDmg(150)
                    .accioManaUsage(15)

                    .sectumsempraDmg(450)
                    .sectumsempraManaUsg(70)

                    .Gold(70)
                    .build();


            wizard.addHealthPotion(new Potion());
            wizard.addDamagePotion(new Potion());
            wizard.addManaPotion(new Potion());

            wizard.addHealthPotion(new Potion());
            wizard.addDamagePotion(new Potion());
            wizard.addManaPotion(new Potion());


            // add spells
            wizard.addSpell(new Spell());
            wizard.addSpell(new Spell());

            startGame.setVisible(true);
        }
    }


    Text textHP = new Text();
    Text textMana = new Text();
    Text textAttack = new Text();
    Text textAccuracy = new Text();
    Text levelText = new Text();
    Text gold = new Text();

    Text trollInfo = new Text();
    Text basilicInfo = new Text();
    Text dementorInfo = new Text();

    Text numberHealthPotions = new Text();



    public void putText() {
        textHP.setText("Wizard HP: " + wizard.getCurrentHP() + "/" + wizard.getBaseHP() + " ❤" + "   |");
        textHP.getStyleClass().add("HP");

        textMana.setText("Mana: " + wizard.getCurrentmanaPool() + "/" + wizard.getManaPool() + " \uD83D\uDCA7" + "   |");
        textMana.getStyleClass().add("Mana");

        textAttack.setText("Wizard attack: " + wizard.getAttack_strength() + " \uD83D\uDCA5" + "   |");
        textAttack.getStyleClass().add("attack");

        textAccuracy.setText("Accuracy: " + wizard.getAccuracy() + " \uD83C\uDFAF" + "   |");
        textAccuracy.getStyleClass().add("accuracy");

        levelText.setText("Level: " + wizard.getLevel() + " ⭐" + "   |");
        levelText.getStyleClass().add("level");

        numberHealthPotions.setText(Arrays.toString(new String[]{String.valueOf(wizard.getNumberHealthPotion(wizard.getHealthPotions()))}));
        numberHealthPotions.getStyleClass().add("nbrHealthPots");

    }

    public void showGold() {
        gold.setText("Current gold: " + wizard.getGold() + " \uD83D\uDCB0");
        gold.getStyleClass().add("gold");
    }

    public void putTrollInfo() {
        trollInfo.setText(troll.getName() + ": " + troll.getCurrentHP() + "/" + troll.getBaseHP() + " ❤");
        trollInfo.getStyleClass().add("troll");
    }

    public void putBasilicInfo() {
        basilicInfo.setText(basilic.getName() + ": " + basilic.getCurrentHP() + "/" + basilic.getBaseHP() + " ❤");
        basilicInfo.getStyleClass().add("basilic");
    }
    public void putDementorInfo() {
        dementorInfo.setText(dementor.getName() + ": " + dementor.getCurrentHP() + "/" + dementor.getBaseHP() + " ❤");
        dementorInfo.getStyleClass().add("dementor");
    }

    private Stage trollStage;
    private Stage basilicStage;
    private Stage dementorStage;
    private Stage shopStage;
    private Stage stageTransition;




    public void startGame(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

        troll = Enemy.builder()
                .currentHP(800)
                .baseHP(800)
                .attack_strength(30)
                .attackStrengthMultiplier(3)
                .name("Troll")
                .build();

        createTrollStage();
        showGold();
        putText();
        putTrollInfo();
    }
    public void createTrollStage() throws IOException {
        this.trollStage = new Stage();
        FXMLLoader loaderTroll = new FXMLLoader(getClass().getResource("troll.fxml"));
        Parent rootTroll = loaderTroll.load();
        Scene sceneTroll = new Scene(rootTroll);
        sceneTroll.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) rootTroll).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, numberHealthPotions, trollInfo);
        trollStage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        trollStage.setTitle("Harry Potter");
        trollStage.setResizable(false);
        trollStage.setScene(sceneTroll);
        LevelTroll controllerTroll = loaderTroll.getController();
        controllerTroll.setGaming(this);

        trollStage.show();
    }

    public void createBasilicStage() throws IOException {

        basilic = Boss.builder()
                .currentHP(1000)
                .baseHP(1000)
                .attack_strength(30)
                .attackStrengthMultiplier(3)
                .name("Basilic")
                .build();

        basilicInfo.setText(basilic.getName() + ": " + basilic.getCurrentHP() + "/" + basilic.getBaseHP() + " ❤");
        basilicInfo.getStyleClass().add("troll");


        this.basilicStage = new Stage();
        FXMLLoader loaderBasilic = new FXMLLoader(getClass().getResource("basilic.fxml"));
        Parent rootBasilic = loaderBasilic.load();
        Scene sceneBasilic = new Scene(rootBasilic);
        sceneBasilic.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) rootBasilic).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, basilicInfo);
        basilicStage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        basilicStage.setTitle("Harry Potter");
        basilicStage.setResizable(false);
        basilicStage.setScene(sceneBasilic);
        LevelBasilic controllerBasilic = loaderBasilic.getController();
        controllerBasilic.setGaming(this);
        basilicStage.show();
    }

    public void createDementorStage() throws IOException {

        dementor = Enemy.builder()
                .currentHP(300)
                .baseHP(300)
                .attack_strength(50)
                .attackStrengthMultiplier(3)
                .name("Dementor")
                .build();

        dementorInfo.setText(dementor.getName() + ": " + dementor.getCurrentHP() + "/" + dementor.getBaseHP() + " ❤");
        dementorInfo.getStyleClass().add("dementor");


        this.dementorStage = new Stage();
        FXMLLoader loaderDementor = new FXMLLoader(getClass().getResource("dementor.fxml"));
        Parent rootDementor = loaderDementor.load();
        Scene sceneDementor = new Scene(rootDementor);
        sceneDementor.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) rootDementor).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, dementorInfo);
        dementorStage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        dementorStage.setTitle("Harry Potter");
        dementorStage.setResizable(false);
        dementorStage.setScene(sceneDementor);
        LevelDementor controllerDementor = loaderDementor.getController();
        controllerDementor.setGaming(this);
        dementorStage.show();
    }

    public void createShop() throws IOException {
        this.shopStage = new Stage();
        FXMLLoader loaderStage = new FXMLLoader(getClass().getResource("shop.fxml"));
        Parent rootShop = loaderStage.load();
        Scene sceneShop = new Scene(rootShop);
        sceneShop.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) rootShop).getChildren().addAll(gold, numberHealthPotions);
        shopStage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        shopStage.setTitle("Harry Potter");
        shopStage.setResizable(false);
        shopStage.setScene(sceneShop);
        ShopStageBasilic controllerShop = loaderStage.getController();
        controllerShop.setGaming(this);

        shopStage.show();
    }

    public boolean checkGameStateWizard() {
        if (wizard.isDead()) {
            return true;
        }
        return false;
    }

    public boolean checkGameStateTroll() {
        if (troll.isDead()) {
            return true;
        }
        return false;
    }
    public boolean checkGameStateBasilic() {
        if (basilic.isDead()) {
            return true;
        }
        return false;
    }
    public boolean checkGameStateDementor() {
        if (dementor.isDead()) {
            return true;
        }
        return false;
    }

    public void gameOver() throws IOException {
        trollStage.close();
        Stage stage = new Stage();
        FXMLLoader loaderGameOver = new FXMLLoader(getClass().getResource("GameOver.fxml"));
        Parent rootGamerOver = loaderGameOver.load();
        Scene sceneGameOver = new Scene(rootGamerOver);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        stage.setTitle("Harry Potter");
        stage.setResizable(false);
        stage.setScene(sceneGameOver);
        stage.show();
    }

    public void closeStage() throws IOException {
        stageTransition.close();
    }
    public void closeShop() throws IOException {
        shopStage.close();
        createBasilicStage();
    }

    public void stageTransition() throws IOException {

        this.stageTransition = new Stage();
        FXMLLoader loaderTransition = new FXMLLoader(getClass().getResource("StageTransition.fxml"));
        Parent rootTransition = loaderTransition.load();
        Scene sceneTransition = new Scene(rootTransition);
        sceneTransition.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stageTransition.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        stageTransition.setTitle("Harry Potter");
        stageTransition.setResizable(false);
        stageTransition.setScene(sceneTransition);
        StageTransitionBasilic controllerTransition = loaderTransition.getController();
        controllerTransition.setGaming(this);
        levelUp();
        stageTransition.show();
    }

    public void closeTrollStage() throws IOException {
        trollStage.close();
        stageTransition();
    }
    public void closeBasilicStage() throws IOException {
        basilicStage.close();
        stageTransition();
    }
    public void closeDementorStage() throws IOException {
        dementorStage.close();
        stageTransition();
    }


    public void trollAttacksWizard() {
        troll.attack(wizard);
    }
    public void basilicAttacksWizard() {
        basilic.attack(wizard);
    }
    public void dementorAttacksWizard() {
        dementor.attack(wizard);
    }

    public void wizardDefends(){
        wizard.defend();
    }

    public void wizardStopsDefend() {
        wizard.stopDefending();
    }

    public boolean healthPotionButtonPress() {
        boolean canUseHealthPotion = true;
        boolean success = wizard.useHealthPotion();
        if (!success) {
            System.out.println("You have no hp pots");
            canUseHealthPotion = false;
        }
        return canUseHealthPotion;
    }

    public boolean manaPotionButtonPress() {
        boolean canUseManaPotion = true;
        boolean success = wizard.useManaPotion();
        if (!success) {
            System.out.println("You have no mana pots");
            canUseManaPotion = false;
        }
        return canUseManaPotion;
    }

    public void wizardUsesDamagePotion() {
        wizard.equipDamagePotion();
    }

    public boolean canBuyHealthPotion() {
        int healthPrice = 15;
        boolean success = false;
        if (wizard.getGold() - healthPrice > 0) {
            wizard.addHealthPotion(new Potion());
            wizard.setGold(wizard.getGold() - healthPrice);
            return success = true;
        }
        return success;
    }
    public boolean canBuyDamagePotion() {
        int damagePrice = 30;
        boolean success = false;
        if (wizard.getGold() - damagePrice > 0) {
            wizard.addDamagePotion(new Potion());
            wizard.setGold(wizard.getGold() - damagePrice);
            return success = true;
        }
        return success;
    }
    public boolean canBuyManaPotion() {
        int manaPrice = 15;
        boolean success = false;
        if (wizard.getGold() - manaPrice > 0) {
            wizard.addManaPotion(new Potion());
            wizard.setGold(wizard.getGold() - manaPrice);
            return success = true;
        }
        return success;
    }

    public void levelUp() {
        wizard.setBaseHP(wizard.getBaseHP() + 150);
        wizard.setGold(wizard.getGold() + 40);
        wizard.setManaPool(wizard.getManaPool() + 25);
        wizard.setLevel(wizard.getLevel() + 1);
        wizard.setAttack_strength((wizard.getAttack_strength()) + 20);

        wizard.setCurrentHP(wizard.getBaseHP());
        wizard.setCurrentmanaPool(wizard.getManaPool());

        wizard.addSpell(new Spell());
        wizard.addSpell(new Spell());
    }

}
