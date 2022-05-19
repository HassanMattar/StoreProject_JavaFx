/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class FinalProject extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
   
        
        FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("view/Login.fxml") );
        Scene scene = new Scene(fXMLLoader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
