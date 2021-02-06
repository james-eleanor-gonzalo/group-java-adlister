<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="error">
                <c:if test="${errorTitle != null}">
                    <span class="errors">${errorTitle}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text" value="${stickyTitle}"></textarea>
            </div>
            <div class="error">
                <c:if test="${errorDescription != null}">
                    <span class="errors">${errorDescription}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <textarea id="price" name="price" class="form-control" type="text" value="${stickyTitle}"></textarea>
            </div>
            <div class="error">
                <c:if test="${errorDescription != null}">
                    <span class="errors">${errorDescription}</span>
                </c:if>
            </div>

            <fieldset>
                <legend>Category</legend>
                <select id="newAdCat" name="category">
                    <option value="1">Vehicles</option>
                    <option value="2">Toys</option>
                    <option value="3">Electronics</option>
                    <option value="4">Household Goods</option>
                    <option value="5">Furniture</option>
                    <option value="6">Fad</option>
                    <option value="7">Outdoor Living</option>
                    <option value="8">Tools</option>
                </select>
            </fieldset>
            <div class="error">
                <c:if test="${errorCategory != null}">
                    <span class="errors">${errorCategory}</span>
                </c:if>
            </div>


            <input type="submit" class="btn btn-block btn-primary">

        </form>
    </div>
</body>
</html>
