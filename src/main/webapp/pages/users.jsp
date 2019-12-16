<%--
  Created by IntelliJ IDEA.
  User: Nikita Bitkin
  Date: 12/16/2019
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td> ${user.name}</td>
            <td> ${user.surname}</td>
        </tr>
    </c:forEach>
</table>
<nav>
    <ul>
        <c:if test="${page != 1}">
            <li>
                <a href="${pageContext.request.contextPath}/controller?command=users&capacity=${capacity}&page=${page-1}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${count}" var="i">
            <c:choose>
                <c:when test="${page eq i}">
                    <li><a>${i} <span>(current)</span></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/controller?command=users&capacity=${capacity}&page=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${page lt count}">
            <li><a href="${pageContext.request.contextPath}/controller?command=users&capacity=${capacity}&page=${page+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>
</body>
</html>
