package application;

import application.Characters.Boss;
import application.Characters.Enemy;
import application.Characters.Wizard;
import application.Houses.*;
import application.Levels.*;
import application.Transitions.Shop;
import application.Transitions.StageTransition;
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
import java.util.Objects;
import java.util.ResourceBundle;

public class Gaming implements Initializable {

    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> qualityChoice;
    private final String[] qualities = {"Daring", "Curious", "Loyal", "Ambitious"};

    @FXML
    private Label petLabel;
    @FXML
    private ChoiceBox<String> petChoice;
    private final String[] pets = {"Snowy owl", "Rat", "Toad", "Cat"};

    @FXML
    private Label wandLabel;
    @FXML
    private ChoiceBox<String> wandChoice;
    private final String[] wands = {"Dragon Heartstring", "Unicorn hair", "Phoenix feather"};


    @FXML
    private Button startGame;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
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
        if (Objects.equals(myQuality, "Daring"))
            this.house = new Gryffindor();
        else if (Objects.equals(myQuality, "Curious")) {
            this.house = new Ravenclaw();
        } else if (Objects.equals(myQuality, "Loyal")) {
            this.house = new Hufflepuff();
        } else if (Objects.equals(myQuality, "Ambitious")) {
            this.house = new Slytherin();
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
    public Boss voldemort;
    public Enemy wormtail;
    public Enemy trophy;
    public Boss dolores;
    public Boss deathEater;

    public void createWizard() {
        if (house != null) {
            wizard = Wizard.builder().currentHP(5000)
                    .previousHP(5000)
                    .baseHP(5000)
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
            wizard.addWingardiumSpell(new Spell());
            wizard.addWingardiumSpell(new Spell());

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
    Text wormtailInfo = new Text();
    Text voldemortInfo = new Text();
    Text doloresInfo = new Text();
    Text deathEaterInfo = new Text();


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
        basilicInfo.getStyleClass().add("dementor");
    }

    public void putDementorInfo() {
        dementorInfo.setText(dementor.getName() + ": " + dementor.getCurrentHP() + "/" + dementor.getBaseHP() + " ❤");
        dementorInfo.getStyleClass().add("dementor");
    }

    public void putVoldemortInfo() {
        voldemortInfo.setText(voldemort.getName() + ": " + voldemort.getCurrentHP() + "/" + voldemort.getBaseHP() + " ❤");
        voldemortInfo.getStyleClass().add("voldemort");
    }

    public void putWormtailInfo() {
        wormtailInfo.setText(wormtail.getName() + ": " + wormtail.getCurrentHP() + "/" + wormtail.getBaseHP() + " ❤");
        wormtailInfo.getStyleClass().add("wormtail");
    }

    public void putDoloresInfo() {
        doloresInfo.setText(dolores.getName() + ": " + dolores.getCurrentHP() + "/" + dolores.getBaseHP() + " ❤");
        doloresInfo.getStyleClass().add("dolores");
    }

    public void putDeathEaterInfo() {
        deathEaterInfo.setText(deathEater.getName() + ": " + deathEater.getCurrentHP() + "/" + deathEater.getBaseHP() + " ❤");
        deathEaterInfo.getStyleClass().add("deathEater");
    }


    private Stage trollStage;
    private Stage basilicStage;
    private Stage dementorStage;
    private Stage hangletonStage;
    private Stage doloresStage;
    private Stage deathEaterStage;
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
        FXMLLoader loaderTroll = new FXMLLoader(getClass().getResource("levels/troll.fxml"));
        Parent rootTroll = loaderTroll.load();
        Scene sceneTroll = new Scene(rootTroll);
        sceneTroll.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootTroll).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, numberHealthPotions, trollInfo);
        trollStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
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

       putBasilicInfo();


