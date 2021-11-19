<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Control Panel</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="../../resources/css/news_style.css">
        <link rel="stylesheet" href="../../resources/css/control_panel.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
    </head>

    <body>
        <c:import url="header_single.jsp"/>

        <div style="margin: auto" class="control-panel">
            <table style="text-align: center">
                <tr>
                    <th>ID</th>
                    <th>USERNAME</th>
                    <th>CURRENT ROLE</th>
                    <th>UPDATE ROLE</th>
                    <th>DATE</th>
                </tr>
                <c:forEach var="user" items="${usersList}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>
                            <c:forEach var="currentRole" items="${user.userRole}">
                                <p>${currentRole}</p>
                            </c:forEach>
                        </td>
                        <td>
                            <form:form action="/news/control_panel/change_role" modelAttribute="userModel" method="POST">
                                <form:hidden path="id" value="${user.id}"/>

                                <form:select path="userRole">
                                    <form:options items="${rolesList}"/>
                                </form:select>

                                <input style="margin-left: 40px; margin-top: 15px" class="submit-button" type="submit" value="submit">
                            </form:form>
                        </td>
                        <td>${user.dateRegistered}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
