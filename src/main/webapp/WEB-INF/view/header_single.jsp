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
        <h1 style="color: white; margin: 5px 15px 15px;float: left">GREAT NEWS</h1>
        <div class="top-nav-right">
            <a href="<c:url value="/news/user/own_page"/>">OWN PAGE</a>
            <a href="<c:url value="#"/>">FAVOURITE NEWS</a>
            <a href="<c:url value="#"/>">OFFER NEWS</a>
            <a href="<c:url value="/news/user/log_out"/>">LOG OUT</a>
<%--            <div class="dropdown">--%>
<%--                <button class="drop-button">OTHER--%>
<%--                    <i class="fa fa-caret-down"></i>--%>
<%--                </button>--%>
<%--                <div class="dropdown-content">--%>
<%--                    <a href="#">CONTACTS</a>--%>
<%--                    <a href="#">ABOUT US</a>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
    </nav>

    </body>
</html>
