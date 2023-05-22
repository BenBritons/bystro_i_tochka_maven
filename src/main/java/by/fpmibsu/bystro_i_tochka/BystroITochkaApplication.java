package by.fpmibsu.bystro_i_tochka;

import by.fpmibsu.bystro_i_tochka.DAO.AddressDAO;
import by.fpmibsu.bystro_i_tochka.DAO.FoodDAO;
import by.fpmibsu.bystro_i_tochka.DAO.OrderDAO;
import by.fpmibsu.bystro_i_tochka.entity.*;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BystroITochkaApplication {
    public static void main(String[] args) throws DaoException {
        Address address = new AddressDAO().findEntityById(2);
        User user = new User("Ivan","ivanlytsin","1111",1);
        Food food1 = new Food(1,200, "ogurchiki");
        Food food2 = new Food(2,230, "pomodorki");
        ArrayList<Food> order = new ArrayList<>();
        order.add(food1);
        order.add(food2);
        OrderDAO dao = new OrderDAO();
        dao.create(new Order(user,1,address,order,new Date(Date.UTC(107, Calendar.JANUARY, 12, 1, 1, 1))));
    }
}
