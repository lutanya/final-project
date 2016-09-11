<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 15.08.2016
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value= "${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="pagecontext" var="rb"></fmt:setBundle>
<html>
<head>
    <title>Header</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <link rel = "stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<br>
<ul class="lclchange">
    <ctg:set-local local="en_US"/>
    <ctg:set-local local="ru_RU"/>
</ul>
<br>
<p class="openobj">
    <a href="/jsp/registration.jsp"><fmt:message key="header.reg" bundle="${rb}"></fmt:message></a>|<a href="/jsp/login.jsp"><fmt:message key="header.log" bundle="${rb}"></fmt:message></a>
</p>
</body>
</html>
