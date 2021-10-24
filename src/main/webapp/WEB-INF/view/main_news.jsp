<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
        <c:import url="header_single.jsp"/>

        <div style="margin-top: 20px; margin-left: 33px">
            <c:forEach var="news" items="${newsList}">
                <div class="newsMain">
                    <div style="float: left">
                        <p style="font-size: x-small; text-align: left">Author: ${news.user.username}</p>
                        <p style="font-size: x-small; text-align: left">${news.date}</p>
                    </div>
                    <div>
                        <p>${news.title}</p>
                    </div>
                    <a href="<c:url value="/news/read/${news.id}"/>"><spring:message code="local.news.read"/></a>
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="<c:url value="/news/update/${news.id}"/>"><spring:message code="local.news.update"/></a>
                        <a href="<c:url value="/news/delete/${news.id}"/>"><spring:message code="local.news.delete"/></a>
                    </security:authorize>
                </div>
            </c:forEach>
        </div>

        <div>
            <c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
                <c:url value="/news/" var="url_page">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href="${url_page}">${i.index}</a>
            </c:forEach>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
