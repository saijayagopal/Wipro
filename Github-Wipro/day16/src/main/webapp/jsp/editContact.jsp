<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Contact" %>

<%
    Contact contact = (Contact) request.getAttribute("contact");

    if(contact == null){
        response.sendRedirect(request.getContextPath() + "/list");
        return;
    }
%>

<!doctype html>
<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width,initial-scale=1"/>
  <title>Edit Contact</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>

<body>
  <div class="container">
    <h2>Edit Contact</h2>

    <form action="${pageContext.request.contextPath}/update" method="post" class="form">

      <!-- Hidden ID field -->
      <input type="hidden" name="id" value="<%= contact.getId() %>"/>

      <label>Name
        <input type="text" name="name" required maxlength="100"
               value="<%= contact.getName() %>"/>
      </label>

      <label>Phone
        <input type="tel" name="phone" required maxlength="20"
               value="<%= contact.getPhone() %>"
               pattern="[0-9+\\- ]+"/>
      </label>

      <label>Email
        <input type="email" name="email" required maxlength="100"
               value="<%= contact.getEmail() %>"/>
      </label>

      <label>Address
        <textarea name="address" rows="3"><%= contact.getAddress() %></textarea>
      </label>

      <div class="form-actions">
        <button type="submit" class="btn">Update</button>
        <a href="${pageContext.request.contextPath}/list" class="btn secondary">Cancel</a>
      </div>
    </form>
  </div>
</body>
</html>
