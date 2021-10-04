<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update News</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="../../resources/css/news_style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>
    <body>

        <c:import url="header_single.jsp"/>

        <div>
            <form:form action="/news/update/${news.id}" modelAttribute="news" method="POST" cssStyle="margin-left: 45%">
                <form:hidden path="id"/>

                <form:errors path="title"/><br>
                <form:textarea path="title" placeholder="Title" rows="10" cols="20"/><br>

                <form:errors path="content"/><br>
                <form:textarea  path="content" placeholder="Content" rows="10" cols="20"/><br>
                <input class="submit-button" type="submit" value="submit">
            </form:form>
        </div>

    </body>
</html>
