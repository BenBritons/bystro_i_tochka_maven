package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.controller.ConnectionPool;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Promos;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromosDAO implements BasePromosDAO{
    private static final String SQL_SELECT_ALL_FOOD =
            "SELECT * FROM promos";

    private static final String SQL_SELECT_FOOD_BY_ID =
            "SELECT * FROM promos WHERE ID=?";

    private static final String SQL_DELETE_FOOD =
            "DELETE FROM promos WHERE ID=?";

    private static final String SQL_CREATE_FOOD =
            "INSERT INTO promos(FOOD_ID,DISCOUNT) VALUES(?,?)";

    private static final String SQL_UPDATE_FOOD =
            "UPDATE food SET FOOD_ID=?,DISCOUNT=? WHERE ID=?";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public List<Promos> findAll() throws DaoException {
        List<Promos> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FOOD);
            while(resultSet.next()){
                Promos abonent = new Promos();
                abonent.setId(resultSet.getInt("ID"));
                FoodDAO tmp = new FoodDAO();
                abonent.setFood(tmp.findEntityById(resultSet.getInt("FOOD_ID")));
                abonent.setDiscount(resultSet.getInt("DISCOUNT"));
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
    public Promos findEntityById(int id) throws DaoException {
        Promos country = null;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_FOOD_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            for (Promos c : loadFromResultSet(resultSet)) country = c;
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
    public boolean delete(Promos t) throws DaoException {
        if (t == null) return false;
        try{
            connection = ConnectionPool.getConnection();
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
    public boolean create(Promos t) throws DaoException {
        if (t == null) return false;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_FOOD,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,t.getFood().getId());
            preparedStatement.setInt(2,t.getDiscount());
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
    public void update(Promos country, int id, Food food, int discount) throws DaoException {
        if (country == null) return;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_FOOD);
            preparedStatement.setInt(1,food.getId());
            preparedStatement.setInt(2,discount);
            preparedStatement.setInt(3,country.getId());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                country.setFood(food);
                country.setDiscount(discount);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
    }

    private List<Promos> loadFromResultSet(ResultSet resultSet) throws SQLException, DaoException {
        if (resultSet == null) return null;

        List<Promos> countries = new ArrayList<>();
        while(resultSet.next()){
            Promos abonent = new Promos();
            abonent.setId(resultSet.getInt(1));
            FoodDAO tmp = new FoodDAO();
            abonent.setFood(tmp.findEntityById(resultSet.getInt(2)));
            abonent.setDiscount(resultSet.getInt(3));
            countries.add(abonent);
        }
        return countries;
    }
}
