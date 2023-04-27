package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Auto-generated method stub
        qualityChoice.getItems().addAll(qualities);
        qualityChoice.setOnAction(this::getQuality);
        petChoice.getItems().addAll(pets);
        petChoice.setOnAction(this::getPet);
        wandChoice.getItems().addAll(wands);
        wandChoice.setOnAction(this::getWand);
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
    private Enemy troll;
    private Boss basilic;

    public void createWizard(ActionEvent event) {
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

                .attack_strength((int)(400 * house.attackMultiplier()))
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

    }


    Text textHP = new Text();
    Text textMana = new Text();
    Text textAttack = new Text();
    Text textAccuracy = new Text();
    Text levelText = new Text();
    Text trollInfo = new Text();
    Text gameOver = new Text();
    Text basilicIinfo = new Text();



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

    public void putTrollInfo() {
        trollInfo.setText(troll.getName() + ": " + troll.getCurrentHP() + "/" + troll.getBaseHP() + " ❤");
        trollInfo.getStyleClass().add("troll");
    }

    private Stage trollStage;

    public void startGame(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

        if (house != null) {
            troll = Enemy.builder()
                    .currentHP(800)
                    .baseHP(800)
                    .attack_strength(30)
                    .attackStrengthMultiplier(3)
                    .name("Troll")
                    .build();

            createTrollStage();
            putText();
            putTrollInfo();
        }
    }
    public void createTrollStage() throws IOException {
        this.trollStage = new Stage();
        FXMLLoader loaderTroll = new FXMLLoader(getClass().getResource("troll.fxml"));
        Parent rootTroll = loaderTroll.load();
        Scene sceneTroll = new Scene(rootTroll);
        sceneTroll.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) rootTroll).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, trollInfo);
        trollStage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        trollStage.setTitle("Harry Potter");
        trollStage.setResizable(false);
        trollStage.setScene(sceneTroll);
        LevelTroll controller = loaderTroll.getController();
        controller.setGaming(this);
        trollStage.show();
    }

    public void createBasilicStage() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loaderBasilic = new FXMLLoader(getClass().getResource("basilic.fxml"));
        Parent rootBasilic = loaderBasilic.load();
        Scene sceneBasilic = new Scene(rootBasilic);
        sceneBasilic.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) rootBasilic).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, basilicIinfo);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        stage.setTitle("Harry Potter");
        stage.setResizable(false);
        stage.setScene(sceneBasilic);
        stage.show();
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

    public void gameOver() throws IOException {
        trollStage.close();
        Stage stage = new Stage();
        FXMLLoader loaderGameOver = new FXMLLoader(getClass().getResource("GameOver.fxml"));
        Parent rootGamerOver = loaderGameOver.load();
        Scene sceneGameOver = new Scene(rootGamerOver);
        sceneGameOver.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) rootGamerOver).getChildren().addAll(gameOver);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        stage.setTitle("Harry Potter");
        stage.setResizable(false);
        stage.setScene(sceneGameOver);
        stage.show();
    }

    public void closeTrollStage() throws IOException {
        trollStage.close();
        basilic = Boss.builder()
                .currentHP(1000)
                .baseHP(1000)
                .attack_strength(30)
                .attackStrengthMultiplier(3)
                .name("Basilic")
                .build();

        basilicIinfo.setText(basilic.getName() + ": " + basilic.getCurrentHP() + "/" + basilic.getBaseHP() + " ❤");
        basilicIinfo.getStyleClass().add("troll");
        createBasilicStage();

    }

    public void wizardAttackTroll() {
        System.out.println(troll.getCurrentHP());
        wizard.attack(troll);
        System.out.println(troll.getCurrentHP());
    }

    public boolean wingardiumButtonPress() {
        boolean canUseWingardium = true;
        boolean success = wizard.useWingardiumLeviosa(troll);
            if (!success) {
                System.out.println("You have no wingardium left");
                canUseWingardium = false;

            }
        return canUseWingardium;
    }

    public void trollAttackWizard() {
        troll.attack(wizard);
    }

    public void wizardDefends(){
        wizard.defend();
    }

    public void wizardStopsDefend() {
        wizard.stopDefending();
    }

    public void wizardUsesHealthPotion() {
        wizard.useHealthPotion();
    }

    public void wizardUsesManaPotion() {
        wizard.useManaPotion();
    }

    public void wizardUsesDamagePotion() {
        wizard.equipDamagePotion();
    }

}
