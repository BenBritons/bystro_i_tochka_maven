package by.fpmibsu.bystro_i_tochka.controller;

import by.fpmibsu.bystro_i_tochka.DAO.FoodDAO;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Restaurants;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import by.fpmibsu.bystro_i_tochka.service.FoodServiceImpl;
import by.fpmibsu.bystro_i_tochka.service.OrderServiceImpl;
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
            processRequest(request, response);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DaoException {
        ArrayList<Food> foods = new RestaurantsServiceImpl().findEntityById(Integer.parseInt(request.getParameter("rest_id"))).getFoods();
        System.out.println("AAAAAAAAAAAAAAAAAAA");
        if(request.getParameter("food_id") != null){
            int food_id = Integer.parseInt(request.getParameter("food_id"));
            request.getSession().setAttribute("num_in_cart", (int)request.getSession().getAttribute("num_in_cart") + 1);
            OrderServiceImpl orderService = new OrderServiceImpl();
           // orderService.addFoodToOrder(new FoodServiceImpl().findEntityById(food_id), );
        }

        request.setAttribute("rest_food_list", foods);
        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }
}
