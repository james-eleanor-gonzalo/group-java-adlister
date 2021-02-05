package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        if (DaoFactory.getUsersDao().findByUsername(username) != null) {
            request.setAttribute( "errorUserUnavail","This username is unavailable.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;

        }

        // validate input

        boolean usernameHasErrors = username.isEmpty();
        if (usernameHasErrors) {
            request.setAttribute("errorUser", "Please enter a username");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        boolean emailHasErrors = email.isEmpty();
        if (emailHasErrors) {
            request.setAttribute("errorEmail", "Please enter a valid email");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        boolean passwordHasErrors = password.isEmpty();
        if (passwordHasErrors) {
            request.setAttribute("errorPassword", "Please enter a password");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        boolean passwordConfirmationHasErrors = (!password.equals(passwordConfirmation));
        if (passwordConfirmationHasErrors) {
            request.setAttribute("errorMatch", "Please make sure your passwords match");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
