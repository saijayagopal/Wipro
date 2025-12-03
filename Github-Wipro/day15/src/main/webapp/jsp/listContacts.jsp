<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Contact" %>
<%@ page import="java.util.List" %>

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

  <!-- FIXED CSS PATH -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>

<body>
  <div class="container">

    <h2><u>All Contacts</u></h2>

    <p>
      <a class="btn" href="${pageContext.request.contextPath}/jsp/addContact.jsp">Add New</a>
    </p>

    <!-- TABLE WITH CORRECT CLASS -->
    <table class="contacts">
      <thead>
        <tr>
          <th>Name</th>
          <th>Phone</th>
          <th>Email</th>
          <th>Address</th>
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
            </tr>
          <% } %>
        </c:when>

        <c:otherwise>
          <tr><td colspan="4">No contacts yet.</td></tr>
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