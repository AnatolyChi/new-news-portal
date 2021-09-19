<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Main Page</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>
    <body>
        <c:import url="header_single.jsp"/>

        <div>
            <c:forEach var="news" items="${newsList}">
                <p>${news.title}</p><br>
                <p>${news.date}</p>
            </c:forEach>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
