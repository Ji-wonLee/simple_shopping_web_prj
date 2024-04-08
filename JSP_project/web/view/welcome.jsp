<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome page</title>
</head>
<body>
	<h1>Welcome, ${sessionScope.userInfo.name}!</h1>
	<p>성공적으로 로그인되었습니다.</p>
	<a href="/logout">Logout</a><br />
    <a href="/LoginNSearch">상품검색</a>
</body>
</html>