<%-- 
    Document   : SeeAllUsers
    Created on : 09.11.2014, 17:57:01
    Author     : Алексей
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Пользователи</title>
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
                    <li><a href="<c:url value="/users/logout" />">Выход</a></li>
                    
            </ul>
            
        </nav>
        <div class="container">
            
            <h1>All users!</h1>
            <ul>
            <c:forEach items="${users}" var="user"> 
                <li>${user.login}, ${user.email}</li>
            </c:forEach>
            </ul>
        </div>
 
        <div style="margin-left: 150px; margin-right: 150px" lang="en">&copy; Computer Academy STEP 2014 by Alex Ovsyanikov</div>
    
</body>
    
</html>
