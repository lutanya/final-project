<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value= "${local}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="pagecontext" var="rb"></fmt:setBundle>
<html>
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width">
      <link rel = "stylesheet" type="text/css" href="/css/style.css">
      <link rel = "stylesheet" type="text/css" href="/css/stylecontacts.css">
      <link rel = "stylesheet" type="text/css" href="/css/styleregistr.css">
      <title><fmt:message key="title.contacts" bundle="${rb}"></fmt:message></title>
   </head>
   <body >
   <jsp:include page="header.jsp"></jsp:include>
   <div class = "container">
         <h1><fmt:message key="h1" bundle="${rb}"></fmt:message></h1>
         <jsp:include page="navbar.jsp"></jsp:include>
      <div>
         <h2>КОНТАКТНАЯ ИНФОРМАЦИЯ</h2>
      </div>
      <div class="transparent">
         <ul class="info">
            <li>Антон Корх</li>
            <li>Беларусь, Минск</li>
            <li>+375 (29) 610 80 84</li>
            <li> anton_korh@gmail.com</li>
         </ul>
         <hr>
         <p class="secbar">Если у Вас появились какие-либо вопросы или пожелания касательно моей работы, или работы сайта, Вы можете так же связаться со мной при помощи формы обратной связи:</p>
      </div>
      <div class="reg">
         <form  action="/controller" method="post">
         <fieldset>
            <input type="hidden" name="command" value="mailto" />
            <label> Имя: <input type="text" name="subject" id="inp"></label><br><br>
            <label> Ваши контактные данные: <input type="text" name="userlastname" id="inp"></label><br><br>
            <label> Сообщение: <textarea name="body" rows ="5" cols="5" id="inp"></textarea></label><br><br>
         </fieldset>
         <input type="submit" value="Отправить" id="mesbut">
         </form>
      </div>
      <jsp:include page="footer.jsp"></jsp:include>
   </body>
</html>