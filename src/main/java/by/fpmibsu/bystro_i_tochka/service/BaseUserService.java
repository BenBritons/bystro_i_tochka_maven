package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Order;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface BaseUserService {
    void createUser(String name, String login, String password) throws DaoException;
    boolean login(String login, String password) throws DaoException;
    void deleteUser(int userId) throws DaoException;
    void deleteUser(User user) throws DaoException;
    ArrayList<User> findAll() throws DaoException;
    public void update(User country, int id, String name, String login, String password, boolean admin) throws DaoException;
}
