package basic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by xitronix on 19.12.2016.
 */
public class ControllerPlanRealizationCourse extends ControllerMenu implements Initializable {

    static int indexCourse;
    //ObservableList<ObservableList> data;

    @FXML
    TableView classes;

    @FXML
    BorderPane borderPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(indexCourse);
        ResultSet rs;
        try {
            rs = doExecute("SELECT (\"ID_Kurs\") FROM \"Realizacja_kursu\" WHERE \"ID_Realizacja_kursu\"=" + indexCourse);
            rs.next();
            fillClasses(rs.getInt(1));
//            calendar.setPromptText("dd-mm-yyyy");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private java.sql.Date parseDate(String strDate) {
        try {
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");//dd/MM/yyyy
            Date date = sdfDate.parse(strDate);
            return new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            alert(e.toString());
            return null;
        }
    }

    private void fillPracownik() {
    }

    private void fillClasses(int id) {
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try {
            ResultSet rs = doExecute("select \"ID_Zajecia\",\"Temat\",\"Pojemnosc\",\"Czas_trwania\",\"Typ_sali\" from \"Zajecie\" WHERE \"ID_Kursu\"=" + id);
            addColumns(rs);
            data = generateObservableList(rs, data);
            System.out.println(data);
            //noinspection unchecked
            classes.setItems(data);
            classes.refresh();
            borderPane.setCenter(classes);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }


    private void addColumns(ResultSet rs) {
        try {
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = (TableColumn) classes.getColumns().get(i);
                //noinspection unchecked
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                System.out.println("Column [" + i + "] ");
            }
        } catch (SQLException e) {
            System.err.println("Error column input: " + e);
        }

    }

    private ObservableList<ObservableList> generateObservableList(ResultSet rs, ObservableList<ObservableList> data) {
        try {
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
                    row.add(rs.getString(i));
                data.add(row);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void addRealizationClass() throws IOException {
        Stage stage = new Stage();
        //alert("/"+classes.getSelectionModel().getSelectedItem().toString().split(", ")[0].replace("[", "")+"/");
        ControllerChooseDateAndTime.classId = Integer.parseInt(classes.getSelectionModel().getSelectedItem().toString().split(", ")[0].replace("[", ""));
        Scene page = new Scene(FXMLLoader.load(getClass().getResource("addRealizationClassStepOne.fxml")));
        stage.setScene(page);
        stage.setTitle("Planing");
        stage.show();
    }


}
