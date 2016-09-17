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
<div>
    <h1><fmt:message key="h1" bundle="${rb}"></fmt:message></h1>
    <jsp:include page="navbar.jsp"></jsp:include>

</div>
<div>
    <h2>УСЛУГИ</h2>
</div>
<div class="transparent">
    <p class="secbar">Основным видом моей деятельности является архитектура и дизайн.<br> Ниже представлен детальный
        список предоставляемых мною услуг.</p>
</div>
<div class="serv">
    <table>
        <tr>
            <th>Вид деятельности</th>
            <th>Стоимость</th>
        </tr>
        <tr>
            <td>
                <a href="planning.html">Проектирование индивидуальных жилых домов и общественных зданий</a>
            </td>
            <td>
                <ul>
                    <li>эскизный проект (архитектура) -от ? за кв. м</li>
                    <li>рабочий проект (архитектура) - от ? за кв. м</li>
                    <li>рабочий проект (конструкции) - от ? за кв. м</li>
                </ul>
            </td>
        </tr>
        <tr>
            <td><a href="design.html">Дизайн-проект интерьера квартир или офисов</a></td>
            <td>
                <ul>
                    <li>эскизный проект - от ? за м2.</li>
                    <li>рабочий дизайн-проект от ? до ? за м2 (в зависимости от сложности и стилевой направленности
                        объекта, минимализм-классика)
                    </li>
                </ul>
            </td>
        </tr>
    </table>
</div>
<h2>Онлайн калькулятор: Расчет стоимости проектных работ</h2>
<div class="reg">
    <div class="formreg">
        <h3>Проектируемый объект</h3>
        <form action="/controller" metod="post" name="orderForm">
            <input type="hidden" name="command" value="calculandorder" />
            <h4>Отметьте вид работ:</h4>
            <select size="10" name="kindofwork">
                <optgroup label="Здания">
                    <option value="Малоэтажные жилые дома">Малоэтажные жилые дома</option>
                    <option value="w2">Дома усадебного типа</option>
                    <option value="w3">Мансарды (надстройки)</option>
                    <option value="w4">Универсам, магазин продовольственных товаров</option>
                    <option value="w5">Магазин продовольственных товаров повседневного спроса</option>
                    <option value="w6">Булочная-кондитерская с пекарней малой мощности, магазином и кафе (точечная
                        застройка)
                    </option>
                    <option value="w7">Магазин с ограниченным ассортиментом, киоск (точечная застройка)</option>
                    <option value="w8">Кафе общего типа</option>
                    <option value="w9">Пивбар</option>
                    <option value="w10">Ресторан</option>
                    <option value="w11">Бани</option>
                    <option value="w12">Сауны</option>
                    <option value="w13">Многофункциональный комплекс (торговые, административные и служебные помещения),
                        в т.ч. кинотеатр, танцпол, клуб и т.п.
                    </option>
                    <option value="w14">Офисно-торговый комплекс с зоной общественного питания</option>
                    <option value="w15">Административные здания общего назначения</option>
                </optgroup>
                <optgroup label="Интерьеры">
                    <option value="w16">Разработка проекта интерьера I категории сложности</option>
                    <option value="w17">Разработка проекта интерьера II категории сложности</option>
                    <option value="w18">Разработка проекта интерьера III категории сложности</option>
                </optgroup>
            </select>
            <br><br>
            <label>
                <h4>Укажите общую площадь объекта:</h4>
                <input type="number" name="square" placeholder = "0" min="0" step="0.01">m2. Используйте точку для разделения целой и
                дробной части числа
            </label>
            <br><br>
            <h4>Стадия проектирования</h4>
            <input type="checkbox" name="stage[]" value="0"> ПП (предпроектное предложение)-+7,5%<br>
            <input type="checkbox" name="stage[]" value="1" checked> А ("архитектурный проект") - 40%<br>
            <input type="checkbox" name="stage[]" value="2" checked> С ("Стоительный проект") - 60%<br>
            <p id="ap"> A+C ("архитектурный и строительный проект") - 100%</p>
            <br>
            <h4>Коэффициенты</h4>
            <strong>
                <h5>Сокращение сроков:</h5>
            </strong>
            <br>В случае сокращения по просьбе заказчика сроков проектирования по сравнению с нормативными базовая
            стоимость изменяется на:</h5><br>
            <input type="checkbox" name="redterm[]" value="1,2">+10% - при сокращение сроков в 1,2 раза <br>
            <input type="checkbox" name="redterm[]" value="1,4">+30% - при сокращение сроков в 1,4 раза <br>
            <input type="checkbox" name="redterm[]"value="2">+40% - при сокращение сроков в 2 раза и более<br><br>
            <h5><strong>Капитальный ремонт:</strong></h5>
            <br>
            <input type="checkbox" name="ohaul" value="true">-50% - разработка проектной (рабочей) документации на капитальный
            ремонт объектов<br><br><br>
            <h5><strong>Привязка типовой или повторно применяемой проектной документации без внесения
                изменений:</strong></h5>
            <br>
            <input type="checkbox" name="tprojec[]" value="-0,65">-65% - в надземную часть здания<br>
            <input type="checkbox" name="tprojec[]" value="-0,8">-80% - в надземную и подземную части здания<br>
            <input type="checkbox" name="tprojec[]" value="0,5">+50% - уникальные объекты<br>
            <input type="checkbox" name="tprojec[]" value="0,5">+50% - реконструкция и техническое перевооружение<br>
            <input type="checkbox" name="tprojec[]" value="0,15">+15% - Вечномерзлые, просадочные, набухающие грунты; карстовые и
            оползневые явления;<br> расположение площадки строительства над горными выработками, в подтапливаемых зонах
            и др.<br><br>
            <h4>Разделы проектной документации</h4>
            <input type="text" name="t3" disabled value="АР (архитектура)"><br><br>
            Стоимость: <input type="number" name="cost" readonly value="Стоимость:" placeholder="${costProject}">
            Срок: <input type="number" name="term" readonly value="Срок:"><br><br>
            <h5><input type="submit" value="Рассчитать стоимость проекта"></h5>
            <h5><input type="submit" value="Оставить заказ">
                *можно только зарегистрированным пользователям
            </h5>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>