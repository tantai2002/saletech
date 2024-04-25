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
//import jakarta.servlet.http.HttpSession;
//import java.sql.SQLException;
//import com.dao.checkLogin;

/**
 *
 * @author duong
 */
@WebServlet(name = "loginTemplate", urlPatterns = {"/loginTemplate"})
public class loginTemplate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        checkLogin check = new checkLogin();
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println("hello");
//        boolean isValid = checkLogin.check(username, password);
//        if (isValid) {
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            response.sendRedirect("home.jsp");
//            System.out.println("Thành công");
//        } else {
//            System.out.println("fail");
//            response.sendRedirect("login.jsp?error=true");
//        }
//    }


    

}
