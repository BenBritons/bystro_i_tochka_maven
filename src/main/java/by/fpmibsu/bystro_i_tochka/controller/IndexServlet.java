package by.fpmibsu.bystro_i_tochka.controller;

import by.fpmibsu.bystro_i_tochka.DAO.RestaurantsDAO;
import by.fpmibsu.bystro_i_tochka.entity.Restaurants;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import by.fpmibsu.bystro_i_tochka.service.RestaurantsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/food").forward(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DaoException {
        ArrayList<Restaurants> restaurants = new RestaurantsServiceImpl().findAll();
        request.setAttribute("restaurants", restaurants);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
