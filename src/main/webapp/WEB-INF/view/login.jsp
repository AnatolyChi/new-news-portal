<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <form:form action="/perform_login" method="POST" cssStyle="margin-left: 45%">

                <c:if test="${not empty param.error}">
                    <span style="color: red; font-size: 17px;">
                        <spring:message code="local.valid.authorization" />
                    </span>
                </c:if>

                <c:if test="${not empty param.registrationOK}">
                    <span style="color: #408080; font-size: 17px;">
                        <spring:message code="user.complete.reg" />
                    </span>
                </c:if>

                <br>
                <input type="text" name="username" placeholder="Username" class="user-input">
                <br>
                <input type="password" name="password" placeholder="Password" class="user-input" style="margin-top: 20px">
                <br>
                <input style="margin-left: 40px; margin-top: 15px" class="submit-button" type="submit" value="submit">
            </form:form>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
