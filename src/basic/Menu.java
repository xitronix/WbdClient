package basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Menu extends Application {
    //private Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        new Thread(() -> {
            try {
                DBConnect.connect();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        });

        //stage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        primaryStage.setTitle("WBD Client");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        //SwitchController.setStage(primaryStage);
        primaryStage.show();

    }

   /* private void changeScene(String fxml) throws IOException {
        Parent page = (Parent) FXMLLoader.load(getClass().getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 700, 450);
            scene.getStylesheets().add(getClass().getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
    }*/
    public static void main(String[] args) {
        launch(args);
    }
}
