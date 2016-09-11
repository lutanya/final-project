<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 16.08.2016
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value= "${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="resources.pagecontext" var="rb"></fmt:setBundle>
<html>
<head>
    <title>Footer</title>
</head>
<body>
<div class="footer"><fmt:message key="footer.who" bundle="${rb}"></fmt:message><span class="tel"> 8 (029) 610 80 84 </span><fmt:message key="footer.developer" bundle="${rb}"></fmt:message></div>
</body>
</html>
