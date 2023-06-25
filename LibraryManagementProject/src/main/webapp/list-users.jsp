<%@ page import="java.util.List" %>
<%@ page import="domain.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: bernardo
  Date: 23/06/2023
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%List<User> data = (List<User>) request.getAttribute("data");%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Library User List</title>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="book.ico" type="image/x-icon">
</head>
<link rel="stylesheet" href="./resources/list-users.css">
<body>
<header>
  <h1>Library</h1>
    <button style="background-color: #FFFDD0"><a style="text-decoration: none; color: #000000;" href="${pageContext.request.contextPath}/login">List Books</a></button>
</header>

<div class="background-img"></div>
<div class="container">
  <H2>User List</H2>
  <table>
    <tbody>
    <tr>
      <th>ID</th>
      <th>Username</th>
      <th>Password</th>
      <th>Name</th>
      <TH>Type</TH>
      <TH>⌘</TH>
    </tr>
    <%for (User u: data){%>
    <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getUsername()%></td>
        <td><%=u.getPassword()%></td>
        <td><%=u.getName()%></td>
        <td><%=u.getType().toString().toLowerCase()%></td>
        <td><button><a style="text-decoration: none;color: #000000;" href="${pageContext.request.contextPath}/deleteuser?user_id=<%=u.getId()%>">Delete</a></button>
            <button><a style="text-decoration: none; color: #000000;" href="${pageContext.request.contextPath}/updateuser?user_id=<%=u.getId()%>">Update</a></button>
        </td>
      <%}%>
    </tr>
    </tbody>
  </table>

</div>
</body>
</html>

