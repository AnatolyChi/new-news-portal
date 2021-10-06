<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

        <c:choose>
            <c:when test="${sessionScope.user != null}">
                <jsp:include page="header_single.jsp"/>
                <c:if test="${newsList != null and newsList.size() > 0}">
                    <div style="margin-top: 20px; margin-left: 33px">

                        <!-- Поиск по тегу -->
<%--                        <div style="margin-left: 20px">--%>
<%--                            <form action="/controller" method="GET">--%>
<%--                                <p>--%>
<%--                                    <input type="search" name="tegNews" placeholder="${search}">--%>
<%--                                    <input type="hidden" name="command" value="MAIN_PAGE">--%>
<%--                                    <input type="submit" value="${submit}">--%>
<%--                                </p>--%>
<%--                            </form>--%>
<%--                        </div>--%>

                        <c:forEach var="news" items="${newsList}">
                            <div class="newsMain">
                                <div style="float: left">
                                    <p style="font-size: x-small; text-align: left">Author: ${news.user.login}</p>
                                    <p style="font-size: x-small; text-align: left">${news.date}</p>
                                </div>
                                <div>
                                    <p>${news.title}</p>
                                </div>
                                <a href="<c:url value="/news/read/${news.id}"/>">READ</a>
                                <c:if test="${sessionScope.user.role.roleName.equals('Admin')}">
                                    <a href="<c:url value="/news/update/${news.id}"/>">UPDATE</a>
                                    <a href="<c:url value="/news/delete/${news.id}"/>">DELETE</a>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>

                    <!-- Навигация по новостям -->
<%--                    <nav>--%>
<%--                        <ul>--%>
<%--                            <c:if test="${currentPage != 1}">--%>
<%--                                <li><a href="controller?command=MAIN_PAGE&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">--%>
<%--                                        ${previous}--%>
<%--                                </a></li>--%>
<%--                            </c:if>--%>
<%--    --%>
<%--                            <c:forEach begin="1" end="${nOfPages}" var="i">--%>
<%--                                <c:choose>--%>
<%--                                    <c:when test="${currentPage eq i}">--%>
<%--                                        <li><a>${i}<span>(${current})</span></a></li>--%>
<%--                                    </c:when>--%>
<%--                                    <c:otherwise>--%>
<%--                                        <li><a href="controller?command=MAIN_PAGE&recordsPerPage=${recordsPerPage}&currentPage=${i}">--%>
<%--                                                ${i}--%>
<%--                                        </a></li>--%>
<%--                                    </c:otherwise>--%>
<%--                                </c:choose>--%>
<%--                            </c:forEach>--%>
<%--    --%>
<%--                            <c:if test="${currentPage lt nOfPages}">--%>
<%--                                <li><a href="controller?command=MAIN_PAGE&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">--%>
<%--                                        ${next}--%>
<%--                                </a></li>--%>
<%--                            </c:if>--%>
<%--                        </ul>--%>
<%--                    </nav>--%>

                    <!-- Выборка, сколько новостей показывать на странице -->
<%--                    <div style="text-align: center; margin-top: 50px">--%>
<%--                        <form action="controller?command=MAIN_PAGE" method="POST">--%>
<%--                            <label for="records">${records}:</label>--%>
<%--                            <select id="records" name="recordsPerPage">--%>
<%--                                <option value="4">4</option>--%>
<%--                                <option value="8">8</option>--%>
<%--                                <option value="12">12</option>--%>
<%--                            </select>--%>
<%--                            <input type="hidden" name="currentPage" value="1">--%>
<%--                            <input type="submit" value="${submit}">--%>
<%--                        </form>--%>
<%--                    </div>--%>
                </c:if>
            </c:when>
            <c:when test="${sessionScope.user == null}">
                <div>
                    <h1 class="great-news-logo">GREAT NEWS</h1>
                </div>
                <div style="margin-right: 44%">
                    <a class="base-button" href="<c:url value="/news/user/log_in"/>">LOG IN</a>
                    <a class="base-button" href="<c:url value="/news/user/sign_up"/>">SIGN UP</a>
                </div>
            </c:when>
        </c:choose>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
