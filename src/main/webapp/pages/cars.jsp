<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cars</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
<table>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td><c:out value="${car.id}"/></td>
            <td><c:out value="${car.model}"/></td>
            <td><c:out value="${car.make}"/></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="nav_template.jsp"/>
</body>
</html>
