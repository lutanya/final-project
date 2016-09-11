<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<fmt:setLocale value= "${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="resources.pagecontext" var="rb"></fmt:setBundle>
<html>
   <head>
      <meta charset="utf-8">

      <link rel = "stylesheet" type="text/css" href="/css/style.css">
      <link rel = "stylesheet" type="text/css" href="/css/styleobj.css">
      <title><fmt:message key="title.main" bundle="${rb}"></fmt:message></title>
   </head>
   <body>
   <jsp:include page="header.jsp"></jsp:include>
   <div>
       <h1><fmt:message key="h1" bundle="${rb}"></fmt:message></h1>
       <jsp:include page="navbar.jsp"></jsp:include>

   </div>
         <div>
            <h2>ПОРТФОЛИО</h2>
         </div>
         <div class="transparent">
            <ul class = "secbar">
               <li><a href="/controller?command=viewportfolio&i=0">Все</a>/</li>
               <li><a href="resinter.html"><c:out value="${work.objGenre}"></c:out></a>/</li>
               <li class = "cursecbar"><a href="pubinter.html"><c:out value="${work.objName}"></c:out></a></li>
            </ul>
         </div>
         <div class = "work"> 
           <table class="cent">
             <tbody>
               <tr>
                 <td><img src ="${work.objPhoto[0].fotoUrl}"></td>
            <td id="col2"><h3><c:out value="${work.objName}"></c:out></h3>
           <div class="blc">
<c:if test="${!work.first}"><a href="/controller?command=viewworkinfo&id=${work.id}&genre=${work.objGenre}&show=previous">← Предыдущая </a></c:if>
               <a href="/controller?command=viewportfolio&i=0">Все работы</a>
               <c:if test="${!work.last}"><a href="/controller?command=viewworkinfo&id=${work.id}&genre=${work.objGenre}&show=next"> Следующая →</a></c:if>
</div>
<div class="work-text">
            <c:out value="${work.objInfo}"></c:out></div>
             </td></tr>
             </tbody>
           </table>

         </div>
<div class="work">
    <h5>другие фото:</h5>
    <table class="addfo">
        <tbody>
        <tr>
            <c:forEach var="elem" items="${work.objPhoto}" varStatus="status">
                <td>
                    <a href="#openModal">
                    <img src="${elem.fotoUrl}"></a>
                </td>

                <div id="openModal" class="modalDialog">
                    <div><a href="#close" title="Закрыть" class="close">X</a>
                        <img src="${elem.fotoUrl}">
                        <figure class="imgteaser">
                            <figcaption>СЛЕДУЮЩАЯ</figcaption>
                        </figure>
                        <figure class="previmg">
                            <figcaption>ПРЕДЫДУЩАЯ</figcaption>
                        </figure>

                    </div>

                </div>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>
   <jsp:include page="footer.jsp"></jsp:include>
   </body>
</html>