/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import core.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Gokhan
 * modified by braydenphanna
 */
public class ProductDAO implements DAO<Product>
{   
    public ProductDAO() {
        
    }
    List<Product> customers;
    /**
     * Get a single customer entity as a customer object
     * @param id
     * @return 
     */
    @Override
    public Optional<Product> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM HD_Product WHERE Product_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Product customer = null;
            while (rs.next()) {
                customer = new Product(rs.getInt("Product_ID"), rs.getString("Product_Name"), rs.getString("Product_Description"), rs.getString("Product_Color"), rs.getString("Product_Size"), rs.getString("Product_Price"));
            }
            return Optional.ofNullable(customer);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        } catch (Exception ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all customer entities as a List
     * @return 
     */
    @Override
    public List<Product> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        customers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HD_Product";
            rs = db.executeQuery(sql);
            Product customer = null;
            while (rs.next()) {
                customer = new Product(rs.getInt("Product_ID"), rs.getString("Product_Name"), rs.getString("Product_Description"), rs.getString("Product_Color"), rs.getString("Product_Size"), rs.getString("Product_Price"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert a customer object into customer table
     * @param customer 
     */
    @Override
    public void insert(Product customer)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO HD_Product(Product_ID, Product_Name, Product_Description, Product_Color, Product_Size, Product_Price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, customer.getProductID());
            stmt.setString(2, customer.getProductName());
            stmt.setString(3, customer.getProductDescription());
            stmt.setString(4, customer.getProductColor());
            stmt.setString(5, customer.getProductSize());
            stmt.setString(6, customer.getProductPrice());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new customer was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a customer entity in database if it exists using a customer object
     * @param customer
     */
    @Override
    public void update(Product customer) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE HD_Product SET Product_Name=?, Product_Description=?, Product_Color=?, Product_Size=?, Product_Price=? WHERE Product_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, customer.getProductName());
            stmt.setString(2, customer.getProductDescription());
            stmt.setString(3, customer.getProductColor());
            stmt.setString(4, customer.getProductSize());
            stmt.setString(5, customer.getProductPrice());
            stmt.setInt(6, customer.getProductID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing customer was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a customer from customer table if the entity exists
     * @param customer 
     */
    @Override
    public void delete(Product customer) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM HD_Product WHERE Product_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, customer.getProductID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A customer was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Get all column names in a list array
     * @return 
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HD_Product WHERE Product_ID = -1";//We just need this sql query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            //Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));//Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        } 
    }
}
