/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author Yelaman
 */
public class Buttons {
    private Label label;
    private String hey="X";
    StringBuilder winC1=new StringBuilder();
    StringBuilder winC2=new StringBuilder();
    StringBuilder winC3=new StringBuilder();
    StringBuilder winC4=new StringBuilder();
    StringBuilder winC5=new StringBuilder();
    StringBuilder winC6=new StringBuilder();
    StringBuilder winC7=new StringBuilder();
    StringBuilder winC8=new StringBuilder();
    private boolean winCo=false;
    
    public Buttons (Label label) {
        this.label=label;
        
        
        
    }
    public Parent getView() {
         GridPane buttons=new GridPane();
        Button tic1=new Button (" ");
        tic1.setFont(Font.font("Monospaced",40));
        Button tic2=new Button (" ");
        tic2.setFont(Font.font("Monospaced",40));
        Button tic3=new Button (" ");
        tic3.setFont(Font.font("Monospaced",40));
        Button tic4=new Button (" ");
        tic4.setFont(Font.font("Monospaced",40));
        Button tic5=new Button (" ");
        tic5.setFont(Font.font("Monospaced",40));
        Button tic6=new Button (" ");
        tic6.setFont(Font.font("Monospaced",40));
        Button tic7=new Button (" ");
        tic7.setFont(Font.font("Monospaced",40));
        Button tic8=new Button (" ");
        tic8.setFont(Font.font("Monospaced",40));
        Button tic9=new Button (" ");
        tic9.setFont(Font.font("Monospaced",40));
        
        buttons.add(tic1,0,0);
        buttons.add(tic2,0,1);
        buttons.add(tic3,0,2);
        buttons.add(tic4,1,0);
        buttons.add(tic5,1,1);
        buttons.add(tic6,1,2);
        buttons.add(tic7,2,0);
        buttons.add(tic8,2,1);
        buttons.add(tic9,2,2);
        
       
       
        
        
        
        tic1.setOnMouseClicked((event)->{
            if (hey.equals("X")) {
                winC1.append("X");
                winC4.append("X");
                winC7.append("X");
            }
            if (hey.equals("O")) {
                winC1.append("O");
                winC4.append("O");
                winC7.append("O");
            }
           
            setButton(tic1,label);
            
        });
        tic2.setOnMouseClicked((event)->{
            if (hey.equals("X")) {
                winC1.append("X");
                winC5.append("X");
            }
            if (hey.equals("O")) {
                winC1.append("O");
                winC5.append("O");
            }
            setButton(tic2,label);
            
        });
        tic3.setOnMouseClicked((event)->{
            if (hey.equals("X")) {
                winC1.append("X");
                winC6.append("X");
                winC8.append("X");
            }
            if (hey.equals("O")) {
                winC1.append("O");
                winC6.append("O");
                winC8.append("O");
            }
            setButton(tic3,label);
            
        });
        tic4.setOnMouseClicked((event)->{
            if (hey.equals("X")) {
                winC2.append("X");
                winC4.append("X");
            }
            if (hey.equals("O")) {
                winC2.append("O");
                winC4.append("O");
            }
            setButton(tic4,label);
        });
        tic5.setOnMouseClicked((event)->{
            if (hey.equals("X")) {
                winC2.append("X");
                winC5.append("X");
                winC7.append("X");
                winC8.append("X");
            }
            if (hey.equals("O")) {
                winC2.append("O");
                winC5.append("O");
                winC7.append("O");
                winC8.append("O");
            }
            setButton(tic5,label);
        });
        tic6.setOnMouseClicked((event)->{
           if (hey.equals("X")) {
                winC2.append("X");
                winC6.append("X");
            }
            if (hey.equals("O")) {
                winC2.append("O");
                winC6.append("O");
            }
            setButton(tic6,label);
        });
        tic7.setOnMouseClicked((event)->{
            if (hey.equals("X")) {
                winC3.append("X");
                winC4.append("X");
                winC8.append("X");
            }
            if (hey.equals("O")) {
                winC3.append("O");
                winC4.append("O");
                winC8.append("O");
            }
            setButton(tic7,label);
        });
        tic8.setOnMouseClicked((event)->{
            if (hey.equals("X")) {
                winC3.append("X");
                winC5.append("X");
            }
            if (hey.equals("O")) {
                winC3.append("O");
                winC5.append("O");
            }
            setButton(tic8,label);
        });
        tic9.setOnMouseClicked((event)->{
            if (hey.equals("X")) {
                winC3.append("X");
                winC6.append("X");
                winC7.append("X");
            }
            if (hey.equals("O")) {
                winC3.append("O");
                winC6.append("O");
                winC7.append("O");
            }
            setButton(tic9,label);
        });
        return buttons;
                
    }
    
    public void setButton (Button tic, Label label) {
        if (winCo) {
            return;
        }
        
        if (tic.getText().equals("X") || tic.getText().equals("O")) {
            return;
        }
        
        
        tic.setText(hey);
        
        
        if (hey.equals("X")) {
            hey="O";
            label.setText("Turn: O");
        } else if (hey.equals("O")) {
            hey="X";
            label.setText("Turn: X");
        }
        
        
        if (winC1.toString().equals("XXX") || winC1.toString().equals("OOO")) {
            label.setText("The end!");
            winCo=true;
        }
        if (winC2.toString().equals("XXX") || winC2.toString().equals("OOO")) {
            label.setText("The end!");
            winCo=true;
        }
        if (winC3.toString().equals("XXX") || winC3.toString().equals("OOO")) {
            label.setText("The end!");
            winCo=true;
        }
        if (winC4.toString().equals("XXX") || winC4.toString().equals("OOO")) {
            label.setText("The end!");
            winCo=true;
        }
        if (winC5.toString().equals("XXX") || winC5.toString().equals("OOO")) {
            label.setText("The end!");
            winCo=true;
        }
        if (winC6.toString().equals("XXX") || winC6.toString().equals("OOO")) {
            label.setText("The end!");
            winCo=true;
        }
        if (winC7.toString().equals("XXX") || winC7.toString().equals("OOO")) {
            label.setText("The end!");
            winCo=true;
        }
        if (winC8.toString().equals("XXX") || winC8.toString().equals("OOO")) {
            label.setText("The end!");
            winCo=true;
        }
            
   
    }
    
}
