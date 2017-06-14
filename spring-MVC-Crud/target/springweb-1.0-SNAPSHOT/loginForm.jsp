<%--
  Created by IntelliJ IDEA.
  User: axmedbek
  Date: 6/11/17
  Time: 1:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="save" method="post" modelAttribute="person">
    <table>



        <tr>
            <td>ID:</td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr><input type="submit" value="Save"/></tr>
    </table>


</form:form>
</body>
</html>
