/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import finalproject.MyDatabase;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import model.Product;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddProductController extends Stage implements Initializable {

    @FXML
    private TextField quantityAdd;
    @FXML
    private Button AddButton;
    @FXML
    private TextField priceAdd;
    @FXML
    private Button imageAdd;
    @FXML
    private TextField typeValue;
    @FXML
    private ImageView imageView;
      BufferedImage img;
       File myImages;
       String src;
    @FXML
    private Label fill;
    @FXML
    private Button MyProduuct;
    @FXML
    private Button logoutButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void choiseImage(ActionEvent event) {
        try {
            FileChooser fileChooser;
           
            fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(
                    new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
            );
           File   file = fileChooser.showOpenDialog(this);
            String path= System.getProperty("user.dir") + "/src/finalproject/Image/" +  file.getName();
             myImages = new File(path);
             img = ImageIO.read(file);
            System.out.println(System.getProperty("user.dir"));
            System.out.println(path); 
            src="file:/"+file.getPath();
            imageView.setImage(new Image(src));
            System.out.println( file.getName());
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AddAll(ActionEvent event) {
       if(!(quantityAdd.getText().equals(""))||!(typeValue.getText().equals(""))||!(priceAdd.getText().equals(""))){
            try {
            ImageIO.write(img, "png", myImages);
        } catch (IOException ex) {
        }
        MyDatabase.addProduct(
  new Product(Integer.parseInt(quantityAdd.getText()),typeValue.getText(),Double.valueOf(priceAdd.getText()),src));
       }else
       fill.setText("You Must Fill All");
    }

    @FXML
    private void viewMyCard(ActionEvent event) {
          FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("../finalproject/view/MyCard.fxml") );
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

    @FXML
    private void logout(ActionEvent event) {
          FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("../finalproject/view/Login.fxml") );
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
    }

   
    

