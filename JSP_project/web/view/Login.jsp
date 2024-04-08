<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<h2>Login</h2>
    <c:if test="${not empty param.error}">
        <p>Invalid username or password. Please try again.</p>
    </c:if>
    <form action='LoginServlet' method='get'> 
        ID: <input type='text' name='id'><br>
        Password: <input type='password' name='password'><br>
        <input type='submit' value='Login'>
    </form>
</body>
</html>