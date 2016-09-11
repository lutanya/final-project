<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 20.07.2016
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding = "UTF-8"%>
<%--<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/styleregistr.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Login</title>
</head>
<body>
<div class="reg">
    <div class ="formreg">
<form name="LoginForm" method="post" action="controller">
    <input type="hidden" name="command" value="login" />
    Логин:<br/>
    <input type="text" name="login" value="" />
    <br/>Пароль:<br/>
    <input type="password" name="password" value="" />
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <input type="submit" value="Войти"/>
</form><hr/>
        </div>
    </div>
</body>
</html>
<html>--%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <link rel = "stylesheet" type="text/css" href="/css/style.css">
    <link rel = "stylesheet" type="text/css" href="/css/styleregistr.css">
    <title>Услуги архитектора.</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div>
    <jsp:include page="navbar.jsp"></jsp:include>
</div>
<div class="reg">
    <div class ="formreg">
        <h3>Вход</h3>
        <form action="/controller" metod="post" name="LoginForm">
            <input type="hidden" name="command" value="login" />

            <label> Логин <input type="text" name="login" placeholder="Логин" id="inp"></label><br><br>

            <label> Пароль <input type="password" name="password" placeholder="Пароль" id="inp"></label><br> <br/>
            ${errorLoginPwdMessage}
            <br/>
            ${wrongAction}
            <br/>
            ${nullPage}
            <br/>
            <input type="submit" value="Войти" id="regbut">
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>