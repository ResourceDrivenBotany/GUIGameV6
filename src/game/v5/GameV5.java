/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.v5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Amanuel
 */
public class GameV5 extends Application {
    
    public static final String MAIN_SCREEN = "MainStage"; 
    public static final String MAIN_SCREEN_FXML = "MainStage.fxml"; 
     
    public static final String HOME_SCREEN = "HomeStage"; 
    public static final String HOME_SCREEN_FXML = "HomeStage.fxml";
     
    public static final String GAME_SCREEN = "GameStage"; 
    public static final String GAME_SCREEN_FXML = "GameStage.fxml";
         
    @Override
    public void start(Stage primaryStage) {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(GameV5.MAIN_SCREEN, GameV5.MAIN_SCREEN_FXML);
        mainContainer.loadScreen(GameV5.HOME_SCREEN, GameV5.HOME_SCREEN_FXML);
        mainContainer.loadScreen(GameV5.GAME_SCREEN, GameV5.GAME_SCREEN_FXML);
        
        mainContainer.setScreen(GameV5.HOME_SCREEN);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
