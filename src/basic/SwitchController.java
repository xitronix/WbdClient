package basic;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by xitronix on 11.01.2017.
 */
class SwitchController {
    private static Stage stage;

    static void setStage(Stage stg){
        stage=stg;
    }

    static void changeWindow(Scene page){
        stage.setScene(page);
    }

}
