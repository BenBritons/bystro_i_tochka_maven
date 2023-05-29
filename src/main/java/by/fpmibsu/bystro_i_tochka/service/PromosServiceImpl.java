package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.DAO.OrderDAO;
import by.fpmibsu.bystro_i_tochka.DAO.PromosDAO;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Promos;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PromosServiceImpl implements BasePromosService{
    PromosDAO dao = new PromosDAO();
    Logger logger = Logger.getLogger(PromosServiceImpl.class.getName());
    @Override
    public void createPromos(Promos promos) throws DaoException {
        dao.create(promos);
        logger.log(Level.INFO, "new promo was created");
    }

    @Override
    public void deletePromos(Promos promos) throws DaoException {
        dao.delete(promos);
        logger.log(Level.INFO, "new promo was deleted");
    }

    @Override
    public void deletePromos(int id) throws DaoException {
        dao.delete(id);
        logger.log(Level.INFO, "new promo was deleted");
    }

    @Override
    public void changeFood(Promos promos, Food food) throws DaoException {
        dao.update(promos, promos.getId(), food, promos.getDiscount());
        logger.log(Level.INFO, "food in promo was changed");
    }

    @Override
    public void changeDiscount(Promos promos, int discount) throws DaoException {
        dao.update(promos, promos.getId(), promos.getFood(), discount);
        logger.log(Level.INFO, "discount in promo was changed");

    }
}
