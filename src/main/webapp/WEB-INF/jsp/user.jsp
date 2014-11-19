<%-- 
    Document   : AuthorizedUser
    Created on : 10.11.2014, 21:47:16
    Author     : Алексей
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
        <title>Личный кабинет</title>
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
                    <li><a href="<c:url value="/users/logout" />">Выйти</a></li>
                
            </ul>
        </nav>
        
        <div class="container">
            <div class="jumbotron">
                <h1>${current.login}'s Profile</h1>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Selected User</h3>
                        </div>
                        <div class="panel-body">
                            <div>${user.login}</div>
                            <div>${user.email}</div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Current User</h3>
                        </div>
                        <div class="panel-body">
                            <div>${current.login}</div>
                            <div>${current.email}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                        
    </body>
</html>
