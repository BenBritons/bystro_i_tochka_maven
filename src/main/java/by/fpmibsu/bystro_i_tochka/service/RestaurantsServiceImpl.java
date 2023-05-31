package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.DAO.AddressDAO;
import by.fpmibsu.bystro_i_tochka.DAO.RestaurantsDAO;
import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Restaurants;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantsServiceImpl implements BaseRestaurantsService{

    RestaurantsDAO dao = new RestaurantsDAO();
    Logger logger = Logger.getLogger(RestaurantsServiceImpl.class.getName());

    @Override
    public ArrayList<Restaurants> findAll() throws DaoException {
        logger.log(Level.INFO, "URA VY RESHILI VYBRAT LIST VSEH RESTARANOV NU TY I CRUTOI KONECHNO");
        return (ArrayList<Restaurants>) dao.findAll();
    }

    @Override
    public Restaurants findEntityById(int id) throws DaoException {
        logger.log(Level.INFO, "Die Entity wird beim id genommen");
        return dao.findEntityById(id);
    }

    @Override
    public boolean delete(Restaurants t) throws DaoException {
        logger.log(Level.INFO, "Die Adresse wird gelöschen");
        return dao.delete(t);
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return dao.delete(id);
    }

    @Override
    public boolean create(Restaurants t) throws DaoException {
        return dao.create(t);
    }

    @Override
    public void update(Restaurants country, int id, Address address, LocalTime workTimeStart, LocalTime workTimeEnd, HashSet<DayOfWeek> weekends, String name, ArrayList<Food> foods) throws DaoException {
        dao.update(country, id, address, workTimeStart, workTimeEnd, weekends, name, foods);
    }
}
