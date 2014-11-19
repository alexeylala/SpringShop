<%-- 
    Document   : error403
    Created on : 18.11.2014, 14:44:38
    Author     : Алексей
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Музыкальный магазин</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">   
    
    </head>
    <body>
        <div class="page-header">
            <h1>Музыкальный магазин</h1>
        </div>
        <nav class="navbar navbar-inverse"  role="navigation">

            <ul class="nav nav-pills">
                
                   
                    <li><a href="<c:url value="/front/start"/>">Главная</a></li>
                    <li><a href="<c:url value="/good/getGoods"/>">Каталог товаров</a></li>
                    <li><a href="<c:url value="/users/getUsers"/>">Список пользователей</a></li>
                    <li><a href="#">Зарегистрироваться</a></li>
                    <li><a href="<c:url value="/front/getSignIn"/>">Вход</a></li>
                
            </ul>
            
        </nav>
        <div style="margin-left: 150px; margin-right: 150px" lang="en">&copy; Computer Academy STEP 2014 by Alex Ovsyanikov</div>
    </body>
</html>
