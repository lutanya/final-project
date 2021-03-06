<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="pagecontext" var="rb"></fmt:setBundle>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/stylecontacts.css">
    <link rel="stylesheet" type="text/css" href="/css/styleregistr.css">
    <title><fmt:message key="title.contacts" bundle="${rb}"></fmt:message></title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h1><fmt:message key="h1" bundle="${rb}"></fmt:message></h1>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div>
        <h2><fmt:message key="navigate.5" bundle="${rb}"></fmt:message></h2>
    </div>
    <div class="transparent">
        <ul class="info">
            <li><fmt:message key="h3" bundle="${rb}"></fmt:message></li>
            <li><fmt:message key="li.country" bundle="${rb}"></fmt:message></li>
            <li>+375 (29) 610 80 84</li>
            <li>anton_korh@gmail.com</li>
        </ul>
        <hr>
        <p class="secbar"><fmt:message key="feedback" bundle="${rb}"></fmt:message></p>
    </div>
    <p class="secbar">${maildeliveredsucs}</p>
    <div class="reg">

        <form action="/controller" method="post">
            <fieldset>
                <input type="hidden" name="command" value="mailto"/>
                <label><fmt:message key="label.name" bundle="${rb}"></fmt:message>:<input type="text" name="questionername" id="inpsubj"></label><br><br>
                <label><fmt:message key="label.contacts" bundle="${rb}"></fmt:message>:<input type="text" name="backmail" id="inpcont"></label><br><br>
                <label><fmt:message key="label.message" bundle="${rb}"></fmt:message>: <textarea name="body" rows="5" cols="5" id="mes"></textarea></label><br><br>
            </fieldset>
            <input type="submit" value="<fmt:message key="button.send" bundle="${rb}"></fmt:message>" id="mesbut">
        </form>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>