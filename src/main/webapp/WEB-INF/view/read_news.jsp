<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h3>${news.title}</h3>
            <hr>
            <p>${news.content}</p>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>