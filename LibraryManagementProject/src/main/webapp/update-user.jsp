<%@ page import="domain.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: bernardo
  Date: 25/06/2023
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<% User u = (User) request.getAttribute("user");%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Library User Update</title>
  <link rel="stylesheet" href="./resources/register-user.css">
  <link rel="shortcut icon" href="./resources/book.ico" type="image/x-icon">
</head>
<body>
<header><h1>Library</h1></header>
<div class="background-img"></div>
<div class="container">
  <h2>User Update</h2>
  <form action="updateuser" method="post">
    <div class="form-group">
      <label for="username">Username</label>
      <input type="text" name="username" id="username" value="<%=u.getUsername()%>">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="text" name="password" id="password" value="<%=u.getPassword()%>">
    </div>
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" name="name" id="name" value="<%=u.getName()%>">
    </div>
    <div class="form-group">
      <label for="admincheckbox">Admin</label>
      <input type="checkbox" name="admincheckbox" id="admincheckbox" value="admin">
    </div>
    <input type="hidden" name="user_id" value="<%=u.getId()%>">
    <input type="submit" value="Register" id="btn-submit">
  </form>
</div>
</body>
</html>
