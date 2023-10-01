import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a GridPane for the Manage Payee form
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Create labels and text fields for the account details form
        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();
        Label accountNumberLabel = new Label("Account Number:");
        TextField accountNumberTextField = new TextField();
        Label bankNameLabel = new Label("Bank Name:");
        TextField bankNameTextField = new TextField();
        Label branchNameLabel = new Label("Branch Name:");
        TextField branchNameTextField = new TextField();

        // Add the labels and text fields to the Manage Payee form
        grid.add(nameLabel, 0, 0);
        grid.add(nameTextField, 1, 0);
        grid.add(accountNumberLabel, 0, 1);
        grid.add(accountNumberTextField, 1, 1);
        grid.add(bankNameLabel, 0, 2);
        grid.add(bankNameTextField, 1, 2);
        grid.add(branchNameLabel, 0, 3);
        grid.add(branchNameTextField, 1, 3);

        // Create a Submit button to submit the form
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            // Add the account details to the Manage Payee list
            String name = nameTextField.getText();
            String accountNumber = accountNumberTextField.getText();
            String bankName = bankNameTextField.getText();
            String branchName = branchNameTextField.getText();

            // TODO: Add the account details to the Manage Payee list

            // Clear the form fields
            nameTextField.clear();
            accountNumberTextField.clear();
            bankNameTextField.clear();
            branchNameTextField.clear();
        });

        // Create a VBox to hold the Manage Payee form and the Submit button
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(8);
        vbox.getChildren().addAll(grid, submitButton);

        // Create a Scene with the Manage Payee form and the Submit button
        Scene scene = new Scene(vbox, 400, 250);

        // Set the Scene to the primary stage and show the stage
        primaryStage.setTitle("Manage Payee");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
