package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

public interface BaseAddressService {
    Address findEntityById(int id) throws DaoException;
    boolean delete(Address t) throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean create(Address t) throws DaoException;
    void update(Address country,int id,String street,int house, int flatnumber) throws DaoException;
}
