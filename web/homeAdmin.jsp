<%-- 
    Document   : home
    Created on : Apr 23, 2024, 2:11:28 PM
    Author     : duong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.dao.categoryDao"  %>
<%@page import="com.model.categories"  %>
<%@page import="com.dao.cateAdminHideDao"  %>
<%@page import="com.model.cateAdminHide"  %>
<%@page import="com.controller.homeAdmin" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="http://localhost:8080/BTL/static/css/homeAdmin.css"  type="text/css" rel="stylesheet"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <style>
            h1{
                color: red;
            }
        </style>
    </head>
    <body>
        <div>
            <ul class="nav nav-tabs">
                <%
                    List<String> cateRender = new ArrayList<>();
                    categoryDao cateDao = new categoryDao();
                    List<categories> cate = cateDao.getAllCategories();
                    for(categories category : cate){
//                    cateRender.add(category.getName());
                %>
                <li class="nav-item"><a class="nav-link disabled" href="/<%= category.getId() %>"><%= category.getName() %></a>
                    <ul>
                        
                        <%
                            List<String> cateRenderAdHide = new ArrayList<>();
                            cateAdminHideDao cateAdHideDao = new cateAdminHideDao();
                            List<cateAdminHide> cateAdHide = cateAdHideDao.getAllCateAdminHide();

                            for(cateAdminHide categoryHide : cateAdHide){
                                if(category.getId() == categoryHide.getCateAdmin_id()){
                        %>
                        
                                    <li>
                                        <a class="nav-link" href="<%= categoryHide.getNameserv() %>" id="<%= categoryHide.getId() %>"><%= categoryHide.getName() %></a>
                                    </li>
                                    <script>
                                        $(document).ready(function(){
                                            $("#<%= categoryHide.getId() %>").click(function(event){
//                                                event.preventDefault(); // Ngăn chặn hành động mặc định của thẻ a
                                                $.ajax({
                                                    url: "<%= categoryHide.getNameserv() %>", // Địa chỉ của servlet
                                                    type: "GET",
                                                    success: function(response){
                                                        // Xử lý phản hồi từ servlet (nếu cần)
                                                        console.log(response);
                                                        response;
                                                    }
                                                });
                                            });
                                        });
                                    </script>
                                <%
                                }
                            }   
                                %>
                    </ul>
                </li>
                <% 
                }
                %>
            </ul>
        </div>
            
        
    </body>
</html>
