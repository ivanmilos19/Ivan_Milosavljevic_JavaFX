package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TitleScreen {


    public void TitleScreen(Stage titlestage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("TitleScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        titlestage.setTitle("Harry Potter");

        Image icon = new Image("C:\\Users\\ivanm\\IdeaProjects\\javafx\\src\\main\\java\\application\\HP_logo.png");
        titlestage.getIcons().add(icon);

        titlestage.setResizable(false);


        titlestage.setScene(scene);
        titlestage.show();


    }

    private Stage stage;
    private Scene scene;
    public void startGame(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("levelTroll.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();




        Wizard wizard = Wizard.builder()
                .currentHP(500)
                .previousHP(500)
                .baseHP(500)
                .level(1)

                .joinedEnemy(false)


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



        wizard.Pet();
        Wand wand = new Wand();
        wizard.setWand(wand);


    }

}
