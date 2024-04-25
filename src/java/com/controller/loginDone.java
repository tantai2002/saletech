/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import com.dao.checkLogin;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author duong
 */
@WebServlet(name = "loginDone", urlPatterns = {"/loginDone"})
public class loginDone extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            checkLogin check = new checkLogin();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
//            System.out.println("hello");
            boolean isValid = check.authLogin(username, password);
            //        System.out.println(checkLogin.check(username, password));
            if (isValid) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("homeAdmin.jsp");
//                System.out.println("Thành công");
            } else {
                System.out.println("fail");
                response.sendRedirect("login.jsp?error=true");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(loginDone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
