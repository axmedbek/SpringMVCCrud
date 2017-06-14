<%--
  Created by IntelliJ IDEA.
  User: axmedbek
  Date: 6/11/17
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
   <tr>
       <td>Kateqoriyalar</td>
   </tr>
    <tr>
        <td><a href="/">Home Page</a></td>

    </tr>
    <tr>
        <td><a href="/login">Login Page</a></td>

    </tr>
    <tr>
        <td><a href="/save">Success Page</a></td>

    </tr>
</table>
<c:forEach items="${personList}" var="person">
    <table>
        <tr>
            <td>ID:</td>
            <td>${person.id}</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>${person.name}</td>
        </tr>
        <tr><td><a href="/delete/${person.id}">Personu Sil</a></td></tr>
    </table>
</c:forEach>
</body>
</html>
