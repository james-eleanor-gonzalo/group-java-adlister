package com.codeup.adlister.util;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class Auth {

    private HttpServletRequest request;
    private final String[] preAuthorizedUrls = {
            "/",
            "/ads",
            "/login",
            "/register",
    };
    HttpSession session;

    public Auth(HttpServletRequest request) {
        this.request = request;
        this.session = this.request.getSession();
    }

    public boolean shouldRedirect() {
        // if user is attempting to access a non-pre-authorized path, return false
        if (!Arrays.asList(preAuthorizedUrls).contains(request.getServletPath())) {
            if (!isUserLoggedIn()) {
                return false;
            }
        }
        return true;
    }

    public boolean isUserLoggedIn() {
        return getLoggedUser() != null;
    }

    public User getLoggedUser(){
        return (User) this.session.getAttribute("user");
    }

    public boolean verifyAdUser(Ad ad) {
        if (getLoggedUser() != null) {
            return getLoggedUser().getId() == ad.getUser().getId();
        }
        return false;
    }

}
