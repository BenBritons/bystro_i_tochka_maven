package by.fpmibsu.bystro_i_tochka.controller;

import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import by.fpmibsu.bystro_i_tochka.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("local").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String login = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        try {
            if(new UserServiceImpl().login(login,password)){
                PrintWriter out= response.getWriter();
                request.getSession().setAttribute("logined", true);
                request.getSession().setAttribute("username", login);
                request.getRequestDispatcher("/myaccount.jsp").forward(request, response);
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
