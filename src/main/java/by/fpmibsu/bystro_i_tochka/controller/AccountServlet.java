package by.fpmibsu.bystro_i_tochka.controller;

import by.fpmibsu.bystro_i_tochka.DAO.UserDAO;
import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Order;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import by.fpmibsu.bystro_i_tochka.service.OrderServiceImpl;
import by.fpmibsu.bystro_i_tochka.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        int id = 0;
        try {
            if(new UserServiceImpl().login(login,password)){
                PrintWriter out= response.getWriter();
                request.getSession().setAttribute("logined", true);
                request.getSession().setAttribute("username", login);
                ArrayList<User> users = new UserServiceImpl().findAll();
                for (var tmp :
                        users) {
                    if (tmp.getLogin().equals(login) && tmp.getPassword().equals(password)) {
                      id = tmp.getId();
                    }
                }
                Order order = new Order(new UserDAO().findEntityById(id), 0,new Address(), new ArrayList<Food>(), new Date());
                OrderServiceImpl orderService = new OrderServiceImpl();
                orderService.createOrder(order);
                //request.getSession().setAttribute("order", new Order(new UserDAO().findEntityById(id), new Address(), new ArrayList<Food>(), new Date()));
                request.getRequestDispatcher("/myaccount").forward(request, response);
            }else {
                request.setAttribute("logined", false);
                PrintWriter out= response.getWriter();
                out.println("<h1>");
                out.println("alle ist kaputt!!");
                out.println("</h1>");
            }
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DaoException {
        request.getRequestDispatcher("/account.jsp").forward(request, response);
    }
}
