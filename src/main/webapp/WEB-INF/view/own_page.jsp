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

    <h1>${sessionScope.user.login}</h1>
    <h1>${sessionScope.user.password}</h1>

  </body>
</html>
