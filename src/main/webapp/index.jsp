<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body class="page">
    <a href="${pageContext.request.contextPath}/controller?command=users&capacity=2&page=1">
        users
    </a>
    <br>
    <a href="${pageContext.request.contextPath}/controller?command=cars&capacity=2&page=1">
        cars
    </a>
    <br>
    <a href="${pageContext.request.contextPath}/controller?command=orders&capacity=2&page=1">
        orders
    </a>
</body>
</html>
