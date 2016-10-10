<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 20.07.2016
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value= "${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="pagecontext" var="rb"></fmt:setBundle>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <link rel = "stylesheet" type="text/css" href="/css/style.css">
    <link rel = "stylesheet" type="text/css" href="/css/styleregistr.css">
    <title><fmt:message key="title.log" bundle="${rb}"></fmt:message></title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div>
    <jsp:include page="navbar.jsp"></jsp:include>
</div>
<div class="reg">
    <div class ="formreg">
        <h3><fmt:message key="h3.ent" bundle="${rb}"></fmt:message></h3>
        <form action="/controller" method="post" name="LoginForm">
            <input type="hidden" name="command" value="login" />

            <label><fmt:message key="label.login" bundle="${rb}"></fmt:message>
                <input type="text" name="login" placeholder="<fmt:message key="label.login" bundle="${rb}"></fmt:message>" id="inplog">
            </label><br><br>

            <label><fmt:message key="label.log.pass" bundle="${rb}"></fmt:message>
                <input type="password" name="password" placeholder="<fmt:message key="label.log.pass" bundle="${rb}"></fmt:message>" id="inppass">
            </label><br> <br/>
            ${errorLoginPwdMessage}
            <br/>
            ${wrongAction}
            <br/>
            ${nullPage}
            <br/>
            <input type="submit" value="<fmt:message key="header.log" bundle="${rb}"></fmt:message>" id="regbut">
        </form>
    </div>
    <div style="min-height: 30%"></div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>