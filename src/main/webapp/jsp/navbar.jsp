<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value= "${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="pagecontext" var="rb"></fmt:setBundle>
<html>
   <head>

      <link rel = "stylesheet" type="text/css" href="css/style.css">
      
      <title></title>
   </head>
   <body >
     
         <div>
            <ul class="navbar">
               
               <li class = "current"><a href="/jsp/about.jsp"><fmt:message key="navigate.1" bundle="${rb}"></fmt:message> </a></li>
               <li><a href="/jsp/services.jsp"><fmt:message key="navigate.2" bundle="${rb}"></fmt:message></a></li>
               <li><a href="/controller?command=viewportfolio&i=0"><fmt:message key="navigate.3" bundle="${rb}"></fmt:message></a></li>
               <li><a href="/jsp/contacts.jsp"><fmt:message key="navigate.5" bundle="${rb}"></fmt:message></a></li>
            </ul>
         </div>
         
   </body>
</html>