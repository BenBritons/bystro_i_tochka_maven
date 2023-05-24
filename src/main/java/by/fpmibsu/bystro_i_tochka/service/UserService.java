package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.DAO.UserDAO;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.util.List;
import java.util.Objects;

public class UserService implements BaseUserService{
    private UserDAO dao;
    @Override
    public void createUser(String name, String login, String password) throws DaoException {
        dao.create(new User(name,login,password));
    }

    @Override
    public boolean login(String login, String password) throws DaoException {
        List<User> allUsers = dao.findAll();
        for (var tmp :
                allUsers) {
            if (Objects.equals(tmp.getLogin(), login) && Objects.equals(tmp.getPassword(), password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteUser(int userId) throws DaoException {
        dao.delete(userId);
    }

    @Override
    public void deleteUser(User user) throws DaoException {
        deleteUser(user.getId());
    }
}
