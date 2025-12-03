<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width,initial-scale=1"/>
  <title>Add Contact</title>
  <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
  <div class="container">
    <h2>Add Contact</h2>
    <form action="${pageContext.request.contextPath}/add" method="post" class="form">
      <label>Name
        <input type="text" name="name" required maxlength="100"/>
      </label>

      <label>Phone
        <input type="tel" name="phone" required maxlength="20" pattern="[0-9+\\- ]+"/>
      </label>

      <label>Email
        <input type="email" name="email" required maxlength="100"/>
      </label>

      <label>Address
        <textarea name="address" rows="3"></textarea>
      </label>

      <div class="form-actions">
        <button type="submit" class="btn">Save Contact</button>
        <a href="${pageContext.request.contextPath}/" class="btn secondary">Home</a>
      </div>
    </form>
  </div>
</body>
</html>
