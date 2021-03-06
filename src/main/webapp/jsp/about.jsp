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
    <link rel="stylesheet" type="text/css" href="/css/styleabout.css">
    <title><fmt:message key="title.about" bundle="${rb}"></fmt:message></title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div>
    <h1>
        <fmt:message key="h1" bundle="${rb}"></fmt:message>
    </h1>
    <jsp:include page="navbar.jsp"></jsp:include>
</div>
<div>
    <h2><fmt:message key="navigate.1" bundle="${rb}"></fmt:message></h2>
</div>
<div class="transparent">
    <ul class="secbar">
        <li class="cursecbar"><a href="/jsp/about.jsp"><fmt:message key="navigate.about.1" bundle="${rb}"></fmt:message></a></li>
        <li><a href="/jsp/prinсiples.jsp"><fmt:message key="navigate.about.2" bundle="${rb}"></fmt:message></a></li>
    </ul>
</div>
<div class="about">
    <h3><fmt:message key="h3" bundle="${rb}"></fmt:message></h3>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sollicitudin, ipsum id pretium tristique,
        arcu felis pretium ante, quis interdum lacus ligula nec metus. Aenean suscipit sit amet ipsum at dapibus. Aenean
        fringilla quis urna at iaculis. Nullam nec tortor at dui condimentum suscipit ultrices at magna. Etiam gravida
        suscipit tempus. Nam tempor orci eu risus lacinia luctus. Nam ornare arcu sit amet nunc maximus, sed aliquam
        nisl aliquam. Fusce tempus lorem nec ullamcorper lacinia. Cras non elit est. Vivamus et odio at leo blandit
        pretium. Aenean placerat lorem ipsum, non ornare sapien condimentum vitae. Etiam nec libero id eros pharetra
        pharetra.</p>
    <p>Pellentesque a libero consectetur, mollis tortor in, posuere erat. Nam nec nunc eu risus dignissim porta. Nullam
        sodales tincidunt ante sit amet porta. Suspendisse arcu dolor, dapibus ut purus id, pretium volutpat est.
        Aliquam tincidunt interdum dui a elementum. Aenean dapibus urna quam, sit amet tempor arcu vulputate a. Mauris
        non aliquet arcu. Maecenas sed iaculis lectus, ac mattis arcu. Nam gravida, risus eu elementum pharetra, nisi
        nulla eleifend tortor, in pharetra erat justo consectetur ipsum. In hac habitasse platea dictumst. Integer a
        ante finibus, interdum nibh ac, sodales lectus. Vestibulum tristique nulla felis, id accumsan nibh semper quis.
        In sodales nisl ac purus pharetra, et varius elit pharetra. Cras scelerisque lectus sapien.</p>
    <p>Proin auctor mauris ut vulputate convallis. Nulla cursus velit tristique tellus tempus placerat. Integer eget
        erat tempus, ornare turpis non, pretium mauris. Quisque et leo lectus. Donec malesuada luctus tellus quis
        efficitur. Mauris vitae pellentesque diam, a ultrices metus. Sed pellentesque turpis eget augue consectetur, non
        volutpat elit feugiat. Quisque sed ligula eget risus rutrum bibendum. Lorem ipsum dolor sit amet, consectetur
        adipiscing elit. Pellentesque quis risus sed diam vulputate sollicitudin. Vivamus aliquet suscipit dolor non
        vestibulum. Phasellus in nulla enim. Curabitur vel orci nec augue ullamcorper pulvinar.</p>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>