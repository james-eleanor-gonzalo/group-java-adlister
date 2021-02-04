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

@WebServlet(name = "ShowIndividualAdServlet", urlPatterns = "/individual")
public class ShowIndividualAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adIdString = req.getParameter("id");
        long Id = Long.parseLong(adIdString);
        req.getSession().setAttribute("url", req.getRequestURI() + "?id=" + Id);

        Ad individual = DaoFactory.getAdsDao().individualAd(Id);
        req.setAttribute("ad", DaoFactory.getAdsDao().individualAd(Id));
        req.getRequestDispatcher("/WEB-INF/ads/individualAd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
