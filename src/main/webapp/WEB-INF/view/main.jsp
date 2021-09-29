<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Main Page</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="../../resources/css/news_style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>
    <body>

        <c:choose>

            <c:when test="${not empty sessionScope.user}">
                <c:import url="main_session.jsp"/>
            </c:when>

            <c:when test="${empty sessionScope.user}">
                <c:import url="main_anonymous.jsp"/>
            </c:when>

        </c:choose>

        <c:import url="footer.jsp"/>
        <!-- Локаль не меняет : разобраться -->
        <%--        <h1 style="text-align: center"><spring:message code="local.write.admin"/></h1>--%>
        <%--        <a href="<%=request.getContextPath()%>?languageVar=en">EN</a>--%>
        <%--        <a href="<%=request.getContextPath()%>?languageVar=ru">RU</a>--%>
    </body>
</html>
