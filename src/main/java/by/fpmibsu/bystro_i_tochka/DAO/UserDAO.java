package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements BaseUserDAO{
    private static final String SQL_SELECT_ALL_USER =
            "SELECT * FROM users";

    private static final String SQL_SELECT_ADDRESS_BY_ID =
            "SELECT * FROM users WHERE ID=?";

    private static final String SQL_DELETE_ADDRESS =
            "DELETE FROM users WHERE ID=?";

    private static final String SQL_CREATE_ADDRESS =
            "INSERT INTO users(NAME,LOGIN,PASS,IS_ADMIN) VALUES(?,?,?,?)";

    private static final String SQL_UPDATE_ADDRESS =
            "UPDATE users SET NAME=?,LOGIN=?,PASS=?,IS_ADMIN=? WHERE ID=?";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public List<User> findAll() throws DaoException {
        List<User> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USER);
            while(resultSet.next()){
                User abonent = new User();
                abonent.setId(resultSet.getInt("ID"));
                abonent.setName(resultSet.getString("NAME"));
                abonent.setLogin(resultSet.getString("LOGIN"));
                abonent.setPassword(resultSet.getString("PASS"));
                abonent.setAdmin(resultSet.getBoolean("IS_ADMIN"));
                abonents.add(abonent);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return abonents;
    }

    @Override
    public User findEntityById(int id) throws DaoException {
        User country = null;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_ADDRESS_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            for (User c : loadFromResultSet(resultSet)) country = c;
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            close(preparedStatement);
            close(connection);
        }

        return country;
    }

    @Override
    public boolean delete(User t) throws DaoException {
        if (t == null) return false;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_ADDRESS);
            preparedStatement.setLong(1,t.getId());
            int rows = preparedStatement.executeUpdate();
            if (rows == 1) return true;
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally{
            close(preparedStatement);
            close(connection);
        }

        return false;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_ADDRESS);
            preparedStatement.setLong(1,id);
            int rows = preparedStatement.executeUpdate();
            if (rows == 1) return true;
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally{
            close(preparedStatement);
            close(connection);
        }

        return false;
    }

    @Override
    public boolean create(User t) throws DaoException {
        if (t == null) return false;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_ADDRESS,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,t.getName());
            preparedStatement.setString(2,t.getLogin());
            preparedStatement.setString(3,t.getPassword());
            preparedStatement.setBoolean(4,t.isAdmin());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                    t.setId(resultSet.getInt(1));
                return true;
            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally{
            close(preparedStatement);
            close(connection);
        }

        return false;
    }

    @Override
    public void update(User country, int id, String name, String login, String password, boolean admin) throws DaoException {
        if (country == null) return;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ADDRESS);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,login);
            preparedStatement.setString(3,password);
            preparedStatement.setBoolean(4,country.isAdmin());
            preparedStatement.setInt(5,country.getId());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                country.setName(name);
                country.setLogin(login);
                country.setPassword(password);
                country.setAdmin(admin);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
    }

    private List<User> loadFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet == null) return null;

        List<User> countries = new ArrayList<>();
        while(resultSet.next()){
            User country = new User();
            country.setId(resultSet.getInt(1));
            country.setName(resultSet.getString(2));
            country.setLogin(resultSet.getString(3));
            country.setPassword(resultSet.getString(4));
            country.setAdmin(resultSet.getBoolean(5));
            countries.add(country);
        }
        return countries;
    }
}
