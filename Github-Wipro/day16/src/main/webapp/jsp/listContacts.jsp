<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Contact" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
    if (contacts == null) contacts = (List<Contact>) application.getAttribute("contacts");
%>

<!doctype html>
<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width,initial-scale=1"/>
  <title>All Contacts</title>

  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>

<body>

<div class="container">

  <!-- Success Message -->
  <c:if test="${not empty sessionScope.msg}">
      <div style="background:#d7ffcf;padding:10px;margin-bottom:15px;border-radius:5px;">
          ${sessionScope.msg}
      </div>
      <c:remove var="msg" scope="session"/>
  </c:if>

  <h2><u>All Contacts</u></h2>

  <p>
    <a class="btn" href="${pageContext.request.contextPath}/jsp/addContact.jsp">Add New</a>
  </p>

  <table class="contacts">
    <thead>
      <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Actions</th>
      </tr>
    </thead>

    <tbody>
    <c:choose>
      <c:when test="${not empty contacts}">
        <% for (Contact c : contacts) { %>
          <tr>
            <td><%= c.getName() %></td>
            <td><%= c.getPhone() %></td>
            <td><%= c.getEmail() %></td>
            <td><%= c.getAddress() %></td>
            <td>
              <a class="btn" href="${pageContext.request.contextPath}/edit?id=<%= c.getId() %>">Edit</a>
              <a class="btn secondary"
                 href="${pageContext.request.contextPath}/delete?id=<%= c.getId() %>"
                 onclick="return confirm('Delete this contact permanently?');">
                 Delete
              </a>
            </td>
          </tr>
        <% } %>
      </c:when>

      <c:otherwise>
        <tr><td colspan="5">No contacts yet.</td></tr>
      </c:otherwise>
    </c:choose>
    </tbody>
  </table>

  <p>
    <a class="btn secondary" href="${pageContext.request.contextPath}/">Back</a>
  </p>

</div>

</body>
</html>
