package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application{
   
    @Override
    public void start(Stage window) throws Exception{
        BorderPane layout=new BorderPane ();
        
        Label turnText=new Label("Turn: X");
        turnText.setFont(Font.font("Monospaced",40));
       
        Buttons buttons=new Buttons(turnText);
        
        layout.setTop(turnText);
        layout.setCenter(buttons.getView());
        
       
        
        Scene view=new Scene (layout);
        window.setScene(view);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
    
    

}
