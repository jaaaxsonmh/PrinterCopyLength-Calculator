import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class DriverGUI extends Application {

    Stage window;
    Scene scene;
    Button btnCalculate;
    TextField webMotion, amountCopies;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Length Calculator");

        GridPane layout = new GridPane();

        //Warning layout
        Label warning = new Label("Please do not enter non-numeric characters or blanks");
        GridPane.setConstraints(warning, 0, 0, 3, 1);

        // Web motion Label
        Label webMotionLabel = new Label("Webmotion Value: ");
        GridPane.setConstraints(webMotionLabel, 0, 1);

        // Web Motion Input
        webMotion = new TextField();
        GridPane.setConstraints(webMotion, 1, 1);

        // Copies Label
        Label copiesLabel = new Label("Amount of Copies:");
        GridPane.setConstraints(copiesLabel, 0, 2);

        // Copies Input
        amountCopies = new TextField();
        GridPane.setConstraints(amountCopies, 1, 2);

        // Length Label
        Label lengthLabel = new Label("Total Length: ");
        GridPane.setConstraints(lengthLabel, 0, 4);

        //Display label
        Label display = new Label("");
        GridPane.setConstraints(display, 1, 4);

        // Calculate button
        btnCalculate = new Button("Calculate");
        GridPane.setConstraints(btnCalculate, 1, 3);

        layout.getChildren().addAll(warning, display, webMotionLabel, webMotion, copiesLabel, amountCopies, btnCalculate, lengthLabel);

        scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();

        btnCalculate.setOnAction(event -> {
            if((amountCopies.getText() != null && webMotion.getText() != null)) {
                String amountCopiesValue = amountCopies.getText();
                String webMotionValue = webMotion.getText();

                // calc length and round
                double length = convertToCalc(webMotionValue, amountCopiesValue);
                length = roundOff(length);

                display.setText(length + "m");
            } else {
                display.setText("Please enter both webmotion, and amount of copies.");
            }
        });
    }

    private double convertToCalc(String webMotionValue, String amountCopiesValue)
    {
        double webMotionDouble = Double.parseDouble(webMotionValue);
        double copiesDouble = Double.parseDouble(amountCopiesValue);

        return (webMotionDouble / 1000) * copiesDouble;
    }

    private double roundOff(double length) {
        String lengthRound = String.format("%.0f", length);

        return Double.parseDouble(lengthRound);
    }
}