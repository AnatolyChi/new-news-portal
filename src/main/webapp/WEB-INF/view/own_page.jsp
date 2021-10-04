<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Own Page</title>
      <link rel="stylesheet" href="../../resources/css/style.css">
      <link rel="stylesheet" href="../../resources/css/news_style.css">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
  </head>

  <body>

    <p>Login:       ${sessionScope.user.login}</p>
    <p>Firstname:   ${sessionScope.user.firstname}</p>
    <p>Lastname:    ${sessionScope.user.lastname}</p>
    <p>Age:         ${sessionScope.user.age}</p>
    <p>Email:       ${sessionScope.user.email}</p>

    <p>Date:        ${sessionScope.user.dateRegistered}</p>

  </body>
</html>
