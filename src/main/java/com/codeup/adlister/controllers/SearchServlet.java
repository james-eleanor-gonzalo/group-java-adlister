package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/ads/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entry = req.getParameter("searchInput");
//        String category = req.getParameter("searchCat");
//      List<Ad> ads = DaoFactory.getAdsDao().searchedAds(entry,category); Use this once you get the title search working, it will search the category.
        List<Ad> ads = DaoFactory.getAdsDao().searchedAds(entry);
        req.setAttribute("search", ads);
        req.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
