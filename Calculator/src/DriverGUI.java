import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;


public class DriverGUI extends Application {

    Stage window;
    Scene mainScene, copyScene, lengthScene, overScene;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;


    }
}