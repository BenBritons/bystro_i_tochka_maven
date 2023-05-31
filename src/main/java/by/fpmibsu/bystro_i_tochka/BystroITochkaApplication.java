package by.fpmibsu.bystro_i_tochka;

import by.fpmibsu.bystro_i_tochka.DAO.RestaurantsDAO;
import by.fpmibsu.bystro_i_tochka.entity.*;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import java.util.ArrayList;

public class BystroITochkaApplication {
    public static void main(String[] args) throws DaoException {
        ArrayList<Food> restaurants = new RestaurantsDAO().findEntityById(7).getFoods();
        System.out.println(restaurants);
        }
}
