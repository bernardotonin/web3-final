<%@ page import="domain.entities.Book" %><%--
  Created by IntelliJ IDEA.
  User: bernardo
  Date: 23/06/2023
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<%Book b = (Book) request.getAttribute("book");
%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Library Book Update</title>
  <link rel="stylesheet" href="./resources/register-book.css">
  <link rel="shortcut icon" href="./resources/book.ico" type="image/x-icon">
</head>
<body>
<header><h1>Library</h1></header>
<div class="background-img"></div>
<div class="container">
  <!-- id book_name author_name creation_date book_status -->
  <h2>Book Register</h2>
  <form action="updatebook" method="post">
    <div class="form-group">
      <label for="book_name">Book Name</label>
      <input type="text" name="book_name" id="book_name" value="<%=b.getName()%>">
    </div>
    <div class="form-group">
      <label for="author_name">Author Name</label>
      <input type="text" name="author_name" id="author_name" value="<%=b.getAuthor()%>">
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
    <input type="submit" value="Update" id="btn-submit">
    <input type="hidden" name="creationdate" value="<%=b.getCreation_date()%>">
    <input type="hidden" name="id_book" value="<%=b.getId()%>">
  </form>
</div>
</body>
</html>
