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
import java.util.IllegalFormatCodePointException;
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
        wizard = Wizard.builder()
                .currentHP(500)
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

                .attack_strength((int) (40 * house.attackMultiplier()))
                .manaPool(150)
                .currentmanaPool(150)

                .wingardiumManaUsage(15)
                .wingardiumCrit(140)
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
    Text trollHP = new Text();



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

        trollHP.setText(troll.getName() + ": " + troll.getCurrentHP() + "/" + troll.getBaseHP() + " ❤");
        trollHP.getStyleClass().add("troll");

    }



    public void createTrollStage() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loaderTroll = new FXMLLoader(getClass().getResource("troll.fxml"));
        Parent rootTroll = loaderTroll.load();
        Scene sceneTroll = new Scene(rootTroll);
        sceneTroll.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) rootTroll).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, trollHP);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        stage.setTitle("Harry Potter");
        stage.setResizable(false);
        stage.setScene(sceneTroll);
        LevelTroll controller = loaderTroll.getController();
        controller.setGaming(this);
        controller.setTexts((Pane) rootTroll, textHP, textMana, trollHP);

        stage.show();
    }



    public void wizardAttackTroll() {
        System.out.println(troll.getCurrentHP());
        wizard.attack(troll);
        System.out.println(troll.getCurrentHP());

    }


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


            if (wizard.isAlive() && troll.isDead()) {
                basilic = Boss.builder()
                        .currentHP(1000)
                        .baseHP(1000)
                        .attack_strength(30)
                        .attackStrengthMultiplier(3)
                        .name("Basilic")
                        .build();

                Text basilicHP = new Text();


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

                basilicHP.setText(basilic.getName() + ": " + basilic.getCurrentHP() + "/" + basilic.getBaseHP() + " ❤");
                basilicHP.getStyleClass().add("troll");


                FXMLLoader loaderBasilic = new FXMLLoader(getClass().getResource("basilic.fxml"));
                Parent rootBasilic = loaderBasilic.load();
                Scene sceneBasilic = new Scene(rootBasilic);
                sceneBasilic.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                ((Pane) rootBasilic).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, basilicHP);
                stage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
                stage.setTitle("Harry Potter");
                stage.setResizable(false);
                stage.setScene(sceneBasilic);
                stage.show();
            }
        }
    }
}
