/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HP
 */
public class Product {
    private int id;

 
    private int Quantity;
    private String  type;
    private double Price;
    private String Image;

    public Product(int Quantity, String type, double Price, String Image) {
        this.Quantity = Quantity;
        this.type = type;
        this.Price = Price;
        this.Image = Image;
    }
    
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

   
    public String getImage() {
        return Image;
    }

  
    public void setImage(String Image) {
        this.Image = Image;
    }
    
}
