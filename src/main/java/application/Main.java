package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.io.IOException;


public class Main extends Application {


    /*@Override
    public void start(Stage title) throws IOException {

        TitleScreen titleScreen = new TitleScreen();
        titleScreen.TitleScreen(title);

    }*/


    private Wizard wizard;
    private Enemy enemy;
    private Boss basilic;


    @Override
    public void start(Stage stage) throws IOException {
         wizard = Wizard.builder()
                .currentHP(500)
                .previousHP(500)
                .baseHP(500)
                .level(1)
                .accuracy(1)
                .joinedEnemy(false)
                .attack_strength(40)


                .healthPotions(new ArrayList<>())
                .manaPotions(new ArrayList<>())
                .damagePotions(new ArrayList<>())

                .wingardiumLeviosa(new ArrayList<>())
                .expectoPatronum(new ArrayList<>())
                .accio(new ArrayList<>())
                .sectumsempra(new ArrayList<>())
                .expelliarmus(new ArrayList<>())


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

        // give it 4 potion to start with
        wizard.addHealthPotion(new Potion());
        wizard.addDamagePotion(new Potion());
        wizard.addManaPotion(new Potion());

        wizard.addHealthPotion(new Potion());
        wizard.addDamagePotion(new Potion());
        wizard.addManaPotion(new Potion());


        // add spells
        wizard.addSpell(new Spell());
        wizard.addSpell(new Spell());

        enemy = Enemy.builder()
                .currentHP(800)
                .baseHP(800)
                .attack_strength(30)
                .attackStrengthMultiplier(3)
                .name("Troll")
                .build();


        Text textHP = new Text();
        Text textMana = new Text();
        Text textAttack = new Text();
        Text textAccuracy = new Text();
        Text levelText = new Text();
        Text trollHPText = new Text();

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

        trollHPText.setText(enemy.getName() + ": " + enemy.getCurrentHP() + "/" + enemy.getBaseHP() + " ❤");
        trollHPText.getStyleClass().add("troll");



        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("troll.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) root).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, trollHPText);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        stage.setTitle("Harry Potter");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();*/



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


        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("basilic.fxml"));
        Parent root2 = loader2.load();
        Scene scene2 = new Scene(root2);
        scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) root2).getChildren().addAll(textHP, levelText, textMana, textAttack, textAccuracy, basilicHP);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
        stage.setTitle("Harry Potter");
        stage.setResizable(false);
        stage.setScene(scene2);
        stage.show();



    }

    Wizard getWizard() {
        return wizard;
    }

    Enemy getEnemy() {
        return enemy;
    }

}