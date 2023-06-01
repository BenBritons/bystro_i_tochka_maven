package by.fpmibsu.bystro_i_tochka;

import by.fpmibsu.bystro_i_tochka.DAO.AddressDAO;
import by.fpmibsu.bystro_i_tochka.DAO.FoodDAO;
import by.fpmibsu.bystro_i_tochka.DAO.OrderDAO;
import by.fpmibsu.bystro_i_tochka.DAO.RestaurantsDAO;
import by.fpmibsu.bystro_i_tochka.entity.*;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import by.fpmibsu.bystro_i_tochka.service.RestaurantsServiceImpl;
import by.fpmibsu.bystro_i_tochka.service.UserServiceImpl;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BystroITochkaApplication {
    public static void main(String[] args) throws DaoException {
        ArrayList<Restaurants> restaurants = new RestaurantsServiceImpl().findAll();
        System.out.println(restaurants);
        }
}
