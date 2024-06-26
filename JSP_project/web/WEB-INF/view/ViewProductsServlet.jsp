<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewProductsServlet page</title>
</head>
<body>

	<h2>상품조회</h2>
    <form action="ViewProductsServlet" method="get">
        상품명: <input type="text" name="productName">
        <input type="submit" value="Search">
    </form>
    <hr>
    <h3>조회 결과</h3>
    <c:if test="${not empty productList}">
    <ul>
        <c:forEach items="${productList}" var="product">
            <li>${product.proname} -  원가 : ${product.price }</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>