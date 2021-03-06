package basic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by xitronix on 19.12.2016.
 */
public class ControllerChooseRealizationCourse extends ControllerMenu implements Initializable {

    @FXML
    ComboBox<String> courseComboBox;

    @FXML
    ComboBox<String> realizationCourseComboBox;

    @FXML
    TextField cenaTextField;
    @FXML
    TextField dataOdTextField;
    //to_date('01-jan-2013','dd-mon-yyyy')
    @FXML
    TextField dataDoTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //if (location.toString().split("/")[location.toString().split("/").length - 1].equals("chooseCourseRealization.fxml")) {
            courseComboBox.setItems(buildComboBox("Kurs", 1));
            courseComboBox.setValue(courseComboBox.getItems().get(0));
            realizationCourseComboBox.setItems(buildComboBox("Realizacja_kursu", 2));
            dataDoTextField.setText("1989-10-11");
            dataOdTextField.setText("1954-10-14");
            cenaTextField.setText("120");
            }

    private ObservableList<String> buildComboBox(String tableName, int i) {
        ObservableList<String> data = null;
        try {
            String SQL = "SELECT * FROM \"" + tableName + "\"";
            ResultSet rs = doExecute(SQL);

            data = FXCollections.observableArrayList();
            if (i == 1)
                while (rs.next())
                    data.add(rs.getString(2) + "  ||  id:" + rs.getString(1) + "");
            else if (i == 2)
                while (rs.next()) {
                    ResultSet rs1 = doExecute("SELECT * FROM \"Kurs\" WHERE \"ID_Kursu\"=" + rs.getString(2));
                    rs1.next();
                    System.out.println("id: " + rs.getString(1) + " " + rs1.getString(2));
                    data.add("id: " + rs.getString(1) + "  <==> " + rs1.getString(2) + " [nazwa kursu]");
                }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(data);
        return data;
    }


    public void addRealizationCourse(ActionEvent e) {
        try {
            PreparedStatement pst = DBConnect.getConnection().prepareStatement("INSERT INTO \"Realizacja_kursu\"(\"ID_Kurs\",\"Cena\",\"Data_od\",\"Data_do\") VALUES(?,?,?,?)");
            //alert((courseComboBox.getSelectionModel().getSelectedItem()).split("id:")[1].replace(" ", ""));
            pst.setInt(1, Integer.parseInt((courseComboBox.getSelectionModel().getSelectedItem()).split("id:")[1].replace(" ", "")));
            pst.setInt(2, Integer.parseInt(cenaTextField.getText()));
            pst.setDate(3, parseDate(dataOdTextField.getText()));
            pst.setDate(4, parseDate(dataDoTextField.getText()));
            pst.execute();
            pst.close();
            ResultSet rs= doExecute("SELECT MAX(\"ID_Realizacja_kursu\") FROM \"Realizacja_kursu\"");
            rs.next();
            ControllerPlanRealizationCourse.indexCourse= rs.getInt(1);
            changeWindow(e, "planCourseRealization.fxml");
        } catch (SQLException | ClassNotFoundException | IOException e1) {
            alert(e1.toString());
        }

    }

    /*private void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Insert Error! Check input data!");
        alert.setContentText(message);
        alert.showAndWait();
    }*/

    private java.sql.Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            return new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }


    }

    public void chooseRealizationCourse(ActionEvent e) throws IOException {
        System.out.println(realizationCourseComboBox.getValue().split(" ")[1]);
        ControllerPlanRealizationCourse.indexCourse= Integer.parseInt(realizationCourseComboBox.getValue().split(" ")[1]);
        //alert(String.valueOf(ControllerPlanRealizationCourse.indexCourse));
        changeWindow(e, "planCourseRealization.fxml");
    }

}
