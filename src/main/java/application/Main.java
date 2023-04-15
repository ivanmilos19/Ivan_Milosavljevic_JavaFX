package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;


import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {


    /*@Override
    public void start(Stage title) throws IOException {

        TitleScreen titleScreen = new TitleScreen();
        titleScreen.TitleScreen(title);

    }*/


    @Override
    public void start(Stage stage) throws IOException {
        Wizard wizard = Wizard.builder()
                .currentHP(500)
                .previousHP(500)
                .baseHP(500)
                .level(1)
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

        Enemy troll = Enemy.builder()
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
        Text levelText= new Text();
        Text trollHPText = new Text();


        Rectangle rectangle = new Rectangle();
        rectangle.setY(450);
        rectangle.setWidth(1200);
        rectangle.setHeight(300);
        rectangle.setFill(Color.LIGHTGRAY);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("troll.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1200, 690);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ((Pane) root).getChildren().addAll(rectangle, textHP, levelText, textMana, textAttack, textAccuracy, trollHPText);
        stage.setScene(scene);
        stage.show();


        textHP.setText("Wizard HP: " + wizard.getCurrentHP() + "/" + wizard.getBaseHP() + " ❤" +"   |");
        textHP.getStyleClass().add("HP");

        textMana.setText("Mana: " + wizard.getCurrentmanaPool() + "/" + wizard.getManaPool() + " \uD83D\uDCA7" + "   |");
        textMana.getStyleClass().add("Mana");

        textAttack.setText("Wizard attack: " + wizard.getAttack_strength() + " \uD83D\uDCA5" + "   |");
        textAttack.getStyleClass().add("attack");

        textAccuracy.setText("Accuracy: " + wizard.getAccuracy() + " \uD83C\uDFAF" + "   |");
        textAccuracy.getStyleClass().add("accuracy");

        levelText.setText("Level: " + wizard.getLevel() + " ⭐" + "   |");
        levelText.getStyleClass().add("level");

        trollHPText.setText(troll.getName() + ": " + troll.getCurrentHP() + "/" + troll.getBaseHP() + " ❤");
        trollHPText.getStyleClass().add("troll");


    }
}