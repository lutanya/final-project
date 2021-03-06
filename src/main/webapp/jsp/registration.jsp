<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="pagecontext" var="rb"></fmt:setBundle>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/styleregistr.css">
    <title><fmt:message key="title.reg" bundle="${rb}"></fmt:message></title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div>
    <jsp:include page="navbar.jsp"></jsp:include>
</div>
<div class="reg">
    <div class="formreg">
        <h3><fmt:message key="header.reg" bundle="${rb}"></fmt:message></h3>
        <form action="/controller" method="post" name="register">
            <input type="hidden" name="command" value="registration"/>
            <table class="frmtable">
                <tbody>
                <tr>
                    <th>
                        <label for="username"><fmt:message key="label.name" bundle="${rb}"></fmt:message><span>*</span></label>
                    </th>
                    <td>
                        <input type="text" name="username" id="username" value="${user.name}">
                    </td>
                    <td>
                        <span id="er">${dontInputName}</span>
                    </td>
                </tr>
                <tr>
                    <th>
                        <label for="userln"> <fmt:message key="label.lname" bundle="${rb}"></fmt:message></label>
                    </th>
                    <td>
                        <input type="text" name="userlastname" id="userln">
                    </td>
                    <td>
                        <span id="er">${dontInputLname}</span>
                    </td>
                </tr>
                <tr>
                    <th>
                        <label for="log">
                            <fmt:message key="label.login" bundle="${rb}"></fmt:message><span>*</span>
                        </label>
                    </th>
                    <td>
                        <input type="text" name="login" id="log">
                    </td>
                    <td>
                     <span id="er">${dontInputLogin}
                         ${doublicatelog}</span>
                    </td>
                </tr>
                <tr>
                    <th>
                        <label for="psw1"> <fmt:message key="label.password" bundle="${rb}"></fmt:message><span>*</span></label>
                    </th>
                    <td>
                        <input type="password" name="pwd1" id="psw1">
                    </td>
                    <td>
                      <span id="er">${wrongPsw}
                          ${errorRepeatPass}</span>
                    </td>
                </tr>
                <tr>
                    <th>
                        <label for="psw2">
                            <fmt:message key="label.rpassword" bundle="${rb}"></fmt:message><span>*</span>
                        </label>
                    </th>
                    <td>
                        <input type="password" name="pwd2" id="psw2">
                    </td>
                    <td>
                    </td>
                </tr>
                <tr class="delimiter">
                    <th style="padding-top: 20px;">
                        <label for><fmt:message key="label.sex" bundle="${rb}"></fmt:message><span>*</span></label>
                    </th>

                    <td style="padding-top: 20px;">
                    <label><input type="radio" name="choicesex" id = "msex"/>
                        <fmt:message key="sex.m" bundle="${rb}"></fmt:message>
                    </label>
                    <label><input type="radio" name="choicesex" id = "fsex"/>
                        <fmt:message key="sex.fm" bundle="${rb}"></fmt:message>
                    </label>
                </td>
                <td style="padding-top: 20px;"><span id="er">${dontInputSex}</span></td>
                    <tr>
                    <th>
                        <label for="cntry"><fmt:message key="label.country" bundle="${rb}"></fmt:message><span>*</span></label>
                    </th>
                    <td>
                        <select size="1" name="contry" id="cntry">
                            <option value="a"></option>
                            <option value="b"><fmt:message key="country.bel" bundle="${rb}"></fmt:message></option>
                            <option value="c"><fmt:message key="country.rus" bundle="${rb}"></fmt:message></option>
                        </select>
                    </td>
                    <td><span id="er">${dontInputCountry}</span></td>
                </tr>
                <tr>
                    <th>
                        <label for="city">
                            <fmt:message key="label.city" bundle="${rb}"></fmt:message><span>*</span>
                        </label>
                    </th>
                    <td>
                        <input type="text" name="city" id="city">
                    </td>
                    <td><span id="er">${dontInputCity}</span></td>
                </tr>
                <tr>
                    <th>
                        <label for="email">
                            <fmt:message key="label.email" bundle="${rb}"></fmt:message><span>*</span>
                        </label>
                    </th>
                    <td>
                        <input type="email" name="mail" id="email">
                    </td>
                    <td><span id="er">${dontInputMail}</span></td>
                </tr>
                <tr>
                    <th>
                        <label for="phone"><fmt:message key="label.phone" bundle="${rb}"></fmt:message></label>
                    </th>
                    <td>
                        <input type="tel" name="phone" id="phone">
                    </td>
                    <td><span id="er">${wrongPhone}</span></td>
                </tr>
                <tr class="delimiter">
                    <th></th>
                    <td colspan="2"><span>*</span>
                        <span id="star">-<fmt:message key="remark" bundle="${rb}"></fmt:message></span>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td colspan="2">
                        <input type="submit"
                               value="<fmt:message key="button.reg" bundle="${rb}"></fmt:message>"
                               id="regbut">
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>