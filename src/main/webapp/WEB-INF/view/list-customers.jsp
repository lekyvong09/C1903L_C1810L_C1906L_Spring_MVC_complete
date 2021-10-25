<%@ page import="com.ray.springmvc.constant.SortCustomerColumn" %><%--
  Created by IntelliJ IDEA.
  User: ray
  Date: 10/8/21
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>List Customers</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>
<body>
<c:import url="navbar.jsp"/>

    <security:authorize access="hasRole('EMPLOYEE')">
        <div class="d-flex justify-content-center pt-3">
            <h2> Welcome to CRM system - <security:authentication property="principal.username" /> </h2>
        </div>
        <div class="d-flex justify-content-center pb-3">
            <h5> You have roles: <security:authentication property="principal.authorities" /> </h5>
        </div>
    </security:authorize>

    <div class="container">
        <div class="d-flex justify-content-between align-items-center">
            <input class="btn btn-primary form-group row" type="button" value="Add Customer"
                onclick="window.location.href='showFormForAdd'; return false;">

            <form:form action="search" method="get">
                <div class="form-group row">
                    <div class="col-6">
                        <input name="theSearchName" class="form-control mr-2" id="search" type="search"
                               placeholder="Search" aria-lable="Search">
                    </div>
                    <div class="col-6">
                        <input class="btn btn-success" type="submit" value="Search">
                    </div>
                </div>
            </form:form>
        </div>
        <div class="row">
            <table class="table">
                <thead class="thead-dark">

                    <%-- links for sorting --%>
                    <c:url value="/customer/list" var="sortLinkFirstName">
                        <c:param name="sort" value="<%=String.valueOf(SortCustomerColumn.FIRST_NAME) %>" />
                    </c:url>
                    <c:url value="/customer/list" var="sortLinkLastName">
                        <c:param name="sort" value="<%=String.valueOf(SortCustomerColumn.LAST_NAME) %>" />
                    </c:url>
                    <c:url value="/customer/list" var="sortLinkEmail">
                        <c:param name="sort" value="<%=String.valueOf(SortCustomerColumn.EMAIL) %>" />
                    </c:url>

                    <th scope="col"><a href="${sortLinkFirstName}">First Name</a></th>
                    <th scope="col"><a href="${sortLinkLastName}">Last Name</a></th>
                    <th scope="col"><a href="${sortLinkEmail}">Email</a></th>
                    <th scope="col">Action</th>
                </thead>
                <c:forEach items="${customers}" var="tempCustomer">
                    <%-- Example link http://...//customer/showFormForUpdate?customerId=1 --%>
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>
                    <tbody>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                             |
                            <a href="${deleteLink}"
                               onclick="if (!confirm('Are you sure you want to delete this?')) return false;">Delete</a>
                        </td>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
