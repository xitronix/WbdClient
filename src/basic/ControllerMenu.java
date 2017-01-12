package basic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ControllerMenu {

    public void chooseRealizationCourse(ActionEvent e) throws IOException {
        changeWindow(e, "chooseCourseRealization.fxml");
    }

   /* void changeWindow(String page) throws  IOException{
        Scene menuScene = new Scene(FXMLLoader.load(getClass().getResource(page)));
        //Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //appStage.setScene(menuScene);
        //appStage.show();
        SwitchController.changeWindow(menuScene);
     } */
    void changeWindow(ActionEvent e, String page) throws  IOException{
        Scene menuScene = new Scene(FXMLLoader.load(getClass().getResource(page)));
        Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        appStage.setScene(menuScene);
        appStage.setResizable(false);
        /*appStage.setMinHeight(appStage.getHeight());
        appStage.setMaxHeight(appStage.getHeight());
        appStage.setMinWidth(appStage.getWidth());
        appStage.setMaxWidth(appStage.getWidth());*/
;
        appStage.show();
//        SwitchController.changeWindow(menuScene);
    }

    void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Insert Error! Check input data!");
        alert.setContentText(message);
        alert.showAndWait();
    }
    ResultSet doExecute(String SQL) throws SQLException, ClassNotFoundException {
        return DBConnect.getConnection().createStatement().executeQuery(SQL);
    }


}
