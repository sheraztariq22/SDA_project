import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Create UI components
        Label titleLabel = new Label("Loan Application Form");
        Label loanOptionsLabel = new Label("Select a loan option:");
        ComboBox<String> loanOptionsComboBox = new ComboBox<>();
        loanOptionsComboBox.getItems().addAll("Personal Loan", "Car Loan", "Home Loan");
        Label accountDetailsLabel = new Label("Enter your account details:");
        TextField accountDetailsTextField = new TextField();
        Label loanAmountLabel = new Label("Enter loan amount:");
        TextField loanAmountTextField = new TextField();
        Button confirmButton = new Button("Confirm");

        // Create a grid pane layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(loanOptionsLabel, 0, 1);
        gridPane.add(loanOptionsComboBox, 1, 1);
        gridPane.add(accountDetailsLabel, 0, 2);
        gridPane.add(accountDetailsTextField, 1, 2);
        gridPane.add(loanAmountLabel, 0, 3);
        gridPane.add(loanAmountTextField, 1, 3);
        gridPane.add(confirmButton, 1, 4);

        // Create a scene and set the layout
        Scene scene = new Scene(gridPane, 400, 250);

        // Set the stage title and scene, and show the stage
        stage.setTitle("Loan Application");
        stage.setScene(scene);
        stage.show();

        // Handle confirm button click event
        confirmButton.setOnAction(event -> {
            // Get input values
            String loanOption = loanOptionsComboBox.getValue();
            String accountDetails = accountDetailsTextField.getText();
            double loanAmount = Double.parseDouble(loanAmountTextField.getText());

            // Check if loan amount is valid
            if (loanAmount > 0) {
                // Display success message and disburse loan amount
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Loan Application");
                alert.setHeaderText("Success");
                alert.setContentText("Your request for a " + loanOption + " loan of amount " + loanAmount + " has been received successfully. The loan amount has been disbursed into your account.");
                alert.showAndWait();
            } else {
                // Display error message if loan amount is invalid
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Loan Application");
                alert.setHeaderText("Error");
                alert.setContentText("Please enter a valid loan amount.");
                alert.showAndWait();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}