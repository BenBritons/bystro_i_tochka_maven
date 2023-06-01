package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.*;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewsDAO implements BaseReviewsDAO{

    private static final String SQL_SELECT_ALL_FOOD =
            "SELECT * FROM reviews";

    private static final String SQL_SELECT_FOOD_BY_ID =
            "SELECT * FROM reviews WHERE ID=?";

    private static final String SQL_DELETE_FOOD =
            "DELETE FROM reviews WHERE ID=?";

    private static final String SQL_CREATE_FOOD =
            "INSERT INTO reviews(FOOD_ID,USER_ID,MARK,COMMENT) VALUES(?,?,?,?)";

    private static final String SQL_UPDATE_FOOD =
            "UPDATE reviews SET FOOD_ID=?,USER_ID=?,MARK=?,COMMENT=? WHERE ID=?";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public List<Reviews> findAll() throws DaoException {
        List<Reviews> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FOOD);
            while(resultSet.next()){
                Reviews abonent = new Reviews();
                abonent.setId(resultSet.getInt("ID"));
                FoodDAO tmp_food = new FoodDAO();
                abonent.setFood(tmp_food.findEntityById(resultSet.getInt("FOOD_ID")));
                UserDAO tmp_user = new UserDAO();
                abonent.setUser(tmp_user.findEntityById(resultSet.getInt("USER_ID")));
                abonent.setMark(resultSet.getInt("MARK"));
                abonent.setComment(resultSet.getString("COMMENT"));
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
    public Reviews findEntityById(int id) throws DaoException {
        Reviews country = null;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_FOOD_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            for (Reviews c : loadFromResultSet(resultSet)) country = c;
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
    public boolean delete(Reviews t) throws DaoException {
        return delete(t.getId());
    }

    @Override
    public boolean delete(int id) throws DaoException {
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_FOOD);
            preparedStatement.setInt(1,id);
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
    public boolean create(Reviews t) throws DaoException {
        if (t == null) return false;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_FOOD,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,t.getFood().getId());
            preparedStatement.setInt(2,t.getUser().getId());
            preparedStatement.setInt(3,t.getMark());
            preparedStatement.setString(4, t.getComment());
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
    public void update(Reviews country, int id, Food food, User user, int mark, String comment) throws DaoException {
        if (country == null) return;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_FOOD);
            preparedStatement.setInt(1,food.getId());
            preparedStatement.setInt(2,user.getId());
            preparedStatement.setInt(3,mark);
            preparedStatement.setString(4,comment);
            preparedStatement.setInt(5,country.getId());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                country.setFood(food);
                country.setUser(user);
                country.setMark(mark);
                country.setComment(comment);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
    }

    private List<Reviews> loadFromResultSet(ResultSet resultSet) throws SQLException, DaoException {
        if (resultSet == null) return null;

        List<Reviews> countries = new ArrayList<>();
        while(resultSet.next()){
            Reviews country = new Reviews();
            country.setId(resultSet.getInt(1));
            FoodDAO tmp_loc = new FoodDAO();
            country.setFood(tmp_loc.findEntityById(resultSet.getInt(2)));
            UserDAO tmp_user = new UserDAO();
            country.setUser(tmp_user.findEntityById(resultSet.getInt(3)));
            country.setMark(resultSet.getInt(4));
            country.setComment(resultSet.getString(5));
            countries.add(country);
        }
        return countries;
    }
}
