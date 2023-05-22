package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseFoodDAO {
    List<Food> findAll() throws DaoException;
    Food findEntityById(int id) throws DaoException;
    boolean delete(Food t) throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean create(Food t) throws DaoException;
    void update(Food country,int id,String name,double price) throws DaoException;
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
