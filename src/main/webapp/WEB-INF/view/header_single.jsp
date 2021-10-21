<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Header Single</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>
    <body>

        <nav class="top-nav">
            <h1 style="color: white; margin: 5px 15px 15px;float: left">GREAT NEWS</h1>
            <div class="top-nav-right">
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="<c:url value="/news/add_news"/>">ADD NEWS</a>
                </security:authorize>
                <a href="<c:url value="/news/user/own_page"/>">OWN PAGE</a>
                <a href="<c:url value="#"/>">FAVOURITE NEWS</a>
                <a href="<c:url value="#"/>">OFFER NEWS</a>
                <a href="<c:url value="/perform_logout"/>">
                    <spring:message code="user.logout"/>
                </a>
                <div class="dropdown">
                    <button class="drop-button">
                        <spring:message code="button.select.lang"/>
                    </button>
                    <div class="dropdown-content">
                        <a href="?languageVar=en">
                            <spring:message code="button.name.en"/>
                        </a>
                        <a href="?languageVar=ru">
                            <spring:message code="button.name.ru"/>
                        </a>
                    </div>
                </div>
            </div>
        </nav>

    </body>
</html>
