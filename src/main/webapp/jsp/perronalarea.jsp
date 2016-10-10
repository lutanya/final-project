<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 09.10.2016
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<fmt:setLocale value="${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="pagecontext" var="rb"></fmt:setBundle>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/styleregistr.css">
    <link rel="stylesheet" type="text/css" href="/css/styleperspage.css">
    <title><fmt:message key="title.reg" bundle="${rb}"></fmt:message></title>
</head>
<body>
<table>
    <tbody>

    </tbody>
</table>
</body>
</html>
