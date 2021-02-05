<%@ page import="com.codeup.adlister.models.User" %><%--
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

<%
    User user = null;

    if (session != null){
        user = (User) session.getAttribute("user");
    }

    if(user != null){
        request.setAttribute("edit", "<h3>Please edit your ad!</h3>\n" +
                "<div class=\"col-md-6\">\n" +
                "<form action=\"/ads/edit\" method=\"post\">\n" +
                "<h3><c:out value=\"${ad.title}\"/></h3>\n" +
                "<label for=\"titleInput\"><input type=\"text\" name=\"titleInput\" id=\"titleInput\" placeholder=\"update title\"></label>\n" +
                "<p><c:out value=\"${ad.description}\"/></p>\n" +
                "<label for=\"descriptionInput\"><input type=\"text\" name=\"descriptionInput\" id=\"descriptionInput\" placeholder=\"update description\"></label>\n" +
                "<button type=\"submit\" class=\"btn btn-primary\">Submit Changes</button>\n" +
                "<h3>Delete ad</h3><input type=\"submit\" class=\"form-check-input\" id=\"deleteAd\" name=\"deleteAd\" value=\"Delete\">\n" +
                "</form>\n" +
                "</div>");
    }
%>

<div class="container">
    <h1>Viewing Ad</h1>
<%--    <c:forEach var="ad" items="${ads/individual}">--%>
        <div class="col-md-4">
            <h1><c:out value="${ad.title}"/></h1>
            <h3><c:out value="${ad.description}"/></h3>
            <ul>
                ${edit}
            </ul>
        </div>
<%--    </c:forEach>--%>



</div>
</body>
</html>
