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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Product;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ViewProductController implements Initializable {

    @FXML
    private Button MyCard;
    @FXML
    private Button logoutButton;
    @FXML
    private VBox ViewItem;

     ArrayList<Product> products = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        products.addAll(this.getData());
   
        try {
            for (int i = 0; i < products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../finalproject/view/productItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ProductItemController itemController = fxmlLoader.getController();
            ViewItem.getChildren().add(anchorPane);           
           itemController.setData(products.get(i));
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    @FXML
    private void viewMyCard(ActionEvent event) {
        
    }
    private ArrayList<Product> getData() {
    products = MyDatabase.getAllProduct();
    return products;
    }
       @FXML
    private void logout(ActionEvent event) {
        
         FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("../finalproject/view/Login.fxml") );
         ((Stage)MyCard.getScene().getWindow()).close();
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
    
    //---------------------------------------------------------------------------
    

    
}
