<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<h1>Current Ads</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="card-columns">
            <div class="card bg-info">
                <div class="card-body text-center">
                    <h4 class="card-title">${ad.title}</h4>
                    <p class="card-text">${ad.description}</p>
                    <a href="<c:url value="/individual">
                    <c:param name="id" value="${ad.id}"/>
                    </c:url>">View Ad</a>
                </div>
            </div>
        </div>
    </c:forEach>

</body>
</html>





