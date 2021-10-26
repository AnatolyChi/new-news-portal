<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>News Form</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
        <link rel="stylesheet" href="../../resources/css/news_style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    </head>

    <body>
        <c:import url="header_single.jsp"/>

        <c:if test="${command} == 'add'">
            <c:url var="action" value="/news/add"/>
        </c:if>
        <c:if test="${command} == 'update'">
            <c:url var="action" value="/news/update/${news.id}"/>
        </c:if>

        <div>
            <c:if test="${not empty already_exist}">
                <h3 style="text-align: center; color: #e75339"><spring:message code="local.news.add.err"/></h3>
            </c:if>
            <form:form action="${action}" modelAttribute="news" method="POST" cssStyle="margin-left: 30%">
                <form:hidden path="id"/>

                <form:errors path="title" cssClass="valid-mess"/><br>
                <form:textarea path="title" placeholder="Title" rows="10" cols="20" cssClass="news-input" cssStyle="height: 20px"/><br>

                <form:errors path="content" cssClass="valid-mess"/><br>
                <form:textarea  path="content" placeholder="Content" rows="10" cols="20" cssClass="news-input" cssStyle="height: 120px"/><br>
                <a style="float: left; margin-top: 30px" href="<c:url value="/news/"/>">
                    <img style="width: 29px;" src="../../resources/img/chevron%20with%20circle%20left.svg" alt="back">
                </a>
                <input style="margin-top: 30px; margin-left: 230px; float: left" class="submit-button" type="submit" value="submit">
            </form:form>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
