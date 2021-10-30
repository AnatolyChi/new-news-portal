<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

        <spring:message var="Admin" code="local.comment.admin"/>

        <div class="news-read">
            <div>
                <c:if test="${not empty param.error_add}"><spring:message code="local.news.favourite.add.err"/></c:if>
                <c:if test="${not empty param.success_add}"><spring:message code="local.news.favourite.add.suc"/></c:if>
                <a href="<c:url value="/news/favourite_add/${news.id}"/>">
                    <spring:message code="local.news.favourite.add"/>
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

        </div>

        <div class="news-read">
            <p><spring:message code="local.comment"/></p>
            <c:if test="${not empty commentsList}">
                <c:forEach var="comment" items="${commentsList}">
                    <div>
                        <p style="font-size: xx-small">
                            Author: ${comment.user.username}
                        </p>
                        <p>${comment.contentComment}</p>
                        <span>--------------</span>
                    </div>
                </c:forEach>
            </c:if>
        </div>

        <div class="news-comment">
            <p style="margin-bottom: 0; font-size: 20px"><spring:message code="local.comment.add"/></p>
            <form:form action="/news/comment" modelAttribute="comment" method="POST">

                <form:hidden path="news.id" value="${newsId}"/>

                <form:errors path="contentComment"/>
                <form:textarea path="contentComment" rows="10" cols="40" cssClass="news-input"/>

                <br>
                <spring:message code="button.submit" var="submit"/>
                <input class="submit-button" type="submit" value="${submit}">
            </form:form>
        </div>

        <a style="margin-top: 30px; text-align: center" href="<c:url value="/news/"/>">
            <img style="width: 29px;" src="../../resources/img/chevron%20with%20circle%20left.svg" alt="back"> BACK
        </a>

        <c:import url="footer.jsp"/>
    </body>
</html>
