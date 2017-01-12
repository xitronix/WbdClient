package basic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerChooseWorkerAndClass extends ControllerMenu implements Initializable {
    static java.sql.Date dateMin, dateMax, date;
    @FXML
    ComboBox worker;
    @FXML
    ComboBox room;

    public void finishAddingRealizationClass(ActionEvent e) throws IOException {
        //changeWindow(e, "chooseCourseRealization.fxml");
        Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        appStage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}



