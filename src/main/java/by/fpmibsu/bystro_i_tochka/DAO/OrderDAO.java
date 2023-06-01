package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.controller.ConnectionPool;
import by.fpmibsu.bystro_i_tochka.entity.*;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;

public class OrderDAO implements BaseOrderDAO{

    private static final String SQL_SELECT_ALL_FOOD =
            "SELECT * FROM orders";

    private static final String SQL_SELECT_FOOD_BY_ID =
            "SELECT * FROM orders WHERE ID=?";

    private static final String SQL_DELETE_FOOD =
            "DELETE FROM orders WHERE ID=?";

    private static final String SQL_CREATE_FOOD =
            "INSERT INTO orders(USER_ID,ADDRESS_ID,DATE,ORDER_LIST) VALUES(?,?,?,?)";

    private static final String SQL_UPDATE_FOOD =
            "UPDATE orders SET USER_ID=?,ADDRESS_ID=?,DATE=?,ORDER_LIST=? WHERE ID=?";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public List<Order> findAll() throws DaoException {
        List<Order> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FOOD);
            while(resultSet.next()){
                Order abonent = new Order();
                abonent.setId(resultSet.getInt("ID"));
                UserDAO tmp_user = new UserDAO();
                abonent.setUser(tmp_user.findEntityById(resultSet.getInt("USER_ID")));
                AddressDAO tmp_address = new AddressDAO();
                abonent.setAddress(tmp_address.findEntityById(resultSet.getInt("ADDRESS_ID")));
                abonent.setDate(resultSet.getDate("DATE"));
                ArrayList<Food> tmp_food = new ArrayList<>();
                for (var tmp :
                        parseString(resultSet.getString("ORDER_LIST"))) {
                    FoodDAO dao = new FoodDAO();
                    tmp_food.add(dao.findEntityById(tmp));
                }
                abonent.setOrder(tmp_food);
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
    public Order findEntityById(int id) throws DaoException {
        Order country = null;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_FOOD_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            for (Order c : loadFromResultSet(resultSet)) country = c;
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
    public boolean delete(Order t) throws DaoException {
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
    public boolean create(Order t) throws DaoException {
        if (t == null) return false;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_FOOD,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,t.getUser().getId());
            preparedStatement.setInt(2,t.getAddress().getId());
            preparedStatement.setDate(3, new java.sql.Date(t.getDate().getTime()));
            StringBuilder str = new StringBuilder();
            for (var tmp :
                    t.getOrder()) {
                str.append(String.valueOf(tmp.getId()));
                str.append(" ");
            }
            preparedStatement.setString(4, str.toString());
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
    public void update(Order country, User user, Address address, Date date, ArrayList<Food> order) throws DaoException {
        if (country == null) return;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_FOOD);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setInt(2,address.getId());
            preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
            StringBuilder str = new StringBuilder();
            for (var tmp :
                    order) {
                str.append(String.valueOf(tmp.getId()));
                str.append(" ");
            }
            preparedStatement.setString(4,str.toString());
            preparedStatement.setInt(5,country.getId());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                country.setUser(user);
                country.setAddress(address);
                country.setDate(date);
                country.setOrder(order);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
    }

    private ArrayList<Integer> parseString(String str){

        return Arrays
                .stream(str.split(" ")) // split
                .map(Integer::parseInt) // convert to String to Integer
                .collect(Collectors.toCollection(ArrayList::new));
    }
    private List<Order> loadFromResultSet(ResultSet resultSet) throws SQLException, DaoException {
        if (resultSet == null) return null;

        List<Order> countries = new ArrayList<>();
        while(resultSet.next()){
            Order country = new Order();
            country.setId(resultSet.getInt(1));
            AddressDAO tmp_loc = new AddressDAO();
            country.setAddress(tmp_loc.findEntityById(resultSet.getInt(3)));
            UserDAO tmp_user = new UserDAO();
            country.setUser(tmp_user.findEntityById(resultSet.getInt(2)));
            country.setDate(resultSet.getDate(4));
            ArrayList<Food> tmp_food = new ArrayList<>();
            for (var tmp :
                    parseString(resultSet.getString(5))) {
                FoodDAO dao = new FoodDAO();
                tmp_food.add(dao.findEntityById(tmp));
            }
            country.setOrder(tmp_food);
            countries.add(country);
        }
        return countries;
    }

}
