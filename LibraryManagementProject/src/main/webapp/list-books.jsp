<%@ page import="domain.entities.User" %>
<%@ page import="domain.enums.UserType" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.entities.Book" %>
<%@ page import="service.UserService" %>
<%@ page session="false" %><%--
  Created by IntelliJ IDEA.
  User: bernardo
  Date: 20/05/2023
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User currentUser = (User) request.getSession().getAttribute("user");
    List<Book> data = (List<Book>)request.getAttribute("data");
%>

<html lang="en">
<head>
    <title>Library</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="./resources/book.ico" type="image/x-icon">
</head>
<link rel="stylesheet" href="./resources/list-books.css">
<body>
<header>
    <h1>Library</h1>
    <%if (currentUser != null && currentUser.getType() == UserType.ADMINISTRATOR){%>
        <button style="background-color: #FFFDD0"><a href="${pageContext.request.contextPath}/registeruser">Register User</a></button>
        <button style="background-color: #FFFDD0"><a href="${pageContext.request.contextPath}/registerbook">Register Book</a></button>
        <button style="background-color: #FFFDD0"><a href="${pageContext.request.contextPath}/listusers">List Users</a></button>
    <%}%>
    <button style="background-color: #FFFDD0"><a href="${pageContext.request.contextPath}/logout">Logout</a></button>
</header>

<div class="background-img"></div>
<div class="container">
    <H2>Book List</H2>
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>Status</th>
            <th>Creation Date</th>
            <%if (currentUser.getType() == UserType.ADMINISTRATOR){%>
            <th>⌘</th>
            <%}%>
        </tr>
        <%if (data != null){
            for (Book b: data){

            %>
        <tr>
            <td><%=b.getId()%></td>
            <td><%=b.getName()%></td>
            <td><%=b.getAuthor()%></td>
            <td><%=b.getStatus().toString().toLowerCase()%></td>
            <td><%=b.getCreation_date().toString()%></td>
            <%if (currentUser.getType() == UserType.ADMINISTRATOR){%>
            <td><button><a href="${pageContext.request.contextPath}/deletebook?book_id=<%=b.getId()%>">Delete</a></button>
                <button><a href="${pageContext.request.contextPath}/updatebook?book_id=<%=b.getId()%>">Update</a></button>
            </td>
            <%}%>
        </tr>
        <%}
        }
        %>
        </tbody>
    </table>

</div>
</body>
</html>