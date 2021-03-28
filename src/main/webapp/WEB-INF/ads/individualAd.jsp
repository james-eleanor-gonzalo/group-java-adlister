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
<h1>Current Ad</h1>
<div class="container">

        <div class="card ">
            <div class="card-body"></div>
                <h4 class="card-title"><c:out value="${ad.title}"/></h4>

                <p class="card-text"><c:out value="${ad.description}"/></p>
                <h5>Price: $<c:out value="${ad.price}"/></h5>
                <h5>Category: ${ad.category}</h5>
        </div>
    <hr>
        <div>
            ${edit}
        </div>

</div>
</body>
</html>








