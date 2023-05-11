package application;

import application.Characters.Boss;
import application.Characters.Enemy;
import application.Characters.Wizard;
import application.Houses.*;
import application.Levels.*;
import application.Transitions.Shop;
import application.Transitions.SlytherinJoinStage;
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
            house = new Gryffindor();
        else if (Objects.equals(myQuality, "Curious")) {
            house = new Ravenclaw();
        } else if (Objects.equals(myQuality, "Loyal")) {
            house = new Hufflepuff();
        } else if (Objects.equals(myQuality, "Ambitious")) {
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
    public Boss voldemort;
    public Enemy wormtail;
    public Enemy trophy;
    public Enemy dolores;
    public Boss deathEater;
    public Enemy bellatrix;

    public void createWizard() {
        if (house != null) {
            wizard = Wizard.builder().currentHP(700)
                    .previousHP(700)
                    .baseHP(700)
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

                    .attack_strength((int) (50 * house.attackMultiplier()))
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

            wizard.setHouse(house);


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
    Text bellatrixInfo = new Text();


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

    public void putBellatrixInfo() {
        bellatrixInfo.setText(bellatrix.getName() + ": " + bellatrix.getCurrentHP() + "/" + bellatrix.getBaseHP() + " ❤");
        bellatrixInfo.getStyleClass().add("wormtail");
    }


    private Stage trollStage;
    private Stage basilicStage;
    private Stage dementorStage;
    private Stage hangletonStage;
    private Stage doloresStage;
    private Stage deathEaterStage;
    private Stage voldemortStage;

    private Stage shopStage;
    private Stage stageTransition;
    private Stage joinSlytherinStage;
    private Stage joinedSlytherinStage;


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
        ((Pane) rootTroll).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, trollInfo);
        trollStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        trollStage.setTitle("Harry Potter");
        trollStage.setResizable(false);
        trollStage.setScene(sceneTroll);
        LevelTroll controllerTroll = loaderTroll.getController();
        controllerTroll.setGaming(this);
        trollStage.show();
    }

    public boolean godricSword(){
        return house.canUseSword();
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
        loaderBasilic.setControllerFactory(controllerClass -> new LevelBasilic(this));
        Parent rootBasilic = loaderBasilic.load();
        Scene sceneBasilic = new Scene(rootBasilic);
        sceneBasilic.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootBasilic).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, basilicInfo);
        basilicStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        basilicStage.setTitle("Harry Potter");
        basilicStage.setResizable(false);
        basilicStage.setScene(sceneBasilic);
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

                .name("Voldemort")
                .build();

        trophy = Enemy.builder()
                .name("Trophy")
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

        dolores = Enemy.builder()
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

    public void createVoldemortStage() throws IOException {

        bellatrix = Enemy.builder()
                .currentHP(900)
                .baseHP(900)
                .attack_strength(40)
                .attackStrengthMultiplier(3)
                .name("Bellatrix")
                .build();

        voldemort = Boss.builder()
                .currentHP(2000)
                .baseHP(1500)
                .attack_strength(80)
                .attackStrengthMultiplier(5)
                .name("Voldemort")
                .build();

        putVoldemortInfo();
        putBellatrixInfo();

        this.voldemortStage = new Stage();
        FXMLLoader loaderVoldemort = new FXMLLoader(getClass().getResource("Levels/voldemort.fxml"));
        Parent rootVoldemort = loaderVoldemort.load();
        Scene sceneVoldemort = new Scene(rootVoldemort);
        sceneVoldemort.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootVoldemort).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, voldemortInfo, bellatrixInfo);
        voldemortStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        voldemortStage.setTitle("Harry Potter");
        voldemortStage.setResizable(false);
        voldemortStage.setScene(sceneVoldemort);
        LevelVoldemort controllerVoldemort = loaderVoldemort.getController();
        controllerVoldemort.setGaming(this);
        voldemortStage.show();
    }

    public void createFinishedGame() throws IOException {

        Stage FinishedStage = new Stage();
        FXMLLoader loaderVoldemort = new FXMLLoader(getClass().getResource("FinishedGame.fxml"));
        Parent rootFinished = loaderVoldemort.load();
        Scene sceneFinished = new Scene(rootFinished);
        sceneFinished.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        FinishedStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        FinishedStage.setTitle("Harry Potter");
        FinishedStage.setResizable(false);
        FinishedStage.setScene(sceneFinished);
        FinishedStage.show();
    }

    public void createShopStage() throws IOException {
        showGold();
        this.shopStage = new Stage();
        FXMLLoader loaderStage = new FXMLLoader(getClass().getResource("shop.fxml"));
        Parent rootShop = loaderStage.load();
        Scene sceneShop = new Scene(rootShop);
        sceneShop.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        ((Pane) rootShop).getChildren().addAll(gold);
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

    public boolean checkGameStateBellatrix() {
        return bellatrix.isDead();
    }

    public void gameOver() throws IOException {
        trollStage.close();
        if (hangletonStage != null) {
            hangletonStage.close();
        }
        if (dementorStage != null) {
            dementorStage.close();
        }
        if (basilicStage != null) {
            basilicStage.close();
        }
        if (doloresStage != null) {
            doloresStage.close();
        }
        if (deathEaterStage != null) {
            deathEaterStage.close();
        }
        if (voldemortStage != null) {
            voldemortStage.close();
        }

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

    public void closeTransitionStage() {
        stageTransition.close();
    }

    public void closeSlytherinJoinStage() {
        joinSlytherinStage.close();
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

    public boolean joinEnemy(){
        return house.canJoinEnemy();
    }
    public void createJoinSlytherinStage() throws IOException {
        this.joinSlytherinStage = new Stage();
        FXMLLoader loaderJoinSlytherinStage =  new FXMLLoader(getClass().getResource("slytherinJoin.fxml"));
        loaderJoinSlytherinStage.setControllerFactory(controllerClass -> new SlytherinJoinStage(this));
        Parent rootJoinSlytherinStage = loaderJoinSlytherinStage.load();
        Scene sceneJoinSlytherinStage  = new Scene(rootJoinSlytherinStage);
        sceneJoinSlytherinStage.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        joinSlytherinStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        joinSlytherinStage.setTitle("Harry Potter");
        joinSlytherinStage.setResizable(false);
        joinSlytherinStage.setScene(sceneJoinSlytherinStage);
        joinSlytherinStage.show();
    }

    public void createJoinedSlytherinStage() throws IOException {
        this.joinedSlytherinStage = new Stage();
        FXMLLoader loaderJoinSlytherinStage =  new FXMLLoader(getClass().getResource("joinedEnemy.fxml"));
        loaderJoinSlytherinStage.setControllerFactory(controllerClass -> new SlytherinJoinStage(this));
        Parent rootJoinSlytherinStage = loaderJoinSlytherinStage.load();
        Scene sceneJoinSlytherinStage  = new Scene(rootJoinSlytherinStage);
        joinedSlytherinStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
        joinedSlytherinStage.setTitle("Harry Potter");
        joinedSlytherinStage.setResizable(false);
        joinedSlytherinStage.setScene(sceneJoinSlytherinStage);
        joinedSlytherinStage.show();
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

    public void closeVoldemortStage() throws IOException {
        voldemortStage.close();
        createFinishedGame();
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

    public void bellatrixAttackWizard() {
        bellatrix.attack(wizard);
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
            canUseHealthPotion = false;
        }
        return canUseHealthPotion;
    }

    public boolean manaPotionButtonPress() {
        boolean canUseManaPotion = true;
        boolean success = wizard.useManaPotion();
        if (!success) {
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
        switch (wizard.getLevel()) {
            case 2 -> {
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

    public boolean trollUsesMace() {
        boolean success = false;
        if (troll.canUseMace()) {
            troll.attack(wizard);
            System.out.println("The troll smashed you and dealt big damage!");
            success = true;
        } else {
            troll.attack(wizard);
        }
        troll.resetMace();
        return success;
    }
    public boolean warningTrollMace() {
        boolean success = false;
        if (troll.randomUseMace()) {
            return true;
        }
        return success;
    }

    public boolean basilicUsesBite() {
        boolean success = false;
        if (basilic.canBite()) {
            basilic.attack(wizard);
            System.out.println("The troll smashed you and dealt big damage!");
            success = true;
        } else {
            basilic.attack(wizard);
        }
        basilic.resetBite();
        return success;
    }
    public boolean warningBite() {
        boolean success = false;
        if (basilic.RandomBite()) {
            return true;
        }
        return success;
    }

    public boolean DoloresThrowsBook() {
        boolean success = false;
        if (dolores.canThrowBook()) {
            dolores.attack(wizard);
            System.out.println("book lol");
            success = true;
        } else {
            dolores.attack(wizard);
        }
        dolores.resetBook();
        return success;
    }
    public boolean warningBook() {
        boolean success = false;
        if (dolores.randomThrowBook()) {
            return true;
        }
        return success;
    }

    public boolean voldemortUsesAvada() {
        boolean success = false;
        if (voldemort.canUseAvada()) {
            voldemort.attack(wizard);
            System.out.println("avada lol");
            success = true;
        } else {
            voldemort.attack(wizard);
        }
        voldemort.resetUseAvada();
        return success;
    }
    public boolean warningAvada() {
        boolean success = false;
        if (voldemort.RandomUseAvada()) {
            return true;
        }
        return success;
    }

}
