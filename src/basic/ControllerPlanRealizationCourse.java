package basic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by xitronix on 19.12.2016.
 */
public class ControllerPlanRealizationCourse implements Initializable {
    @FXML
    ComboBox<String> kursComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //courseComboBox.setItems(buildComboBox());
        //courseComboBox.setValue(courseComboBox.getItems().get(0));
    }



}
