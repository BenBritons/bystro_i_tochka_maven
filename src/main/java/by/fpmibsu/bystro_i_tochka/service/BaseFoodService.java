package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.util.ArrayList;
import java.util.List;

public interface BaseFoodService {
    ArrayList<Food> findAll() throws DaoException;
    Food findEntityById(int id) throws DaoException;
    boolean delete(Food t) throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean create(Food t) throws DaoException;
    void update(Food country,int id,String name,double price) throws DaoException;
}
