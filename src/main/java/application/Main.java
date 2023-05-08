package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

//TODO -  ajouter message pour dégâts et attaques ratée / ajouter grosses attaques / finir mécanique death eater et basilic


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
            FXMLLoader loaderCreateWizard = new FXMLLoader(getClass().getResource("wizardCreation.fxml"));
            Parent rootCreateWizard = loaderCreateWizard.load();
            Scene sceneCreateWizard = new Scene(rootCreateWizard);
            sceneCreateWizard.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HP_logo.png"))));
            stage.setTitle("Harry Potter");
            stage.setResizable(false);
            stage.setScene(sceneCreateWizard);
            stage.show();
            loaderCreateWizard.getController();
    }
}