<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Own Page</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="../../resources/css/news_style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>
    <body>

        <div>
            <p><spring:message code="local.firstname"/> : ${user.firstname}</p>
            <p><spring:message code="local.lastname"/> : ${user.lastname}</p>
            <p><spring:message code="local.age"/> : ${user.age}</p>
            <p><spring:message code="local.date.reg"/> : ${user.dateRegistered}</p>
        </div>

    </body>
</html>
