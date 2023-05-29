package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.DAO.OrderDAO;
import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Order;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderServiceImpl implements BaseOrderService{
    OrderDAO dao = new OrderDAO();
    Logger logger = Logger.getLogger(OrderServiceImpl.class.getName());
    @Override
    public void createOrder(Order order) throws DaoException {
        dao.create(order);
        logger.log(Level.INFO, "new order appear");
    }

    @Override
    public void deleteOrder(Order order) throws DaoException {
        dao.delete(order);
    }

    @Override
    public void addFoodToOrder(Food food, Order order) throws DaoException {
        ArrayList<Food> newOrder = order.getOrder();
        newOrder.add(food);
        dao.update(order, order.getUser(), order.getAddress(), order.getDate(), newOrder);
        logger.log(Level.INFO, "added food to order");
    }

    @Override
    public void changeAddress(Address address, Order order) throws DaoException {
        dao.update(order, order.getUser(), address, order.getDate(), order.getOrder());
        logger.log(Level.INFO, "added new address to order");
    }
}
