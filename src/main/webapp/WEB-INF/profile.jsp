<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <div class="container">
        <h2>Update Profile Information</h2>
        <form id="edit-form" action="/profile" method="post">
                <label for="email-update">Email</label>
                <input id="email-update" name="email-update" type="text">
                <label for="password-update">Password</label>
                <input id="password-update" name="password-update" type="password">
            <button id="edit-changes" type="submit" class="btn btn-primary">Edit</button>
        </form>
    </div>

</body>
</html>
