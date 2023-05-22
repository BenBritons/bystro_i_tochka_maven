package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.*;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public interface BaseOrderDAO {
    List<Order> findAll() throws DaoException;
    Order findEntityById(int id) throws DaoException;
    boolean delete(Order t) throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean create(Order t) throws DaoException;
    void update(Order country, User user, Address address, Date date, ArrayList<Food> order) throws DaoException;
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
