<%@page import="com.codeup.adlister.models.User" %>
<%--Need to move this logic to servlet--%>
<%
    User user = null;

    if (session != null){
        user = (User) session.getAttribute("user");
    }

    if(user != null){
        request.setAttribute("navbar", "<li><a href=\"/ads/search\">Search</a></li>\n" +
                "<li><a href=\"/logout\">Logout</a></li>\n" +
                "<li><a href=\"/ads/create\">Create</a></li>\n" +
                "<li><a href=\"/profile\">Profile</a></li>");
    }  else {
        request.setAttribute("navbar", "<li><a href=\"/ads/search\">Search</a></li>\n" +
                "<li><a href=\"/register\">Register</a></li>\n" +
                "<li><a href=\"/login\">Login</a></li>");
    }


%>





<nav class="navbar " style="background-color: #db6400">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">View Ads</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            ${navbar}
        </ul>
    </div>

</nav>
