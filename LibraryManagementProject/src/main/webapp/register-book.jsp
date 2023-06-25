<%--
  Created by IntelliJ IDEA.
  User: bernardo
  Date: 20/05/2023
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Book Register</title>
    <link rel="stylesheet" href="./resources/register-book.css">
    <link rel="shortcut icon" href="./resources/book.ico" type="image/x-icon">
</head>
<body>
<header><h1>Library</h1>
    <button style="background-color: #FFFDD0"><a style="text-decoration: none; color: #000000;" href="${pageContext.request.contextPath}/login">List Books</a></button>
</header>
<div class="background-img"></div>
<div class="container">
    <!-- id book_name author_name creation_date book_status -->
    <h2>Book Register</h2>
    <form action="registerbook" method="post">
        <div class="form-group">
            <label for="book_name">Book Name</label>
            <input type="text" name="book_name" id="book_name">
        </div>
        <div class="form-group">
            <label for="author_name">Author Name</label>
            <input type="text" name="author_name" id="author_name">
        </div>
        <div class="form-group">
            <label>Book Status</label>
            <label class="status_label"for="book_available">Available</label>
            <input type="radio" name="book_status" id="book_available" value="available">
            <label class="status_label" for="book_unavailable">Unavailable</label>
            <input type="radio" name="book_status" id="book_unavailable" value="unavailable">
            <label class="status_label" for="book_rented">Rented</label>
            <input type="radio" name="book_status" id="book_rented" value="rented">
        </div>
        <input type="submit" value="Register" id="btn-submit">
    </form>
</div>
</body>
</html>
