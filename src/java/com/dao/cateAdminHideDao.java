/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.cateAdminHide;
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
public class cateAdminHideDao {
    public List<cateAdminHide> getAllCateAdminHide() throws SQLException, ClassNotFoundException {
        List<cateAdminHide> cateAdHide = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/saletech",
                "root", "1111"
            );
            String query = "SELECT * FROM cateAdminHide";
            PreparedStatement statement = conn.prepareStatement(query);
//            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idcateAdminHide");
//                System.out.println("hellow");
                String name = resultSet.getString("namecateAdminHide");
                int cateAdmin_id = resultSet.getInt("cateAdmin_id");
                String nameserv = resultSet.getString("nameserv");
                cateAdminHide category = new cateAdminHide(id, name, cateAdmin_id, nameserv);
                cateAdHide.add(category);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(checkLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(cateAdHide);
        return cateAdHide;
    }
}
