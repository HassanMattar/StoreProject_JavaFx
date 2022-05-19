/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Product;

import model.Users;

/**
 *
 * @author HP
 */
public class MyDatabase {
    
    private static Connection conn = null;
    private static String url = "jdbc:mysql://localhost:3306/stor";
    private static String username = "root";
    private static String password = "";
  


    public static void getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            
            System.out.println("Connection ");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static ArrayList<Product> getAllProduct() {
        ArrayList<Product> resultList = new ArrayList();
        if (conn == null) {
            getConnection();
        }

        try {
            PreparedStatement statement = conn.prepareStatement("Select * from product ");
            ResultSet rs = statement.executeQuery();
                 MyDatabase.writeOpration(statement.toString());
            while (rs.next()) {
                int quan = rs.getInt("Quantity");
                String type = rs.getString("type");
                int Price = rs.getInt("Price");
                String Image = rs.getString("Image");
           
                Product p = new Product(quan, type, Price, Image);
                p.setId(rs.getInt("id"));
                resultList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return resultList;
    }

    public static void addProduct(Product product) {
        if (conn == null) {
            getConnection();
        }

        PreparedStatement statement;
        try {
            statement = conn.prepareStatement("Insert into product(Quantity, type, Image,Price) values(?, ?, ?, ?)");
            statement.setInt(1, product.getQuantity());
            statement.setString(2, product.getType());
            statement.setString(3, product.getImage());
              statement.setDouble(4, product.getPrice());
           statement.executeUpdate();
             MyDatabase.writeOpration(statement.toString());
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    //*************************************************************************************
    
      public static ArrayList<Users> getUsers(String name,String password) {
        ArrayList<Users> resultList = new ArrayList();
        if (conn == null) {
            getConnection();
        }
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from users where userName = ? and password = ? ");
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            MyDatabase.writeOpration(statement.toString());
            while (rs.next()) {
                String userName = rs.getString("userName");
                String passwords = rs.getString("password");
                String type = rs.getString("type");
              Users p = new Users(userName, passwords, type);
                resultList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return resultList;
    }

    public static void addUser(Users user) {
        if (conn == null) {
            getConnection();
        }

        PreparedStatement statement;
        try {
            statement = conn.prepareStatement("Insert into users(userName,password,type) values(?,  ?,?)");
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
             statement.setString(3, user.getType());
            int rs = statement.executeUpdate();
           MyDatabase.writeOpration(statement.toString());
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
   //*************************************************************************
       public static void writeOpration(String statment){
         try {
                File  file =  new File("src/Loger");
                FileWriter myWriter = null;
                myWriter = new FileWriter(file, true);
                myWriter.write(statment+"\n");
                myWriter.close();

            } catch (IOException ex) {
                System.out.println("there erore in write the file");
            }
  
     }
     public static void UpdateProduct(int quantity,int id) {
       
        if (conn == null) {
            getConnection();
        }
        try {
            PreparedStatement statement = conn.prepareStatement(
            "UPDATE product SET Quantity = ? WHERE id=?");
           int q=quantity-1;
            statement.setInt(1, q);
            statement.setInt(2, id);
           statement.executeUpdate();
  MyDatabase.writeOpration(statement.toString());
         
        } catch (SQLException ex) {
            System.err.println(ex);
        }
      
    }
  
      
}