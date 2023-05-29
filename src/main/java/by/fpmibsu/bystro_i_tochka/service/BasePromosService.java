package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Promos;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

public interface BasePromosService {
    void createPromos(Promos promos) throws DaoException;
    void deletePromos(Promos promos) throws DaoException;
    void deletePromos(int id) throws DaoException;
    void changeFood(Promos promos, Food food) throws DaoException;
    void changeDiscount(Promos promos, int discount) throws DaoException;
}
