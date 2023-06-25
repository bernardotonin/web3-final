<%@ page import="service.UserService" %>
<%@ page import="domain.entities.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%Object errorMsg = request.getAttribute("ErrorMsg");
    if (UserService.checkSession(request) != null){
        request.getRequestDispatcher("/login").forward(request, response);
    }
%>



<html lang="en">
<head>
    <title>Library Login</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="./resources/book.ico" type="image/x-icon">
</head>
<link rel="stylesheet" href="./resources/index.css">
<body>
<header>
    <h1>Library</h1>
</header>

<div class="background-img"></div>
<div class="container">
    <form action="login" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>

        <input type="submit" value="Login">
    </form>
    <%if(errorMsg != null){%>
        <div class="form-group" style="background-color: red; color: #f1f1f1">Invalid username or password.</div>
    <%}%>
</div>
</body>
</html>

