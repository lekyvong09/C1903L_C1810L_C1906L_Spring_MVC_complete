<%--
  Created by IntelliJ IDEA.
  User: ray
  Date: 10/25/21
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #e3f2fd;">
  <a class="navbar-brand" href="#">CRM</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/customer/list">List Customer</a>
      </li>

      <security:authorize access="hasRole('ADMIN')">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/admin">Link</a>
        </li>
      </security:authorize>
    </ul>

    <form:form method="post" action="${pageContext.request.contextPath}/logout" class="form-inline my-2 my-lg-0">
      <input class="btn btn-outline-success" type="submit" value="Logout">
    </form:form>
  </div>
</nav>
