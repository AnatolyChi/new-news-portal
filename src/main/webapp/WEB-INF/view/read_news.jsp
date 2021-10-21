<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Read News</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="../../resources/css/news_style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>

    <body>
        <c:import url="header_single.jsp"/>

        <div class="news-read">
            <div>
                <c:if test="${not empty param.error_add}"><spring:message code="local.news.favourite.add.err"/></c:if>
                <c:if test="${not empty param.success_add}"><spring:message code="local.news.favourite.add.suc"/></c:if>
                <a href="<c:url value="/news/favourite_add/${news.id}"/>">ADD TO FAVOURITE</a><br>

                <c:if test="${not empty param.error_delete}"><spring:message code="local.news.favourite.delete.err"/></c:if>
                <c:if test="${not empty param.success_delete}"><spring:message code="local.news.favourite.delete.suc"/></c:if>
                <a href="<c:url value="/news/favourite_delete/${news.id}"/>">DELETE FROM FAVOURITE</a>
            </div>

            <h3>${news.title}</h3>
            <hr>
            <p>${news.content}</p>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
