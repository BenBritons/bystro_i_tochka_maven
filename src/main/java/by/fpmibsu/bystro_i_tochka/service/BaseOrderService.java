package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Order;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

public interface BaseOrderService {
    void createOrder(Order order) throws DaoException;
    void deleteOrder(Order order) throws DaoException;
    void addFoodToOrder(Food food, Order order) throws DaoException;
    void changeAddress(Address address, Order order) throws DaoException;

}
