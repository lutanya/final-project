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
    <link rel="stylesheet" type="text/css" href="/css/styleportfolio.css">
    <title><fmt:message key="title.portfolio" bundle="${rb}"></fmt:message></title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="containern">
    <h1><fmt:message key="h1" bundle="${rb}"></fmt:message></h1>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div>
        <h2><fmt:message key="navigate.3" bundle="${rb}"></fmt:message></h2>
    </div>
    <div class="transparent">
        <ul class="secbar">
            <li class="cursecbar"><a href="/controller?command=viewportfolio&i=0&all=true"><fmt:message key="li.navbar.1"
                                                                                               bundle="${rb}"></fmt:message></a>
            </li>
            <li><a href="/controller?command=viewportfolio&i=0&type=Жилые интерьеры"><fmt:message key="li.navbar.2"
                                                                                                  bundle="${rb}"></fmt:message></a>
            </li>
            <li><a href="/controller?command=viewportfolio&i=0&type=Общественные интерьеры"><fmt:message
                    key="li.navbar.3" bundle="${rb}"></fmt:message></a></li>
            <li><a href="/controller?command=viewportfolio&i=0&type=Архитектура"><fmt:message key="li.navbar.4"
                                                                                              bundle="${rb}"></fmt:message></a>
            </li>
        </ul>
    </div>
    <c:if test="${admin}">
    <div class="change">
       <ul class="secbar">
            <li>

                <a href="/jsp/addnewobj.jsp"><fmt:message key="li.add" bundle="${rb}"/></a>

            </li>
            <li><a href="/controller?command=editingportfolio&action=remove"><fmt:message key="li.remove" bundle="${rb}"/> </a></li>
            <li><a href="/controller?command=editingportfolio&action=edit"><fmt:message key="li.edit" bundle="${rb}"/> </a></li>

        </ul>

    </div>
    </c:if>


    <div class="np">
        <br>
        <fmt:message key="pagenumber" bundle="${rb}"/>: ${numberofpage} ${suscsesfullremoveobj}

    </div>
    <div class="portf">
        <ctg:block-image blockCount="${delimCount}"></ctg:block-image>

        <c:if test="${remove}">
        <form action="/controller?command=editingportfolio&action=remove" method="post" name="removeform">

            </c:if>
                <c:if test="${edit}">
                <form action="/controller?command=editingportfolio&action=edit" method="post" name="editform">
                    </c:if>
            <ul class="objportf">

                <c:if test="${type eq null or empty type}">
                    <c:forEach var="elem" items="${obj}" varStatus="status" begin="${i}" end="${i+2}">
                        <li>
                            <c:if test="${edit}"><input type="radio" name="idobjectoedit" value="${elem.id}"></c:if>
                            <c:if test="${remove}">
                                <c:set var="k" value="${elem.id}"></c:set>
                                <input type="checkbox" name="obj[]" value="${k}">

                            </c:if>
                            <c:if test="${localRu}">
                            <div class="photo" data-title="${elem.objName}">
                                <a href="/controller?command=viewworkinfo&id=${elem.id}&genre=${elem.objGenre}&show=this">
                                    <img src="${elem.objPhoto[0].fotoUrl}" alt=<c:out value="${elem.objGenre}"/>></a></div></c:if>
                                <c:if test="${localEn}">
                                <div class="photo" data-title="${elem.objNameEn}">
                                    <a href="/controller?command=viewworkinfo&id=${elem.id}&genre=${elem.objGenre}&show=this">
                                        <img src="${elem.objPhoto[0].fotoUrl}" alt=<c:out value="${elem.objGenreEn}"/>></a></div></c:if>

                        </li>
                    </c:forEach>
                </c:if>

                <c:if test="${type != null}">
                    <c:forEach var="elem" items="${objbygenre}" varStatus="status" begin="${i}" end="${i+2}">
                        <c:if test="${elem.objGenre eq type}">
                            <li>
                                <c:if test="${edit}"><input type="radio" name="idobjectoedit" value="${elem.id}"></c:if>
                                <c:if test="${remove}">
                                    <c:set var="k" value="${elem.id}"></c:set>
                                    <input type="checkbox" name="obj[]" value="${k}">

                                </c:if>
                                <c:if test="${localRu}">
                                <div class="photo" data-title="${elem.objName}">
                                    <a href="/controller?command=viewworkinfo&id=${elem.id}&genre=${elem.objGenre}&show=this">
                                        <img src="${elem.objPhoto[0].fotoUrl}" alt=<c:out value="${elem.objGenre}"/>>
                                    </a></div></c:if>
                                    <c:if test="${localEn}">
                                    <div class="photo" data-title="${elem.objNameEn}">
                                        <a href="/controller?command=viewworkinfo&id=${elem.id}&genre=${elem.objGenre}&show=this">
                                            <img src="${elem.objPhoto[0].fotoUrl}" alt=<c:out value="${elem.objGenreEn}"/>>
                                        </a></div></c:if>

                            </li>
                        </c:if>
                    </c:forEach>
                </c:if>

            </ul>
                <c:if test="${edit}"><input type="submit" value="<fmt:message key="li.edit" bundle="${rb}"/>">
                </form>
        </c:if>
            <c:if test="${remove}"> <input type="submit" value="<fmt:message key="li.remove" bundle="${rb}"/>">
        </form>
        </c:if>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>