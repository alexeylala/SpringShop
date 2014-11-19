<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                
                <li><a href="<c:url value="/front/start"/> ">Главная</a></li>
                    <li><a href="<c:url value="/good/getGoods"/>">Каталог товаров</a></li>
                    <li><a href="<c:url value="/users/getUsers"/>">Список пользователей</a></li>
                    <li><a href="#">Зарегистрироваться</a></li>
                    <li><a href="<c:url value="/front/getSignIn"/>">Вход</a></li>
                
            </ul>
            
        </nav>
        <div class="container">
            
            <div class="jumbotron">
            <h2>Добро пожаловать!</h2>
                <ul>
                    <li><a href="/MyMaven/front/start">Главная</a></li>
                    <li><a href="/MyMaven/good/getGoods">Каталог товаров</a></li>
                    <li><a href="/MyMaven/user/getUsers">Список пользователей</a></li>
                    <li><a href="#">Зарегистрироваться</a></li>
                    <li><a href="/MyMaven/front/getSignIn">Вход</a></li>
                </ul>
            </div>
        </div>
 
        <div style="margin-left: 150px; margin-right: 150px" lang="en">&copy; Computer Academy STEP 2014 by Alex Ovsyanikov</div>
    </body>
</html>
