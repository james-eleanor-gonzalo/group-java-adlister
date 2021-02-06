package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Auth auth = new Auth(request);
        Users usersDao = DaoFactory.getUsersDao();
        Ads adsDao = DaoFactory.getAdsDao();
        long id = auth.getLoggedUser().getId();
        User user = (User) request.getSession().getAttribute("user");
        List<Ad> ads = adsDao.getAdsByUser(id);

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.setAttribute("user", user);
        request.setAttribute("ads", ads);

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String emailUpdate = request.getParameter("email-update");
        String passwordUpdate = request.getParameter("password-update");
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();

        if (emailUpdate != null && !emailUpdate.isEmpty()) {
            DaoFactory.getUsersDao().changeEmail(emailUpdate, username);
        }

        if (passwordUpdate != null && !passwordUpdate.isEmpty()) {
            DaoFactory.getUsersDao().changePassword(passwordUpdate, username);
        }

        user = DaoFactory.getUsersDao().findByUsername(username);
        request.getSession().invalidate();
        request.getSession().setAttribute("user", user);

        response.sendRedirect("/profile");
    }
}
