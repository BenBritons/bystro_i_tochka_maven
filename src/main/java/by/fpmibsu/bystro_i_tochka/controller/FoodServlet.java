package by.fpmibsu.bystro_i_tochka.controller;

import by.fpmibsu.bystro_i_tochka.DAO.FoodDAO;
import by.fpmibsu.bystro_i_tochka.entity.Food;
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

@WebServlet("/food")
public class FoodServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            processRequest(request, response);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            processRequest(request, response);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DaoException {
        ArrayList<Food> foods = new RestaurantsServiceImpl().findEntityById((int)request.getAttribute("rest_id")).getFoods();
        request.setAttribute("rest_food_list", foods);
        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }
}
