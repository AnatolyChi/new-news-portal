<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:import url="header_single.jsp"/>

        <div style="margin: auto">
            <p><spring:message code="local.firstname"/> : ${user.firstname}</p>
            <p><spring:message code="local.lastname"/> : ${user.lastname}</p>
            <p><spring:message code="local.email"/> : ${user.email}</p>
            <p><spring:message code="local.age"/> : ${user.age}</p>
            <p><spring:message code="local.date.reg"/> : ${user.dateRegistered}</p>

            <a href="<c:url value="/news/user/update_own_page"/>">
                <spring:message code="local.personal_page.edit"/>
            </a>

            <a style="float: left; margin-top: 30px" href="<c:url value="/news/"/>">
                <img style="width: 29px;" src="../../resources/img/chevron%20with%20circle%20left.svg" alt="back">
            </a>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
