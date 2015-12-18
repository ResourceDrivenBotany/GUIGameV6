/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.v5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amanuel
 */
public class MainStageController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML private Button btnPlay;
    @FXML public TextField taPlayerName;
    @FXML private TextField taPlantName;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btnPlay != null: "fx:id=\"btnPlay\" was not injected";
        assert taPlayerName != null: "fx:id=\"taPlayerName\" was not injected";
        assert taPlantName != null: "fx:id=\"taPlantName\" was not injected";
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void gotoHomeStage(ActionEvent event){
       myController.setScreen(GameV5.HOME_SCREEN);
    }    
    
    @FXML
    private void btnPlay(ActionEvent event) throws IOException{
        if(!taPlayerName.getText().equals("") && !taPlantName.equals("")){
         /*   Data data = new Data(taPlayerName.getText(), taPlantName.getText(),"");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(GameV5.GAME_SCREEN));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            GameStageController con = loader.getController();
            con.setMyData(data);
            stage.show();
          */  
           myController.setScreen(GameV5.GAME_SCREEN);
        }
        else{
            myController.setScreen(GameV5.HOME_SCREEN);
        }
    }
    
}
