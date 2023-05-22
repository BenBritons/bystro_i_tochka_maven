package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Promos;
import by.fpmibsu.bystro_i_tochka.entity.Reviews;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseReviewsDAO {
    List<Reviews> findAll() throws DaoException;
    Reviews findEntityById(int id) throws DaoException;
    boolean delete(Reviews t) throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean create(Reviews t) throws DaoException;
    void update(Reviews country, int id, Food food, User user, int mark, String comment) throws DaoException;
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
