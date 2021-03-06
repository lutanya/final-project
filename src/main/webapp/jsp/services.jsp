<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<fmt:setLocale value="${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="pagecontext" var="rb"></fmt:setBundle>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/styleservices.css">
    <link rel="stylesheet" type="text/css" href="/css/styleregistr.css">
    <title><fmt:message key="title.serv" bundle="${rb}"></fmt:message></title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

    <h1><fmt:message key="h1" bundle="${rb}"></fmt:message></h1>
    <jsp:include page="navbar.jsp"></jsp:include>



    <h2><fmt:message key="navigate.2" bundle="${rb}"></fmt:message></h2>

<div class="transparent">
    <p class="secbar"><fmt:message key="services.info.1" bundle="${rb}"></fmt:message><br>
        <fmt:message key="services.info.2" bundle="${rb}"></fmt:message></p>
</div>

<h2><fmt:message key="h2" bundle="${rb}"></fmt:message></h2>
<div class="reg">
    <div class="formreg">
        <h3><fmt:message key="h3.service" bundle="${rb}"></fmt:message></h3>
            <form action="/controller" metod="post" name="orderForm">
            <input type="hidden" name="command" value="calculandorder" />
            <h4><fmt:message key="h4.service" bundle="${rb}"></fmt:message>:</h4>
            <select size="10" name="kindofwork">
                <optgroup label="<fmt:message key="label.build" bundle="${rb}"></fmt:message>">
                    <option value="Малоэтажные жилые дома"><fmt:message key="option.1" bundle="${rb}"></fmt:message></option>
                    <option value="Дома усадебного типа"><fmt:message key="option.2" bundle="${rb}"></fmt:message></option>
                    <option value="Мансарда"><fmt:message key="option.3" bundle="${rb}"></fmt:message></option>
                    <option value="Универсам"><fmt:message key="option.4" bundle="${rb}"></fmt:message></option>
                    <option value="Магазин продовольственных товаров повседневного спроса"><fmt:message key="option.5" bundle="${rb}"></fmt:message></option>
                    <option value="Булочная-кондитерская"><fmt:message key="option.6" bundle="${rb}"></fmt:message>
                    </option>
                    <option value="Киоск"><fmt:message key="option.7" bundle="${rb}"></fmt:message></option>
                    <option value="Кафе общего типа"><fmt:message key="option.8" bundle="${rb}"></fmt:message></option>
                    <option value="Пивбар"><fmt:message key="option.9" bundle="${rb}"></fmt:message></option>
                    <option value="Ресторан"><fmt:message key="option.10" bundle="${rb}"></fmt:message></option>
                    <option value="Баня"><fmt:message key="option.11" bundle="${rb}"></fmt:message></option>
                    <option value="Сауна"><fmt:message key="option.12" bundle="${rb}"></fmt:message></option>
                    <option value="Многофункциональный комплекс"><fmt:message key="option.13" bundle="${rb}"></fmt:message>
                    </option>
                    <option value="Офисно-торговый комплекс с зоной общественного питания"><fmt:message key="option.14" bundle="${rb}"></fmt:message></option>
                    <option value="Административное здание общего назначения"><fmt:message key="option.15" bundle="${rb}"></fmt:message></option>
                </optgroup>
                <optgroup label="<fmt:message key="label.interior" bundle="${rb}"></fmt:message>">
                    <option value="Интерьер I"><fmt:message key="option.16" bundle="${rb}"></fmt:message></option>
                    <option value="Интерьер II"><fmt:message key="option.17" bundle="${rb}"></fmt:message></option>
                    <option value="Интерьер III"><fmt:message key="option.18" bundle="${rb}"></fmt:message></option>
                </optgroup>
            </select>
            <br><br>
            <label>
                <h4><fmt:message key="h4.service.square" bundle="${rb}"></fmt:message>:</h4>
                <input type="number" name="square" placeholder = "0" min="0" step="0.01">m2. *<fmt:message key="asterisk" bundle="${rb}"></fmt:message>
            </label>
            <br><br>
            <h4><fmt:message key="h4.service.stage" bundle="${rb}"></fmt:message></h4>
            <input type="checkbox" name="stage[]" value="0"> <fmt:message key="stage.1" bundle="${rb}"></fmt:message>-+7,5%<br>
            <input type="checkbox" name="stage[]" value="1" checked><fmt:message key="stage.2" bundle="${rb}"></fmt:message>  - 40%<br>
            <input type="checkbox" name="stage[]" value="2" checked> <fmt:message key="stage.3" bundle="${rb}"></fmt:message> - 60%<br>
            <p id="ap"> <fmt:message key="stage.4" bundle="${rb}"></fmt:message> - 100%</p>
            <br>
            <h4><fmt:message key="h4.service.coeff" bundle="${rb}"></fmt:message></h4>
            <strong>
                <h5><fmt:message key="h5.service" bundle="${rb}"></fmt:message>:</h5>
            </strong>
            <br><fmt:message key="reduction" bundle="${rb}"></fmt:message><br>
                <fmt:message key="reduction.0" bundle="${rb}"></fmt:message>:</h5><br>
            <input type="checkbox" name="redterm[]" value="1,2">+10% - <fmt:message key="reduction.1" bundle="${rb}"></fmt:message> <br>
            <input type="checkbox" name="redterm[]" value="1,4">+30% - <fmt:message key="reduction.2" bundle="${rb}"></fmt:message> <br>
            <input type="checkbox" name="redterm[]"value="2">+40% - <fmt:message key="reduction.3" bundle="${rb}"></fmt:message><br><br>
            <h5><strong><fmt:message key="h5.overhaul" bundle="${rb}"></fmt:message>:</strong></h5>
            <br>
            <input type="checkbox" name="ohaul" value="true">-50% - <fmt:message key="h5.overhaul.1" bundle="${rb}"></fmt:message><br><br><br>
            <h5><strong><fmt:message key="h5.overhaul.2" bundle="${rb}"></fmt:message>:</strong></h5>
            <br>
            <input type="checkbox" name="tprojec[]" value="-0,65">-65% - <fmt:message key="h5.overhaul.2.1" bundle="${rb}"></fmt:message><br>
            <input type="checkbox" name="tprojec[]" value="-0,8">-80% - <fmt:message key="h5.overhaul.2.2" bundle="${rb}"></fmt:message><br>
            <input type="checkbox" name="tprojec[]" value="0,5">+50% - <fmt:message key="h5.overhaul.2.3" bundle="${rb}"></fmt:message><br>
            <input type="checkbox" name="tprojec[]" value="0,5">+50% - <fmt:message key="h5.overhaul.2.4" bundle="${rb}"></fmt:message><br>
            <input type="checkbox" name="tprojec[]" value="0,15">+15% - <fmt:message key="h5.overhaul.2.5" bundle="${rb}"></fmt:message>;<br>
            <fmt:message key="h5.overhaul.2.6" bundle="${rb}"></fmt:message> <br><br>
            <h4><fmt:message key="h3.design" bundle="${rb}"></fmt:message></h4>
            <input type="text" name="t3" disabled value="АР (<fmt:message key="li.navbar.4" bundle="${rb}"></fmt:message>)"><br><br>
            <fmt:message key="cost" bundle="${rb}"></fmt:message>: <input type="number" name="cost" readonly value="Стоимость:" placeholder="${cost}">

            <h5><input type="submit" value="<fmt:message key="button.calculate" bundle="${rb}"></fmt:message>"></h5>
            <h5><input type="submit" value="<fmt:message key="button.keeporder" bundle="${rb}"></fmt:message>">*
                <fmt:message key="asterisk.order" bundle="${rb}"></fmt:message>
            </h5>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>