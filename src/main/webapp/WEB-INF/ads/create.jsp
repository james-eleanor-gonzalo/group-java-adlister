<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" value="${stickyTitle}">
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

            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
