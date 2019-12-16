<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <c:if test="${page != 1}">
            <li>
                <a href="${pageContext.request.contextPath}/controller?command=${currentPage}&capacity=${capacity}&page=${page-1}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${count}" var="i">
            <c:choose>
                <c:when test="${page eq i}">
                    <li>
                        <a>${i}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=${currentPage}&capacity=${capacity}&page=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${page lt count}">
            <li>
                <a href="${pageContext.request.contextPath}/controller?command=${currentPage}&capacity=${capacity}&page=${page+1}">Next</a>
            </li>
        </c:if>
        <li>
            <a href="${pageContext.request.contextPath}/controller?command=index&capacity=1&page=1">Main</a>
        </li>
    </ul>
</nav>
