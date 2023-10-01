import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends Application {

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating UI components
       Label fromLabel = new Label("Username:");
       TextField fromField = new TextField();

       Label toLabel = new Label("Password:");
       TextField toField = new TextField();

       Button logiButton = new Button("Login");
         logiButton.setOnAction(e -> {
              fromField.getText();
              toField.getText();
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
          gridPane.add(logiButton, 1, 2);
    
          // Creating a scene object
          Scene scene = new Scene(gridPane);
    
          // Setting title to the Stage
          primaryStage.setTitle("Login");
    
          // Adding scene to the stage
          primaryStage.setScene(scene);
    
          // Displaying the contents of the stage
          primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}