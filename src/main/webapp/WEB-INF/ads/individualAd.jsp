<%--
  Created by IntelliJ IDEA.
  User: Eleanor
  Date: 2/3/21
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="This Ad Page" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Viewing Ad</h1>
<%--    <c:forEach var="ad" items="${ads/individual}">--%>
        <div class="col-md-4">
            <h1><c:out value="${ad.title}"/></h1>
            <h3><c:out value="${ad.description}"/></h3>

        </div>
<%--    </c:forEach>--%>

</div>
</body>
</html>
