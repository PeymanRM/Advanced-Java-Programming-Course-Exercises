package classwork;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/main-view.fxml"));
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("./views/css/styles.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Classwork");
        Image icon = new Image("icon.png");
        stage.setResizable(false);
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
