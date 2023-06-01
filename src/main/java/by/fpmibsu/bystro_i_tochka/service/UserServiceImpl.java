package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.fpmibsu.bystro_i_tochka.DAO.UserDAO;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements BaseUserService{
    static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());

    private UserDAO dao = new UserDAO();
    @Override
    public void createUser(String name, String login, String password, Address address, boolean isAdmin) throws DaoException {
        User user = new User(isAdmin,name,login,password,0,address);
        dao.create(user);
        logger.log(Level.INFO, "created new user " + user.toString());
    }

    @Override
    public boolean login(String login, String password) throws DaoException {
        List<User> allUsers = dao.findAll();
        for (var tmp :
                allUsers) {
            if (Objects.equals(tmp.getLogin(), login) && Objects.equals(tmp.getPassword(), password)) {
                logger.log(Level.INFO, "user logined " + tmp.toString());
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteUser(int userId) throws DaoException {
        logger.log(Level.INFO, "user deleted by id " + userId);
        dao.delete(userId);
    }

    @Override
    public void deleteUser(User user) throws DaoException {
        logger.log(Level.INFO, "user deletes " + user.toString());
        deleteUser(user.getId());
    }

    @Override
    public ArrayList<User> findAll() throws DaoException {
        return (ArrayList<User>) new UserDAO().findAll();
    }

    @Override
    public void update(User country, int id, String name, String login, String password, boolean admin, Address address) throws DaoException {
        dao.update(country, id, name, login, password, admin, address);
        logger.log(Level.INFO, "user updated " + country.toString());
    }
}
