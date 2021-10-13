<%--
  Created by IntelliJ IDEA.
  User: ray
  Date: 10/8/21
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Customers</title>
</head>
<body>
    <h2> Customer Relationship Manager</h2>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${customers}" var="tempCustomer">
            <tr>
                <td>${tempCustomer.firstName}</td>
                <td>${tempCustomer.lastName}</td>
                <td>${tempCustomer.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
