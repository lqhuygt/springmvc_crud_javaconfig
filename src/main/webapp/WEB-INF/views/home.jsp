<%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 3/27/2020
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<div align="center">
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<h3><a href="/showForm">New Student</a></h3>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${listStudent}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.course}</td>
            <td>
<%--                <a href="/update?studentId=${student.id}">Update</a>--%>
                    <a href="/update/${student.id}">Update</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
<%--                <a href="/delete?studentId=${student.id}">Delete</a>--%>
                    <a href="/delete/${student.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
