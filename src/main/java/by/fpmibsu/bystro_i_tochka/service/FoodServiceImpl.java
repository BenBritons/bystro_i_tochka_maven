package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.DAO.FoodDAO;
import by.fpmibsu.bystro_i_tochka.DAO.OrderDAO;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodServiceImpl implements BaseFoodService{
    FoodDAO dao = new FoodDAO();
    Logger logger = Logger.getLogger(FoodServiceImpl.class.getName());
    @Override
    public ArrayList<Food> findAll() throws DaoException {
        logger.log(Level.INFO, "all finded");
        return (ArrayList<Food>) dao.findAll();
    }

    @Override
    public Food findEntityById(int id) throws DaoException {
        logger.log(Level.INFO, "findEntityById)))))");
        return dao.findEntityById(id);
    }

    @Override
    public boolean delete(Food t) throws DaoException {
        return dao.delete(t);
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return dao.delete(id);
    }

    @Override
    public boolean create(Food t) throws DaoException {
        return dao.create(t);
    }

    @Override
    public void update(Food country, int id, String name, double price) throws DaoException {
        logger.log(Level.INFO, "Food was updated");
        dao.update(country,id,name, price);
    }
}
