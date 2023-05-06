package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

//TODO - faire fxml de tt les levels / ajouter message pour dégâts et attaques ratée / résoudre probleme de house.null
//TODO - ajouter grosses attaques / comment faire en sorte que shop ouvre prochain level sans avoir à faire 7 ptn de shop différents (cancer)

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
            FXMLLoader loaderCreateWizard = new FXMLLoader(getClass().getResource("wizardCreation.fxml"));
            Parent rootCreateWizard = loaderCreateWizard.load();
            Scene sceneCreateWizard = new Scene(rootCreateWizard);
            sceneCreateWizard.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.getIcons().add(new Image(getClass().getResourceAsStream("images/HP_logo.png")));
            stage.setTitle("Harry Potter");
            stage.setResizable(false);
            stage.setScene(sceneCreateWizard);
            stage.show();
            loaderCreateWizard.getController();
    }

    public static void main(String[] args) {
        launch(args);

    }
}