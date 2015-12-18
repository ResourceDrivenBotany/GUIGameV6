/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.v5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amanuel
 */
public class GameStageController implements Initializable, ControlledScreen {

    static String commandString = "";
    String userString;
    ScreensController myController;
    boolean attack = false;
    
    //MainStageController mStageController;
    //String a = mStageController.taPlayerName.getText();
    
    @FXML private Button btnGrow;
    @FXML private Button btnDefend;
    @FXML private Button btnAttack;
    @FXML private Button btnWater;
    @FXML private Button btnSoil;
    @FXML private Button btnScent;
    @FXML private Button btnBackGameStage;
    @FXML private TextField cbPlayer;
    @FXML private TextField tfPlantType;
   // @FXML private TextField cbResource;
   // @FXML private TextArea taClient;
    @FXML private TextArea taServer;
    @FXML private TextField tfPlantName;
    @FXML private TextField tfPlayerName;
    @FXML private Button btnPlay;
    @FXML private ComboBox cbPlantTypeName;
    //@FXML private TextField cbPlantType
            ;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btnGrow != null: "fx:id=\"btnGrow\" was not injected";
        assert btnDefend != null: "fx:id=\"btnDefend\" was not injected";
        assert btnAttack != null: "fx:id=\"btnAttack\" was not injected";
        assert btnWater != null: "fx:id=\"btnWater\" was not injected";
        assert btnSoil != null: "fx:id=\"btnScent\" was not injected";
        assert btnBackGameStage != null: "fx:id=\"btnBackGameStage\" was not injected";
        assert btnScent != null: "fx:id=\"btnPScent\" was not injected";
        assert cbPlayer != null: "fx:id=\"cbPlayer\" was not injected";
        assert tfPlantType != null: "fx:id=\"cbPlantType\" was not injected";
        //assert cbResource != null: "fx:id=\"btncbResource\" was not injected";
        //assert taClient != null: "fx:id=\"taClient\" was not injected";
        assert taServer != null: "fx:id=\"taServer\" was not injected";
        assert tfPlayerName != null: "fx:id=\"tfPlayerName\" was not injected";
        assert tfPlantName != null: "fx:id=\"tfPlantName\" was not injected";
        assert btnPlay != null: "fx:id=\"btnPlay\" was not injected";
        assert cbPlantTypeName != null: "fx:id=\"cbPlantTypeName\" was not injected";
       // assert cbPlantType != null: "fx:id=\"cbPlantType\" was not injected";
                
       taServer.setEditable(false);
       //taClient.setEditable(false);
       //taServer.setText(System.lineSeparator());
        
        Backend.runBackend();
        Backend.passTextArea(taServer);
        
      //  cbPlantType.setDisable(true);
       // cbPlayer.setDisable(true);
       // cbResource.setDisable(true);
        
        handleActions();
        
