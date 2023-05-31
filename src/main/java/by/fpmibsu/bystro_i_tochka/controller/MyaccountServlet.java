package by.fpmibsu.bystro_i_tochka.controller;

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
            request.setCharacterEncoding("UTF-8");
            processRequest(request, response);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DaoException {
        UserServiceImpl user = new UserServiceImpl();
        ArrayList<User> users = user.findAll();
        for(var tmp : users){
            if(tmp.getLogin().equals(request.getSession().getAttribute("username"))){
                request.setAttribute("name", tmp.getName());
                request.setAttribute("login", tmp.getLogin());
                request.setAttribute("password", tmp.getPassword());
            }
        }
        request.getRequestDispatcher("/myaccount.jsp").forward(request, response);
    }
}