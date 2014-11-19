<%-- 
    Document   : seeAllGoods
    Created on : 10.11.2014, 20:37:10
    Author     : Алексей
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Каталог товаров</title>
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
            <div class="jumbotron">
                <h1>Товары</h1>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Товары доступные пользователю - ${current.login}</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <c:forEach items="${goods}" var="good">
                                    
                                    <li>${good.name},${good.description},${good.price} грн.<a class="label label-success" style="float: right" href="<c:url value="/shop/add/${good.categoryId}/${good.id}" />">Добавить в корзину</a></li>

                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Ваша корзина</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <c:forEach items="${basket}" var="item">
                                    <li>${item.value.good.name} : <span>${item.value.count}</span><a class="glyphicon glyphicon-remove"  href="<c:url value="/shop/remove/${item.value.good.id}" />"></a></li>
                                </c:forEach>
                            </ul>
                        </div>
                       
                    </div>
                    <span><a class="btn btn-primary btn-lg" href="<c:url value="/shop/makeOrder/${current.id}" />" >Оформить заказ</a></span>
                </div>
            </div>
        </div>
</body>
</html>
