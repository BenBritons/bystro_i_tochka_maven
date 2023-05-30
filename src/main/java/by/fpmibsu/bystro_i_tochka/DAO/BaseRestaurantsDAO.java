package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Promos;
import by.fpmibsu.bystro_i_tochka.entity.Restaurants;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface BaseRestaurantsDAO {
    ArrayList<Restaurants> findAll() throws DaoException;
    Restaurants findEntityById(int id) throws DaoException;
    boolean delete(Restaurants t) throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean create(Restaurants t) throws DaoException;
    void update(Restaurants country, int id, Address address, LocalTime workTimeStart, LocalTime workTimeEnd, HashSet<DayOfWeek> weekends, String name) throws DaoException;
    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            //log
        }
    }
    default void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close(); // or connection return code to the pool
            }
        } catch (SQLException e) {
// log
        }
    }
}
