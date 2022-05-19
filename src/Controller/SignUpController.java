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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Users;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button SignUp;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private RadioButton isCustomer;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton isSalesclerk;
    @FXML
    private Label confirm;
    
    private String type="customer";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isCustomer.setToggleGroup(group);
        isSalesclerk.setToggleGroup(group);
           group.selectedToggleProperty().addListener(
   (observable, oldToggle, newToggle) -> {
       if (newToggle == isSalesclerk) {  type = "salesclerk";  }
       
       else  {type =  "customer"; } 
    }
);
    }    

    @FXML
    private void SignUp(ActionEvent event) {
        if(MyDatabase.getUsers(userName.getText(),  password.getText()).isEmpty()){
          if(userName.getText().equals("") || password.getText().equals("")||confirmPassword.getText().equals("")){
                    confirm.setText("You Must Fill All ");
                }else if(!confirmPassword.getText().equals(password.getText())){
                     confirm.setText("You Must Confirm Password ");
            
        }else{
                 
 Users user=new Users(userName.getText(), password.getText(),type); 
            MyDatabase.addUser(user);
            
             FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("../finalproject/view/Login.fxml") );
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
          confirm.setText("This user exist");
        }
    } 
}
