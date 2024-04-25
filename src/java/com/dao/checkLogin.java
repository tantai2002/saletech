/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duong
 */
public class checkLogin {

    public static boolean check(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    public static boolean check(String username, String password) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    public boolean authLogin(String username, String password) throws ClassNotFoundException, SQLException{
//        String url="jdbc:mysql://localhost:3306/saletech";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/saletech",
                "root", "1111"
            );
//            System.out.println(conn);
            String query = "SELECT * FROM user WHERE nameUser = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, hashPassword(password));
//            System.out.println(hashPassword(password));
            // Thực thi truy vấn
                ResultSet resultSet = statement.executeQuery();
//                System.out.println(resultSet);
                // Kiểm tra xem có kết quả trả về hay không
                if (resultSet.next()) {
                    // Nếu có kết quả, tức là thông tin đăng nhập hợp lệ
                    conn.close(); // Đóng kết nối
                    return true;
                } else {
                    // Nếu không có kết quả, thông tin đăng nhập không hợp lệ
                    conn.close(); // Đóng kết nối
                    return false;
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(checkLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] byteData = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : byteData) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        checkLogin check = new checkLogin();
//        String testUsername = "admin1";
//        String testPassword = "123456";
//
//        if (!check.authLogin(testUsername, testPassword)) {
//              System.out.println("Thông tin đăng nhập không hợp lệ!");
//        } else {
//            System.out.println("Đăng nhập thành công!");
//        }
//    }
}
