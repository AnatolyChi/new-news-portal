<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update User</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="../../resources/css/news_style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>

    <body>
        <c:import url="header_single.jsp"/>

        <div>
            <form:form action="/news/user/update_own_page" modelAttribute="user" method="POST" cssStyle="margin-left: 45%">

                <form:hidden path="id"/>
                <form:hidden path="username"/>
                <form:hidden path="password"/>

                <form:errors path="firstname" cssClass="valid-mess" /><br>
                <form:input path="firstname" placeholder="Firstname"/><br>
                <form:errors path="lastname" cssClass="valid-mess"/><br>
                <form:input path="lastname" placeholder="Lastname"/><br>

                <form:errors path="email" cssClass="valid-mess"/><br>
                <form:input path="email" placeholder="Email"/><br>

                <form:errors path="age" cssClass="valid-mess"/><br>
                <form:input path="age" placeholder="Age"/><br>

                <input style="margin-left: 40px; margin-top: 15px" class="submit-button" type="submit" value="submit">

            </form:form>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
