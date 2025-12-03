<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

    <h2>${message}</h2>

    <form action="/check-login" method="get">
        <label>Username:</label>
        <input type="text" name="name" required /><br><br>

        <label>Password:</label>
        <input type="password" name="password" required /><br><br>

        <button type="submit">Login</button>
    </form>

</body>
</html>
