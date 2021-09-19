<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <img class="body-img" src="../../resources/img/News.svg.png" width="150px" alt="news_logo">
        <div class="top-nav-right">
            <a href="<c:url value="/user/log_in"/>">LOG IN</a>
            <a href="<c:url value="/user/sign_up"/>">SIGN UP</a>
            <div class="dropdown">
                <button class="drop-button">OPTION
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="#">Link-1</a>
                    <a href="#">Link-2</a>
                    <a href="#">Link-3</a>
                </div>
            </div>
        </div>
    </nav>

    </body>
</html>
