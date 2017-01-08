package basic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerMenu {

    public void chooseRealizationCourse(ActionEvent e) throws IOException {
        changeWindow(e,"chooseCourseRealization.fxml");
    }

    public void changeWindow(ActionEvent e, String page) throws  IOException{
        Scene menuScene = new Scene(FXMLLoader.load(getClass().getResource(page)));
        Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        appStage.setScene(menuScene);
        appStage.show();
    }


}
