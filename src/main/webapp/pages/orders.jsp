<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
<table>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td><c:out value="${order.id}"/></td>
            <td><c:out value="${order.carId}"/></td>
            <td><c:out value="${order.userId}"/></td>
            <td><c:out value="${order.startDate}"/></td>
            <td><c:out value="${order.endDate}"/></td>
            <td><c:out value="${order.status}"/></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="nav_template.jsp"/>
</body>
</html>
