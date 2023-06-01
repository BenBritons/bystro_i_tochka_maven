package by.fpmibsu.bystro_i_tochka.controller;

import by.fpmibsu.bystro_i_tochka.DAO.UserDAO;
import by.fpmibsu.bystro_i_tochka.entity.Restaurants;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import by.fpmibsu.bystro_i_tochka.service.RestaurantsServiceImpl;
import by.fpmibsu.bystro_i_tochka.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/myaccount")
public class MyaccountServlet extends HttpServlet {

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
            User user = (User) request.getSession().getAttribute("user");
                request.setAttribute("name", user.getName());
                request.setAttribute("login", user.getLogin());
                request.setAttribute("password", user.getPassword());
                request.setAttribute("address", user.getAddress().toString());
                request.getRequestDispatcher("/myaccount.jsp").forward(request, response);
    }
}