/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.v5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amanuel
 */
public class HomeStageController implements Initializable, ControlledScreen {

    ScreensController myController;
    @FXML
    public Button btnQuit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void gotoMainStage(ActionEvent event){
       myController.setScreen(GameV5.GAME_SCREEN);
    }
    @FXML
    private void quitStage(ActionEvent event){
         Stage stage = (Stage) btnQuit.getScene().getWindow();
         stage.close();
    }
    
}
