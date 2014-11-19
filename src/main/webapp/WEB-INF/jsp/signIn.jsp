<%-- 
    Document   : signIn
    Created on : 10.11.2014, 19:10:48
    Author     : Алексей
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вход</title>
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
        <div class="container">
              <div class="jumbotron">
                <h2>Вход</h2>
                
              <div class="container" style="width: 500px">
                  <form action="<c:url value="/j_spring_security_check"/>" method="POST" class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input name="j_username" type="email" class="form-control" id="inputEmail3" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                            <input  name="j_password" type="password" class="form-control" id="inputPassword3" placeholder="Password">
                    </div>
                </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Войти</button>
    </div>
  </div>
</form>
              </div>
                
              </div>
      
        </div>
      
       <div style="margin-left: 150px; margin-right: 150px" lang="en">&copy; Computer Academy STEP 2014 by Alex Ovsyanikov</div>
       
    </body>
</html>
