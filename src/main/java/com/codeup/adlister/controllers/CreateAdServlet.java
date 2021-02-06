package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;

        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user=null;
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        boolean titleHasErrors = title.isEmpty();
        boolean descriptionHasErrors = description.isEmpty();
        boolean priceHasErrors = price.isEmpty();
        boolean notValidAttempt = titleHasErrors || descriptionHasErrors || priceHasErrors;

        if(session != null) {
           user = (User) session.getAttribute("user");
        }

        if(user != null) {
            if (!notValidAttempt) {
                Ad ad = new Ad(

                        user.getId(),
                        request.getParameter("title"),
                        request.getParameter("description"),
                        request.getParameter("price")
//                        request.getParameter("string")


//                        request.getParameter("category")
                );
                DaoFactory.getAdsDao().insert(ad);
                response.sendRedirect("/ads");
            } else {

                PrintWriter out = response.getWriter();
                session.setAttribute("title", title);
                session.setAttribute("description", description);
                session.setAttribute("price", price);
                session.setAttribute("category", "misc");
                out.println(request.getAttribute("title"));
                out.println(request.getAttribute("description"));
            }
        }

//        boolean titleHasErrors = title.isEmpty();
        if (titleHasErrors){
            request.setAttribute("errorTitle", "Please enter a title");
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
        }

//        boolean descriptionHasErrors = description.isEmpty();
        if (descriptionHasErrors){
            request.setAttribute("errorDescription", "Please enter a description");
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
        }

        if (priceHasErrors){
            request.setAttribute("errorDescription", "Please enter a price");
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
        }



//        Ad ad = new Ad(
//            user.getId(),
//            request.getParameter("title"),
//            request.getParameter("description"),
//            request.getParameter("price")
////            request.getParameter("category")
//        );
//        DaoFactory.getAdsDao().insert(ad);
//        response.sendRedirect("/ads");


    }
}
