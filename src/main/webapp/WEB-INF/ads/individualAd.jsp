<%@ page import="com.codeup.adlister.models.User" %>
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
<jsp:include page="/WEB-INF/partials/editAd.jsp" />

<div class="container">
    <h1>Viewing Ad</h1>
        <div class="card bg-light mb-3 ">
            <div class="card-body"></div>
                <h5 class="card-title"><c:out value="${ad.title}"/></h5>

                <p class="card-text"><c:out value="${ad.description}"/></p>
                <h4>Price: $<c:out value="${ad.price}"/></h4
                <h4>Category: ${ad.category}</h4>
        </div>
    <hr>
        <div>
            ${edit}
        </div>

</div>
</body>
</html>








