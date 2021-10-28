<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <a href="<c:url value="/news/favourite_add/${news.id}"/>">
                    <spring:message code="local.news.favourite.page"/>
                </a><br>

                <c:if test="${not empty param.error_delete}"><spring:message code="local.news.favourite.delete.err"/></c:if>
                <c:if test="${not empty param.success_delete}"><spring:message code="local.news.favourite.delete.suc"/></c:if>
                <a href="<c:url value="/news/favourite_delete/${news.id}"/>">
                    <spring:message code="local.news.favourite.delete"/>
                </a>
            </div>

            <h3>${news.title}</h3>
            <hr>
            <p>${news.content}</p>

            <a style="float: left; margin-top: 30px" href="<c:url value="/news/"/>">
                <img style="width: 29px;" src="../../resources/img/chevron%20with%20circle%20left.svg" alt="back">
            </a>
        </div>

        <c:url var="addNewComment" value="/news/comment">
            <c:param name="newsId" value="${news.id}" />
        </c:url>

        <form:form action="/news/comment" modelAttribute="comment" method="POST" cssStyle="margin-left: 45%">

            <form:hidden path="news.id" value="${newsId}"/>

            <form:errors path="contentComment"/>
            <form:textarea path="contentComment" rows="10" cols="20"/>

            <input type="hidden" name="news" value="${newsId}">
            <input style="margin-top: 30px; margin-left: 230px; float: left" class="submit-button" type="submit" value="submit">
        </form:form>

        <c:import url="footer.jsp"/>
    </body>
</html>
