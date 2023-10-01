import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class BlockCardTemporarily extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating UI components

        Label cardNOLabel = new Label("Enter Card Number:");
        TextField cardNOField = new TextField();
       
        Label PinLabel = new Label("Enter your Pin:");
        TextField PinField = new TextField();

        Label label = new Label();
         Labeled grouplabel = new Label();

        Button blockCardButton = new Button("Block Card");
        blockCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 cardNOField.getText();
                 PinField.getText();
                if (label.getText().isEmpty()) {
                    label.setText("Please fill the details");
                } 
                else 
                {
                    
                    System.out.println("Card Blocked Successfully");
                    if(event.getSource() == blockCardButton){
                       
                        grouplabel.setText("Card Blocked Successfully");
                    }
                }
            }
        });
        blockCardButton.setOnAction(e -> {
            //the button didn't work until and unless the textfield is empty
            // if(cardNOField.getText().isEmpty() || PinField.getText().isEmpty())
            // {
            //     blockCardButton.setDisable(true);
            // }
            // else
            // {
            //     blockCardButton.setDisable(false);
            // }
            cardNOField.getText();
            PinField.getText();

            blockCardButton.setOnAction(new EventHandler<ActionEvent>() {
                private Labeled grouplabel;
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Card Blocked Successfully");
                    if(event.getSource() == blockCardButton){
                        grouplabel.setText("Card Blocked Successfully");
                    }
            }
            
                
            });

        });
        

        // Adding components to the layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(cardNOLabel, 0, 0);
        gridPane.add(cardNOField, 1, 0);
        gridPane.add(PinLabel, 0, 1);
        gridPane.add(PinField, 1, 1);
        gridPane.add(blockCardButton, 1, 2);

        // Create the card blocked successfully screen when click on block card button
        Label cardBlockedLabel = new Label("Card Blocked Successfully");
        GridPane gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(10));
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);
        gridPane2.setAlignment(Pos.CENTER);
        gridPane2.add(cardBlockedLabel, 0, 0);

        //Set up the Block card button to switch to the message screen when clicked
        blockCardButton.setOnAction(e -> {
            primaryStage.setScene(new Scene(gridPane2, 600, 300));
            primaryStage.setTitle("Card Blocked Successfully");
            primaryStage.show();
        });

        // Creating scene and showing stage
        Scene scene = new Scene(gridPane, 600, 300);
        primaryStage.setTitle("Block Card Temporarily");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
