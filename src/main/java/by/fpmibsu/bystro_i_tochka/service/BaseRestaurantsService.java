package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Restaurants;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface BaseRestaurantsService {
    ArrayList<Restaurants> findAll() throws DaoException;
    Restaurants findEntityById(int id) throws DaoException;
    boolean delete(Restaurants t) throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean create(Restaurants t) throws DaoException;
    void update(Restaurants country, int id, Address address, LocalTime workTimeStart, LocalTime workTimeEnd, HashSet<DayOfWeek> weekends, String name, ArrayList<Food> foods) throws DaoException;

}
