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

        <security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
            <c:forEach var="news" items="${newsList}">
                <div class="newsMain">
                    <div style="float: left">
                        <p style="font-size: x-small; text-align: left">Author: ${news.user.username}</p>
                        <p style="font-size: x-small; text-align: left">${news.date}</p>
                    </div>
                    <div>
                        <p>${news.title}</p>
                    </div>
                    <a href="<c:url value="/news/read/${news.id}"/>">READ</a>
                    <a href="<c:url value="/news/update/${news.id}"/>">UPDATE</a>
                    <a href="<c:url value="/news/delete/${news.id}"/>">DELETE</a>
                </div>
            </c:forEach>
        </security:authorize>

<%--        <c:choose>--%>
<%--            <c:when test="${sessionScope.user != null}">--%>
<%--                <jsp:include page="header_single.jsp"/>--%>
<%--                <c:if test="${newsList != null and newsList.size() > 0}">--%>
<%--                    <div style="margin-top: 20px; margin-left: 33px">--%>

<%--                        <!-- Поиск по тегу -->--%>
<%--&lt;%&ndash;                        <div style="margin-left: 20px">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <form action="/controller" method="GET">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <p>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <input type="search" name="tegNews" placeholder="${search}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <input type="hidden" name="command" value="MAIN_PAGE">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <input type="submit" value="${submit}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </p>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>

<%--                        <c:forEach var="news" items="${newsList}">--%>
<%--                            <div class="newsMain">--%>
<%--                                <div style="float: left">--%>
<%--                                    <p style="font-size: x-small; text-align: left">Author: ${news.user.login}</p>--%>
<%--                                    <p style="font-size: x-small; text-align: left">${news.date}</p>--%>
<%--                                </div>--%>
<%--                                <div>--%>
<%--                                    <p>${news.title}</p>--%>
<%--                                </div>--%>
<%--                                <a href="<c:url value="/news/read/${news.id}"/>">READ</a>--%>
<%--                                <c:if test="${sessionScope.user.role.roleName.equals('ADMIN')}">--%>
<%--                                    <a href="<c:url value="/news/update/${news.id}"/>">UPDATE</a>--%>
<%--                                    <a href="<c:url value="/news/delete/${news.id}"/>">DELETE</a>--%>
<%--                                </c:if>--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>

<%--                    <!-- Pagination -->--%>
<%--                    <div>--%>
<%--                        <c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">--%>
<%--                            <c:url value="/news/main" var="url_page">--%>
<%--                                <c:param name="page" value="${i.index}"/>--%>
<%--                            </c:url>--%>
<%--                            <a href="${url_page}">${i.index}</a>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>

<%--                    <!-- Выборка, сколько новостей показывать на странице -->--%>
<%--&lt;%&ndash;                    <div style="margin: auto">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <form:form modelAttribute="newsList" action="/news/main" method="get">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <form:select label="Select:" path="">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <form:option value="4">4</form:option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <form:option value="8">8</form:option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <form:option value="12">12</form:option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <form:option value="16">12</form:option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </form:select>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <input type="submit" value="<spring:message code="button.submit"/>">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </form:form>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                </c:if>--%>
<%--            </c:when>--%>
<%--            <c:when test="${sessionScope.user == null}">--%>
<%--                <div>--%>
<%--                    <h1 class="great-news-logo">GREAT NEWS</h1>--%>
<%--                </div>--%>
<%--                <div style="margin-right: 44%">--%>
<%--                    <a class="base-button" href="<c:url value="/news/user/log_in"/>">LOG IN</a>--%>
<%--                    <a class="base-button" href="<c:url value="/news/user/sign_up"/>">SIGN UP</a>--%>
<%--                </div>--%>
<%--            </c:when>--%>
<%--        </c:choose>--%>

        <c:import url="footer.jsp"/>
    </body>
</html>
