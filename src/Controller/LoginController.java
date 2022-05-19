/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import finalproject.MyDatabase;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Users;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController  implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Label invalid;
    @FXML
    private Button siginUp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginController(ActionEvent event) {
        if(userName.getText().equals("") && password.getText().equals("")){
                    invalid.setText("You Must Fill All");
                }else{
            ArrayList <Users>users=new ArrayList <Users>();
            users=MyDatabase.getUsers(userName.getText(), password.getText());
             if(!users.isEmpty()){
                    if(users.get(0).getType().equals("customer")){
                         FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("../finalproject/view/ViewProduct.fxml") );
         ((Stage)userName.getScene().getWindow()).close();
            Stage primaryStage =new Stage();
                    Scene scene;
        try {
            scene = new Scene(fXMLLoader.load());
             primaryStage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }  
        primaryStage.show();
                }else if(users.get(0).getType().equals("salesclerk")){
                       FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("../finalproject/view/AddProduct.fxml") );
         ((Stage)userName.getScene().getWindow()).close();
            Stage primaryStage =new Stage();
                    Scene scene;
        try {
            scene = new Scene(fXMLLoader.load());
             primaryStage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

              
        primaryStage.show();
                }
             }else{
                    invalid.setText("invalid Account you must Sign Up");
                }
                
            }
        }
               

    @FXML
    private void siginUpController(ActionEvent event)  {
         FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("../finalproject/view/SignUp.fxml") );
         ((Stage)userName.getScene().getWindow()).close();
            Stage primaryStage =new Stage();
                    Scene scene;
        try {
            scene = new Scene(fXMLLoader.load());
             primaryStage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

              
        primaryStage.show();
    }
    
}
