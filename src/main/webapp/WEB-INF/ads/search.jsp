<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search Ads"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
    <div class="container">
        <h1 class="text-center">Ad Search</h1>
        <div class="text-center">
            <form action="/ads/search" method="get" class="center-text center-block">
                <label for="search">Key Word <input type="text" name="searchInput" id="search"></label><br>
                <label for="searchCat"> Category: <select id="searchCat" name="searchCat">
                    <option value="vehicles">Vehicles</option>
                    <option value="toys">Toys</option>
                    <option value="electronics">Electronics</option>
                    <option value="household good">Household Goods</option>
                    <option value="furniture">Furniture</option>
                    <option value="fad">Fad</option>
                    <option value="outdoor living">Sporting</option>
                </select></label><br>
                <button class="btn btn-info">Submit</button>
            </form>
        </div>
    </div>
    <div class="container">

    </div>
    <c:forEach var="ad" items="${search}">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${ad.title}</h5>
                <p class="card-text">${ad.description}</p>
                <a href="<c:url value="/individual">
                <c:param name="id" value="${ad.id}"/>
                </c:url>">View Full Ad</a>
            </div>
        </div>
    </c:forEach>

</body>
</html>