        this.basilicStage = new Stage();
        FXMLLoader loaderBasilic = new FXMLLoader(getClass().getResource("Levels/basilic.fxml"));
        Parent rootBasilic = loaderBasilic.load();
        Scene sceneBasilic = new Scene(rootBasilic);
        sceneBasilic.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootBasilic).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, basilicInfo, numberHealthPotions);
        basilicStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
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

        putDementorInfo();


        this.dementorStage = new Stage();
        FXMLLoader loaderDementor = new FXMLLoader(getClass().getResource("Levels/dementor.fxml"));
        Parent rootDementor = loaderDementor.load();
        Scene sceneDementor = new Scene(rootDementor);
        sceneDementor.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootDementor).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, dementorInfo);
        dementorStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        dementorStage.setTitle("Harry Potter");
        dementorStage.setResizable(false);
        dementorStage.setScene(sceneDementor);
        LevelDementor controllerDementor = loaderDementor.getController();
        controllerDementor.setGaming(this);
        dementorStage.show();
    }

    public void createHangletonStage() throws IOException {

        wormtail = Enemy.builder()
                .currentHP(600)
                .baseHP(600)
                .attack_strength(20)
                .attackStrengthMultiplier(3)
                .name("Wormtail")
                .build();

        voldemort = Boss.builder()
                .currentHP(2000)
                .baseHP(2000)
                .attack_strength(80)
                .attackStrengthMultiplier(3)
                .name("Voldemort")
                .build();

        trophy = Enemy.builder()
                .build();

        putVoldemortInfo();

        putWormtailInfo();

        this.hangletonStage = new Stage();
        FXMLLoader loaderHangleton = new FXMLLoader(getClass().getResource("Levels/hangleton.fxml"));
        Parent rootHangleton = loaderHangleton.load();
        Scene sceneHangleton = new Scene(rootHangleton);
        sceneHangleton.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootHangleton).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, voldemortInfo, wormtailInfo);
        hangletonStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        hangletonStage.setTitle("Harry Potter");
        hangletonStage.setResizable(false);
        hangletonStage.setScene(sceneHangleton);
        LevelHangleton controllerHangleton = loaderHangleton.getController();
        controllerHangleton.setGaming(this);
        hangletonStage.show();
    }

    public void createDoloresStage() throws IOException {

        dolores = Boss.builder()
                .currentHP(1500)
                .baseHP(1500)
                .attack_strength(65)
                .attackStrengthMultiplier(3)
                .name("Dolores Umbridge")
                .build();

        putDoloresInfo();


        this.doloresStage = new Stage();
        FXMLLoader loaderDolores = new FXMLLoader(getClass().getResource("Levels/dolores.fxml"));
        Parent rootDolores = loaderDolores.load();
        Scene sceneDolores = new Scene(rootDolores);
        sceneDolores.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootDolores).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, doloresInfo);
        doloresStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        doloresStage.setTitle("Harry Potter");
        doloresStage.setResizable(false);
        doloresStage.setScene(sceneDolores);
        LevelDolores controllerDolores = loaderDolores.getController();
        controllerDolores.setGaming(this);
        doloresStage.show();
    }

    public void createDeatheaterStage() throws IOException {

        deathEater = Boss.builder()
                .currentHP(1100)
                .baseHP(1100)
                .attack_strength(55)
                .attackStrengthMultiplier(3)
                .name("Death Eater")
                .build();

        putDeathEaterInfo();


        this.deathEaterStage = new Stage();
        FXMLLoader loaderDeathEater = new FXMLLoader(getClass().getResource("Levels/deathEater.fxml"));
        Parent rootDeatheater = loaderDeathEater.load();
        Scene sceneDeathEater = new Scene(rootDeatheater);
        sceneDeathEater.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootDeatheater).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, deathEaterInfo);
        deathEaterStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        deathEaterStage.setTitle("Harry Potter");
        deathEaterStage.setResizable(false);
        deathEaterStage.setScene(sceneDeathEater);
        LevelDeathEater controllerDeathEater = loaderDeathEater.getController();
        controllerDeathEater.setGaming(this);
        deathEaterStage.show();
    }

    public void createShopStage() throws IOException {
        showGold();
        this.shopStage = new Stage();
        FXMLLoader loaderStage = new FXMLLoader(getClass().getResource("shop.fxml"));
        Parent rootShop = loaderStage.load();
        Scene sceneShop = new Scene(rootShop);
        sceneShop.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootShop).getChildren().addAll(gold, numberHealthPotions);
        shopStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        shopStage.setTitle("Harry Potter");
        shopStage.setResizable(false);
        shopStage.setScene(sceneShop);
        Shop controllerShop = loaderStage.getController();
        controllerShop.setGaming(this);
        shopStage.show();
    }


    public boolean checkGameStateWizard() {
        return wizard.isDead();
    }

    public boolean checkGameStateTroll() {
        return troll.isDead();
    }

    public boolean checkGameStateBasilic() {
        return basilic.isDead();
    }

    public boolean checkGameStateDementor() {
        return dementor.isDead();
    }

    public boolean checkGameStateVoldemort() {
        return voldemort.isDead();
    }

    public boolean checkGameStateWormtail() {
        return wormtail.isDead();
    }

    public boolean checkGameStateDolores() {
        return dolores.isDead();
    }

    public boolean checkGameStateDeathEater() {
        return deathEater.isDead();
    }

    public void gameOver() throws IOException {
        trollStage.close();
        hangletonStage.close();

        Stage stage = new Stage();
        FXMLLoader loaderGameOver = new FXMLLoader(getClass().getResource("GameOver.fxml"));
        Parent rootGamerOver = loaderGameOver.load();
        Scene sceneGameOver = new Scene(rootGamerOver);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        stage.setTitle("Harry Potter");
        stage.setResizable(false);
        stage.setScene(sceneGameOver);
        stage.show();
    }

    public void closeStage() {
        stageTransition.close();
    }

    public void closeShop() {
        shopStage.close();

    }

    public void stageTransition() throws IOException {
        levelUp();
        putText();
        this.stageTransition = new Stage();
        FXMLLoader loaderTransition = new FXMLLoader(getClass().getResource("StageTransition.fxml"));
        Parent rootTransition = loaderTransition.load();
        Scene sceneTransition = new Scene(rootTransition);
        sceneTransition.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stageTransition.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        stageTransition.setTitle("Harry Potter");
        stageTransition.setResizable(false);
        stageTransition.setScene(sceneTransition);
        StageTransition controllerTransition = loaderTransition.getController();
        controllerTransition.setGaming(this);
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

    public void closeHangletonStage() throws IOException {
        hangletonStage.close();
        stageTransition();
    }

    public void closeDoloresStage() throws IOException {
        doloresStage.close();
        stageTransition();
    }

    public void closeDeathEaterStage() throws IOException {
        deathEaterStage.close();
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

    public void voldemortAttackWizard() {
        voldemort.attack(wizard);
    }

    public void wormtailAttacksWizard() {
        wormtail.attack(wizard);
    }

    public void doloresAttacksWizard() {
        dolores.attack(wizard);
    }

    public void deathEaterAttacksWizard() {
        deathEater.attack(wizard);
    }


    public void wizardDefends() {
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
            return true;
        }
        return success;
    }

    public boolean canBuyDamagePotion() {
        int damagePrice = 30;
        boolean success = false;
        if (wizard.getGold() - damagePrice > 0) {
            wizard.addDamagePotion(new Potion());
            wizard.setGold(wizard.getGold() - damagePrice);
            return true;
        }
        return success;
    }

    public boolean canBuyManaPotion() {
        int manaPrice = 15;
        boolean success = false;
        if (wizard.getGold() - manaPrice > 0) {
            wizard.addManaPotion(new Potion());
            wizard.setGold(wizard.getGold() - manaPrice);
            return true;
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
        switch(wizard.getLevel()) {
            case 2 ->{
                wizard.addWingardiumSpell(new Spell());
                wizard.addAccioSpell(new Spell());
                wizard.addAccioSpell(new Spell());
            }
            case 3, 4, 5 -> {
                wizard.addWingardiumSpell(new Spell());
                wizard.addAccioSpell(new Spell());
                wizard.addExpectoSpell(new Spell());
            }
            case 6 -> {
                wizard.addWingardiumSpell(new Spell());
                wizard.addAccioSpell(new Spell());
                wizard.addExpectoSpell(new Spell());
                wizard.addSectumsempraSpell(new Spell());
                wizard.addSectumsempraSpell(new Spell());
            }
            default -> {
            }
        }

    }

}
