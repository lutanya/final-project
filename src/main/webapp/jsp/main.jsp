
<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 20.07.2016
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value= "${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="pagecontext" var="rb"></fmt:setBundle>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <link rel = "stylesheet" type="text/css" href="/css/style.css">
    <title><fmt:message key="title.main" bundle="${rb}"></fmt:message></title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class = "container">
    <div class = "transparent">
        <h1><fmt:message key="h1" bundle="${rb}"></fmt:message></h1>
    </div>
    <div class = "transparent">
        <jsp:include page="navbar.jsp"></jsp:include>
    </div>
    <div class = "transparent">
        <ul class="object">
            <li><a href="obj1.html"><img src="/images/house.png" alt="Пример объекта №1"></a></li>
            <li><a href="#"><img src="" alt="Пример объекта №2"></a></li>
            <li><a href="#"><img src="/images/seeshore.png" alt="Пример объекта №3"></a></li>
        </ul>
        <p class="openobj"><a href="portfolio.html"><fmt:message key="li.moreworks" bundle="${rb}"></fmt:message></a></p>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
