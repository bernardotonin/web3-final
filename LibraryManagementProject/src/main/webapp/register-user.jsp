<%--
  Created by IntelliJ IDEA.
  User: bernardo
  Date: 20/05/2023
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Library User Register</title>
  <link rel="stylesheet" href="./resources/register-user.css">
  <link rel="shortcut icon" href="./resources/book.ico" type="image/x-icon">
</head>
<body>
<header><h1>Library</h1>
  <button style="background-color: #FFFDD0"><a style="text-decoration: none; color: #000000;" href="${pageContext.request.contextPath}/login">List Books</a></button>
</header>
<div class="background-img"></div>
<div class="container">
  <h2>User Register</h2>
  <form action="registeruser" method="post">
    <div class="form-group">
      <label for="username">Username</label>
      <input type="text" name="username" id="username">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" name="password" id="password">
    </div>
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" name="name" id="name">
    </div>
    <div class="form-group">
      <label for="admincheckbox">Admin</label>
      <input type="checkbox" name="admincheckbox" id="admincheckbox" value="admin">
    </div>
    <input type="submit" value="Register" id="btn-submit">
  </form>
</div>
</body>
</html>