       // taClient.setText(a);
    }
    

    public void handleActions(){
         btnPlay.setOnAction((event) -> {
             if(!tfPlayerName.isDisabled()){
                userString = tfPlayerName.getText();
                 Backend.passBackend(userString);
                //taServer.appendText(Backend.getMsg());
                tfPlayerName.setDisable(true);
             }
             else if (tfPlayerName.isDisabled() && !tfPlantName.isDisabled()){
                 userString = tfPlantName.getText();
                 Backend.passBackend(userString);
                //taServer.appendText(Backend.getMsg());
                tfPlantName.setDisable(true);
             }
             else{
                 userString = tfPlantType.getText();
                 Backend.passBackend(userString);
                //taServer.appendText(Backend.getMsg());
                tfPlantType.setDisable(true);
             }
            //generateWordCloud(cloudFlowPane, userString);
        });
         btnWater.setOnAction(e->{
             userString = "1";
             Backend.passBackend(userString);
             try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {
                 Logger.getLogger(GameStageController.class.getName()).log(Level.SEVERE, null, ex);
             }
             Backend.passBackend("10");
             //taServer.appendText(Backend.getMsg());
         });
         btnSoil.setOnAction(e->{
             userString = "2";
             Backend.passBackend(userString);
             try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {
                 Logger.getLogger(GameStageController.class.getName()).log(Level.SEVERE, null, ex);
             }
             Backend.passBackend("10");
         });
         btnScent.setOnAction(e->{
             userString = "3";
             Backend.passBackend(userString);
             try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {
                 Logger.getLogger(GameStageController.class.getName()).log(Level.SEVERE, null, ex);
             }
             Backend.passBackend("10");
         });
         btnAttack.setOnAction(e->{
                
                userString = cbPlayer.getText();
                Backend.passBackend(userString);
                attack = true;
             
                //Backend.passBackend("10");
         });
                  btnGrow.setOnAction(e->{
                
                userString = cbPlayer.getText();
                Backend.passBackend(userString);
                attack = true;
             
               // Backend.passBackend("10");
         });
                btnDefend.setOnAction(e->{
                
                userString = cbPlayer.getText();
                Backend.passBackend(userString);
                attack = true;
             
              //  Backend.passBackend("10");
         });
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void gotoHomeStage(ActionEvent event){
       // ((Node)event.getSource()).getScene().getWindow().hide();
       myController.setScreen(GameV5.HOME_SCREEN);
    }

 /*   public void setMyData(Data myData) {
       // taClient.setText(myData.getPlayerName());
        this.myData = myData;
    }
  */  
    
}
class Backend{
    static DataOutputStream toServer = null;
    static DataInputStream fromServer = null;
    static String commandString;
    static boolean stringRecieved = false;
    static TextArea printTextArea;
    
    static boolean shutdown = false;
    
    static void passBackend(String stringIn) {
        commandString = stringIn;
        stringRecieved = true;
    }
    
    static void passTextArea(TextArea textArea) {
        printTextArea=textArea;
    }
    
    
    
    static void runBackend() {
            
        
        try {
          // Create a socket to connect to the server
            Socket socketOut = new Socket("localhost", 8001);
            Socket socketIn = new Socket("localhost", 8000);
            
            //Socket socketOut = new Socket("10.10.13.142", 8001);
            //Socket socketIn = new Socket("10.10.13.142", 8000);
            //Socket socket = new Socket("192.168.0.9", 8000);
                      // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socketIn.getInputStream()); // Create an output stream to send data to the server
            toServer = new DataOutputStream(socketOut.getOutputStream()); 
            
            new Thread(() -> {
                while (printTextArea == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Backend.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while(true) {
                    try {
                        String fromServerText = fromServer.readUTF();
                        Platform.runLater(() -> {
                            //printTextArea.setText(textAreaString);
                            printTextArea.appendText(fromServerText + "\n");
                        });
                        System.out.println(fromServerText);
                    } catch (IOException ex) {
                        Platform.runLater(() -> {
                            //printTextArea.setText(textAreaString);
                            printTextArea.appendText("\n" + "**GAME OVER**");
                            
                        });
                        
                        try {//once input stops running, close
                            toServer.close();
                            socketOut.close();
                            fromServer.close();
                            socketIn.close();
                        } catch (IOException ex1) {
                            Logger.getLogger(Backend.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                        shutdown = true;
                        break;
                        /*
                        System.exit(0);
                        */
                        //Logger.getLogger(SimpleGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();
            
            new Thread(() -> {
                if (toServer != null) {
                    while(!shutdown) {
                        while (!stringRecieved) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Backend.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        stringRecieved = false;
                        String asString = commandString.trim();
                        System.out.println(asString);
                        try {
                            int asInt = Integer.parseInt(asString);
                            System.out.println(asInt);
                            try {
                                toServer.writeInt(asInt);
                                toServer.flush();
                                System.out.println("sent as int " + asInt);
                            } catch (IOException ex) {
                                Logger.getLogger(GameStageController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        catch(NumberFormatException nFE) {
                            System.out.println("sentAsString");
                            try {
                                toServer.writeUTF(asString);
                                toServer.flush();
                            } catch (IOException ex) {
                                Logger.getLogger(GameStageController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                }
            }).start();
            
        } catch (IOException ex) {
        }
    }
}