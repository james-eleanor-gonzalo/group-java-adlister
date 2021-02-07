<%@page import="com.codeup.adlister.models.User" %>
<%--Need to move this logic to servlet--%>
<%
    User user = null;

    if (session != null){
        user = (User) session.getAttribute("user");
    }

    if(user != null){
        request.setAttribute("navbar", "<li><a href=\"/ads/search\">Search</a></li>" +
                "<li><a href=\"/logout\">Logout</a></li>" +
                "<li><a href=\"/ads/create\">Create</a></li>" +
                "<li><a href=\"/profile\">Profile</a></li>");
    }  else {
        request.setAttribute("navbar", "<li><a href=\"/ads/search\">Search</a></li>" +
                "<li><a href=\"/register\">Register</a></li>" +
                "<li><a href=\"/login\">Login</a></li>");
    }


%>





<nav class="navbar bg-info" >
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">View Ads</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            ${navbar}
        </ul>
    </div>
</nav>
