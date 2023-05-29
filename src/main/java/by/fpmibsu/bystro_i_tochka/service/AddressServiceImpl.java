package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.DAO.AddressDAO;
import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddressServiceImpl implements BaseAddressService{
    AddressDAO dao = new AddressDAO();
    Logger logger = Logger.getLogger(AddressServiceImpl.class.getName());

    @Override
    public Address findEntityById(int id) throws DaoException {
        logger.log(Level.INFO, "finded address by id lol");
        return dao.findEntityById(id);
    }

    @Override
    public boolean delete(Address t) throws DaoException {
        logger.log(Level.INFO, "blin ya abazhau lagirovanie");
        return dao.delete(t);
    }

    @Override
    public boolean delete(int id) throws DaoException {
        logger.log(Level.INFO, "Address udaliusia vo prikol da");
        return dao.delete(id);
    }

    @Override
    public boolean create(Address t) throws DaoException {
        logger.log(Level.INFO, "nalogi eto grabezh naroda");
        return dao.create(t);
    }

    @Override
    public void update(Address country, int id, String street, int house, int flatnumber) throws DaoException {
        logger.log(Level.INFO, "vot tak update sluchilsia");
        dao.update(country, id, street, house, flatnumber);
    }
}
