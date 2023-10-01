import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class UtilityBillPayment extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating UI components
        Label companyLabel = new Label("Company:");
        TextField companyField = new TextField();

       Label billTypeLabel = new Label("Bill Type:");
       TextField billTypeField = new TextField();

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

       Label consumerNoLabel = new Label("Consumer No:");
         TextField consumerNoField = new TextField();

        Button paybillButton = new Button("Pay Bill");
        paybillButton.setOnAction(e -> {
            companyField.getText();
            Double.parseDouble(amountField.getText());
            billTypeField.getText();
            consumerNoField.getText();

        });

    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(10));
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setVgap(10);
    gridPane.setVgap(10);
    gridPane.setVgap(10);
    gridPane.setAlignment(Pos.CENTER_LEFT);

    gridPane.add(companyLabel, 0, 0);
    gridPane.add(companyField, 1, 0);
    gridPane.add(billTypeLabel, 0, 1);
    gridPane.add(billTypeField, 1, 1);
    gridPane.add(amountLabel, 0, 2);
    gridPane.add(amountField, 1, 2);
    gridPane.add(consumerNoLabel, 0, 3);
    gridPane.add(consumerNoField, 1, 3);
    gridPane.add(paybillButton, 1, 4);

    // Creating the back button
    Button backButton = new Button("Back");

    // Create the bill paid successfully screen when click on pay bill button
    Label billPaidLabel = new Label("Bill Paid Successfully!");
    GridPane gridPane2 = new GridPane();
    gridPane2.setPadding(new Insets(10));
    gridPane2.setHgap(10);
    gridPane2.setVgap(10);
    gridPane2.setAlignment(Pos.CENTER);
    gridPane2.add(billPaidLabel, 0, 0);
    gridPane2.add(backButton, 0, 1);    

     //Set up the pay bill button to switch to the message screen when clicked
     paybillButton.setOnAction(e -> {
        primaryStage.setScene(new Scene(gridPane2, 600, 300));
        primaryStage.setTitle("Bill Paid Successfully!");
        primaryStage.show();
    });

    // Set up the back button to switch back to the bill payment screen when clicked
    backButton.setOnAction(e -> {
        primaryStage.setScene(new Scene(gridPane, 600, 300));
        primaryStage.setTitle("Pay Utility Bill");
        primaryStage.show();
    });


    // Creating scene and showing stage
    Scene scene = new Scene(gridPane, 600, 300);
    primaryStage.setTitle("Pay Utility Bill");
    primaryStage.setScene(scene);
    primaryStage.show();
   
    }

    public static void main(String[] args) {
        launch(args);
    }

}
