import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    Stage window;
    Scene mainMenuScene, recordTransactionScene;

    @Override
    public void start(Stage primaryStage) {

        // Set up the primary window
        window = primaryStage;
        window.setTitle("Banking Management System");

        // Set up the main menu scene
        Label mainMenuLabel = new Label("Main Menu");
        Button recordTransactionButton = new Button("Record Transaction");
        Button viewTransactionsButton = new Button("View Transactions");
        Button exitButton = new Button("Exit");

        VBox mainMenuLayout = new VBox(20);
        mainMenuLayout.getChildren().addAll(mainMenuLabel, recordTransactionButton, viewTransactionsButton, exitButton);
        mainMenuLayout.setAlignment(Pos.CENTER);

        mainMenuScene = new Scene(mainMenuLayout, 400, 400);

        // Set up the record transaction scene
        Label recordTransactionLabel = new Label("Record Transaction");
        Label amountLabel = new Label("Amount:");
        TextField amountTextField = new TextField();
        Label descriptionLabel = new Label("Description:");
        TextField descriptionTextField = new TextField();
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back to Main Menu");

        GridPane recordTransactionLayout = new GridPane();
        recordTransactionLayout.setPadding(new Insets(10, 10, 10, 10));
        recordTransactionLayout.setVgap(8);
        recordTransactionLayout.setHgap(10);

        GridPane.setConstraints(amountLabel, 0, 0);
        GridPane.setConstraints(amountTextField, 1, 0);
        GridPane.setConstraints(descriptionLabel, 0, 1);
        GridPane.setConstraints(descriptionTextField, 1, 1);
        GridPane.setConstraints(submitButton, 1, 2);
        GridPane.setConstraints(backButton, 0, 2);

        recordTransactionLayout.getChildren().addAll(amountLabel, amountTextField, descriptionLabel,
                descriptionTextField, submitButton, backButton);
        recordTransactionLayout.setAlignment(Pos.CENTER);

        recordTransactionScene = new Scene(recordTransactionLayout, 400, 400);

        // Set up event handling
        recordTransactionButton.setOnAction(e -> window.setScene(recordTransactionScene));

        backButton.setOnAction(e -> window.setScene(mainMenuScene));

        submitButton.setOnAction(e -> {
            // Get the amount and description from the text fields
            String amountString = amountTextField.getText();
            double amount = Double.parseDouble(amountString);
            String description = descriptionTextField.getText();

            // Record the transaction in the banking system
            recordTransaction(amount, description);

            // Clear the text fields
            amountTextField.clear();
            descriptionTextField.clear();
        });

        viewTransactionsButton.setOnAction(e -> {
            // TODO: Implement view transactions functionality
        });

        exitButton.setOnAction(e -> window.close());

        // Show the main menu scene
        window.setScene(mainMenuScene);
        window.show();
    }

    public void recordTransaction(double amount, String description) {
        // TODO: Implement record transaction functionality
    }

    public static void main(String[] args) {
        launch(args);
    }
}
