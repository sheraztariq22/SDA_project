import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TransferMoneyApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating UI components
       Label fromLabel = new Label("From:");
       TextField fromField = new TextField();

       Label toLabel = new Label("To:");
       TextField toField = new TextField();

       Label amountLabel = new Label("Amount:");
       TextField amountField = new TextField();

       Label datLabel = new Label("Date:");
       TextField dateField = new TextField();

       Label purposLabel = new Label("Purpose:");
       TextField purposeField = new TextField();

        Button transferButton = new Button("Transfer");
        transferButton.setOnAction(e -> {
            fromField.getText();
            toField.getText();
            Double.parseDouble(amountField.getText());
            dateField.getText();
            purposeField.getText();

        });

        // Adding components to the layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(fromLabel, 0, 0);
        gridPane.add(fromField, 1, 0);
        gridPane.add(toLabel, 0, 1);
        gridPane.add(toField, 1, 1);
        gridPane.add(amountLabel, 0, 2);
        gridPane.add(amountField, 1, 2);
        gridPane.add(datLabel, 0, 3);
        gridPane.add(dateField, 1, 3);
        gridPane.add(purposLabel, 0, 4);
        gridPane.add(purposeField, 1, 4);
        gridPane.add(transferButton, 1, 5);

        // Create the transferred Succesfully screen when click on transfer button
        Label transferLabel = new Label("Transferred Successfully!");
        GridPane gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(10));
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);
        gridPane2.setAlignment(Pos.CENTER);
        gridPane2.add(transferLabel, 0, 0);

        //Set up the transfer button to switch to the message screen when clicked
        transferButton.setOnAction(e -> {
            primaryStage.setScene(new Scene(gridPane2, 300, 200));
            primaryStage.setTitle("Transferred Successfully!");
            primaryStage.show();
        });

        //setting the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        gridPane2.setStyle("-fx-background-color: #FFFFFF;");
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane2.setPadding(new Insets(10, 10, 10, 10));

        // Creating scene and showing stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Transfer Money");
        primaryStage.setScene(scene);
        scene.setFill(Color.web("#81c483"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
