package basic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class ControllerChooseDateAndTime extends ControllerMenu implements Initializable {
    static int classId;
    @FXML
    DatePicker calendar;

    @FXML
    TextField timeTxt;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //alert(location.toString());
        // if (location.toString().split("/")[location.toString().split("/").length - 1].equals("addRealizationClassStepOne.fxml")) {
        try {
            calendar.getEditor().setDisable(true);
            ResultSet rs = doExecute("SELECT \"Data_od\",\"Data_do\" FROM \"Realizacja_kursu\" WHERE \"ID_Realizacja_kursu\"='" + ControllerPlanRealizationCourse.indexCourse + "'");
            rs.next();
            ControllerChooseWorkerAndClass.dateMin = rs.getDate(1);
            ControllerChooseWorkerAndClass.dateMax = rs.getDate(2);
            calendar.setValue(ControllerChooseWorkerAndClass.dateMin.toLocalDate());
            final Callback<DatePicker, DateCell> dayCellFactory =
                    new Callback<DatePicker, DateCell>() {
                        @Override
                        public DateCell call(final DatePicker datePicker) {
                            return new DateCell() {
                                @Override
                                public void updateItem(LocalDate item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (item.isAfter(
                                            ControllerChooseWorkerAndClass.dateMax.toLocalDate())
                                            ) {
                                        setDisable(true);
                                        setStyle("-fx-background-color: #ffc0cb;");
                                    }
                                    if (item.isBefore(
//
                                            ControllerChooseWorkerAndClass.dateMin.toLocalDate())
                                            ) {
                                        setDisable(true);
                                        setStyle("-fx-background-color: #ffc0cb;");
                                    }
                                }
                            };
                        }
                    };
            calendar.setDayCellFactory(dayCellFactory);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //private  setLimits

    public void nextStep(ActionEvent e) throws IOException {
        try {
            System.out.println(calendar.getValue().getDayOfWeek());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ControllerChooseWorkerAndClass.date = new java.sql.Date(sdf.parse(calendar.getEditor().getText().replace(".", "-") + " " + timeTxt.getText()).getTime());
            changeWindow(e, "addRealizationClassStepTwo.fxml");
        } catch (ParseException e1) {
            alert(e1.toString());
        }
    }
}
