/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.categories;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author duong
 */
public class categoryDao {
    public List<categories> getAllCategories() throws SQLException, ClassNotFoundException {
        List<categories> cate = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/saletech",
                "root", "1111"
            );
            String query = "SELECT * FROM cateAdmin";
            PreparedStatement statement = conn.prepareStatement(query);
//            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idcateAdmin");
//                System.out.println("hellow");
                String name = resultSet.getString("namecateAdmin");
                categories category = new categories(id, name);
                cate.add(category);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(checkLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(cate);
        return cate;
    }
    
    
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        categoryDao cateDao = new categoryDao();
//        List<categories> cate = cateDao.getAllCategories();
//        if(cate.isEmpty()){
//            System.out.println("Khong tim thay cate");
//        }else{
//            System.out.println("Danh sach cate:");
//            System.out.println(cate);
//            for(categories category : cate){
//                System.out.println("Name: "+category.getName());
//            }
//        }
//    }
    
    
}
