package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.util.Auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdsShowServlet", urlPatterns = "/ads/show")
public class AdsShowServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adIdString = request.getParameter("id");
        long Id = Long.parseLong(adIdString);
        request.getSession().setAttribute("url", request.getRequestURI() + "?id=" + Id);

        Ad individual = DaoFactory.getAdsDao().individualAd(Id);
        request.setAttribute("ad", DaoFactory.getAdsDao().individualAd(Id));
        request.getRequestDispatcher("/WEB-INF/ads/individualAd.jsp").forward(request, response);
    }
}
