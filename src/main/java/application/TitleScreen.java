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


    public void TitleScreen(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("TitleScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Harry Potter");

        Image icon = new Image("C:\\Users\\ivanm\\IdeaProjects\\javafx\\src\\main\\java\\application\\HP_logo.png");
        stage.getIcons().add(icon);

        stage.setResizable(false);


        stage.setScene(scene);
        stage.show();


    }

}
