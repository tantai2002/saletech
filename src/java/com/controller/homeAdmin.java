/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.dao.categoryDao;
import com.dao.cateAdminHideDao;
import com.model.categories;
import com.model.cateAdminHide;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duong
 */
@WebServlet(name = "homeAdmin", urlPatterns = {"/homeAdmin"})
public class homeAdmin extends HttpServlet {
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<String> cateRender = new ArrayList<>();
            categoryDao cateDao = new categoryDao();
            List<categories> cate = cateDao.getAllCategories();
            
            List<String> cateRenderAdHide = new ArrayList<>();
            cateAdminHideDao cateAdHideDao = new cateAdminHideDao();
            List<cateAdminHide> cateAdHide = cateAdHideDao.getAllCateAdminHide();
//            System.out.println(cate);
            if(cate.isEmpty() || cateAdHide.isEmpty()){
                System.out.println("Khong tim thay cate");
            }else{
                request.setAttribute("cate", cate);
                request.setAttribute("cateAdHide", cateAdHide);
                response.sendRedirect("homeAdmin.jsp");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(homeAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(homeAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
