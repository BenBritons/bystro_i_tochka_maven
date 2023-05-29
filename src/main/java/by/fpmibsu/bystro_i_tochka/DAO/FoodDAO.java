package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import by.fpmibsu.bystro_i_tochka.service.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO implements BaseFoodDAO {

    private static final String SQL_SELECT_ALL_FOOD =
            "SELECT * FROM food";

    private static final String SQL_SELECT_FOOD_BY_ID =
            "SELECT * FROM food WHERE ID=?";

    private static final String SQL_DELETE_FOOD =
            "DELETE FROM food WHERE ID=?";

    private static final String SQL_CREATE_FOOD =
            "INSERT INTO food(NAME,PRICE) VALUES(?,?)";

    private static final String SQL_UPDATE_FOOD =
            "UPDATE food SET NAME=?,PRICE=? WHERE ID=?";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public List<Food> findAll() throws DaoException {
        List<Food> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FOOD);
            while(resultSet.next()){
                Food abonent = new Food();
                abonent.setId(resultSet.getInt("ID"));
                abonent.setName(resultSet.getString("NAME"));
                abonent.setPrice(resultSet.getDouble("PRICE"));
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
    public Food findEntityById(int id) throws DaoException {
        Food country = null;
        try{
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_FOOD_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            for (Food c : loadFromResultSet(resultSet)) country = c;
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
    public boolean delete(Food t) throws DaoException {
        if (t == null) return false;
        try{
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_FOOD);
            preparedStatement.setInt(1,t.getId());
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
        throw new  UnsupportedOperationException();
    }

    @Override
    public boolean create(Food t) throws DaoException {
        if (t == null) return false;
        try{
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_FOOD,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,t.getName());
            preparedStatement.setDouble(2,t.getPrice());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                    t.setId(resultSet.getInt(1));
                return true;
            }
        } catch(SQLException e){
            LogManager.getLogger(FoodDAO.class.getName()).log(Level.ERROR, "existing food");
        }
        finally{
            close(preparedStatement);
            close(connection);
        }

        return false;
    }

    @Override
    public void update(Food country, int id, String name, double price) throws DaoException {
        if (country == null) return;
        try{
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_FOOD);
            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2,price);
            preparedStatement.setInt(3,country.getId());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                country.setName(name);
                country.setPrice(price);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
    }

    private List<Food> loadFromResultSet(ResultSet resultSet) throws SQLException{
        if (resultSet == null) return null;

        List<Food> countries = new ArrayList<>();
        while(resultSet.next()){
            Food country = new Food();
            country.setId(resultSet.getInt(1));
            country.setName(resultSet.getString(2));
            country.setPrice(resultSet.getDouble(3));
            countries.add(country);
        }
        return countries;
    }
}
