package by.fpmibsu.bystro_i_tochka;

import by.fpmibsu.bystro_i_tochka.DAO.RestaurantsDAO;
import by.fpmibsu.bystro_i_tochka.DAO.UserDAO;
import by.fpmibsu.bystro_i_tochka.entity.*;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import java.util.ArrayList;

public class BystroITochkaApplication {
    public static void main(String[] args) throws DaoException {
        UserDAO dao = new UserDAO();
        for(int i = 0; i < 9000; ++i){
            dao.delete(19000+i);
        }
    }
}
