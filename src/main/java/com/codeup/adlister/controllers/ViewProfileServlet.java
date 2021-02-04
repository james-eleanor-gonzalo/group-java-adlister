package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
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
