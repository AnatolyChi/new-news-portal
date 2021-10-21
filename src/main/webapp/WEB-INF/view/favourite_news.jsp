<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Favourite News</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="../../resources/css/news_style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>

    <body>
        <c:import url="header_single.jsp"/>

        <div style="margin-top: 20px; margin-left: 33px">
            <c:if test="${not empty favouriteNewsList}">
                <c:forEach var="news" items="${favouriteNewsList}">
                    <div class="newsMain">
                        <div style="float: left">
                            <p style="font-size: x-small; text-align: left">Author: ${news.user.username}</p>
                            <p style="font-size: x-small; text-align: left">${news.date}</p>
                        </div>
                        <div>
                            <p>${news.title}</p>
                        </div>
                        <a href="<c:url value="/news/read/${news.id}"/>">READ</a>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <a href="<c:url value="/news/update/${news.id}"/>">UPDATE</a>
                            <a href="<c:url value="/news/delete/${news.id}"/>">DELETE</a>
                        </security:authorize>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty favouriteNewsList}">
                <h1 style="text-align: center">
                    <spring:message code="local.news.favourite.empty.list"/>
                </h1>
            </c:if>
        </div>

    </body>
</html>
