<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Failed</title>
</head>
<body>
	<h2>로그인 실패</h2>
    <p>아이디 또는 비밀번호가 올바르지 않습니다. 다시 시도해주세요.</p>
    <form action="$/WEB-INF/view/index.html" method="get">
        <button type="submit">홈으로 돌아가기</button>
    </form>

</body>
</html>