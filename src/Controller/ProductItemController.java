/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import finalproject.MyDatabase;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Product;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ProductItemController implements Initializable {

    @FXML
    private ImageView imageItem;
    @FXML
    private Label quantityValue;
    @FXML
    private Label typeValue;
   
    @FXML
    private Label priceValue;
    @FXML
    private Button BuyButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        
    }    

    public void setData(Product product) {
        imageItem.setImage(new Image(product.getImage()));
        quantityValue.setText(Integer.toString(product.getQuantity()));
        typeValue.setText(product.getType());
        priceValue.setText(String.valueOf(product.getPrice()));
        int id=  product.getId();
       BuyButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
          
        int q=   Integer.parseInt(quantityValue.getText());
                MyDatabase.UpdateProduct(q, id);
                 FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("../finalproject/view/ViewProduct.fxml") );
         ((Stage)typeValue.getScene().getWindow()).close();
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
            
        });
       
    }

    @FXML
    private void BuyItem(ActionEvent event) {
    }
}
