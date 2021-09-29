<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>
    <body>

        <div>
            <h1 class="great-news-logo">GREAT NEWS</h1>
        </div>
        <div style="margin-bottom: 0; height: 50px">
            <h1 class="sign-and-log">LOG IN</h1>
        </div>
        <div>
            <form:form action="log_in" modelAttribute="user" method="POST" cssStyle="margin-left: 45%">
                <form:hidden path="id"/>
                <form:input placeholder="Login" path="login"/>
                <br>
                <form:password placeholder="Password" path="password"/>
                <br>
                <input type="submit" value="submit">
            </form:form>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
