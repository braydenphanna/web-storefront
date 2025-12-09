/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Gokhan
 * modified by braydenphanna
 */

public class Product {

    private int productID;
    private String productName;
    private String productDescription;
    private String productColor;
    private String productSize;
    private String productPrice;

    public Product(int productID, String productName, String productDescription,
                   String productColor, String productSize, String productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productColor = productColor;
        this.productSize = productSize;
        this.productPrice = productPrice;
    }

    public Product() {

    }
    // Getters
    public int getProductID() {return productID;}
    public String getProductName() {return productName;}
    public String getProductDescription() {return productDescription;}
    public String getProductColor() {return productColor;}
    public String getProductSize() {return productSize;}
    public String getProductPrice() {return productPrice;}

    // Setters
    public void setProductID(int productID) {this.productID = productID;}
    public void setProductName(String productName) {this.productName = productName;}
    public void setProductDescription(String productDescription) {this.productDescription = productDescription;}
    public void setProductColor(String productColor) {this.productColor = productColor;}
    public void setProductSize(String productSize) {this.productSize = productSize;}
    public void setProductPrice(String productPrice) {this.productPrice = productPrice;}

    @Override
    public String toString() {
        return "Product{ " +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productPrice='" + productPrice + '\'' +
                " }";
    }
}

