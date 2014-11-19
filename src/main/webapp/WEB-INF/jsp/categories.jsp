<%-- 
    Document   : categories
    Created on : 18.11.2014, 14:34:33
    Author     : Алексей
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
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
        
        <div class="container">
            <div class="jumbotron">
                <h1>Browse categories</h1>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Categories</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <c:forEach items="${cats}" var="cat">
                                    <li><a class="button" href="<c:url value="/shop/category/${cat.id}" />"> ${cat.name}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Basket</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <c:forEach items="${basket}" var="item">
                                    <li>${item.value.good.name} : <span>${item.value.count}</span></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>