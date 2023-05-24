package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Order;

public interface BaseOrderService {
    void createOrder(String name, String login, Food food, Address address);
    void deleteOrder(Order order);
    void addFoodToOrder(Food food, Order order);
    void changeAddress(Address address, Order order);
}
