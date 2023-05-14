package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class AddressDao implements BaseAddressDAO{
    @Override
    public List<Address> findAll() throws DaoException {
        return null;
    }

    @Override
    public Address findEntityById(int id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Address t) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean create(Address t) throws DaoException {
        return false;
    }

    @Override
    public Address update(Address t) throws DaoException {
        return null;
    }

    @Override
    public void close(Statement statement) {
        BaseAddressDAO.super.close(statement);
    }

    @Override
    public void close(Connection connection) {
        BaseAddressDAO.super.close(connection);
    }
}
