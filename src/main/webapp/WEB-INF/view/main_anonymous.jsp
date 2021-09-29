<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Main Anonymous</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
    </head>
    <body>

        <div>
            <h1 class="great-news-logo">GREAT NEWS</h1>
        </div>
        <div style="margin-right: 44%">
            <a class="base-button" href="<c:url value="/news/user/log_in"/>">LOG IN</a>
            <a class="base-button" href="<c:url value="/news/user/sign_up"/>">SIGN UP</a>
        </div>

    </body>
</html>
