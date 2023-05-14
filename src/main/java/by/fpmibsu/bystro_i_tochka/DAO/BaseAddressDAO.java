package by.fpmibsu.bystro_i_tochka.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

public interface BaseAddressDAO{
    List<Address> findAll() throws DaoException;
    Address findEntityById(int id) throws DaoException;
    boolean delete(Address t) throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean create(Address t) throws DaoException;
    Address update(Address t) throws DaoException;
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