<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Main Form</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="../../resources/css/news_style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>

    <body>
        <div>
            <h1 class="great-news-logo">GREAT NEWS</h1>
        </div>
        <div style="margin-right: 44%">
            <a class="base-button" href="<c:url value="/login"/>">
                <spring:message code="user.login"/>
            </a>
            <a class="base-button" href="<c:url value="/sign_up"/>">
                <spring:message code="user.signup"/>
            </a>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
