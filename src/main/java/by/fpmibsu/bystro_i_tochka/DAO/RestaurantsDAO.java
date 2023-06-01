package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Restaurants;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class RestaurantsDAO implements BaseRestaurantsDAO{

    private static final String SQL_SELECT_ALL_FOOD =
            "SELECT * FROM restaurants";

    private static final String SQL_SELECT_FOOD_BY_ID =
            "SELECT * FROM restaurants WHERE ID=?";

    private static final String SQL_DELETE_FOOD =
            "DELETE FROM restaurants WHERE ID=?";

    private static final String SQL_CREATE_FOOD =
            "INSERT INTO restaurants(ADDRESS_ID,TIME_START,TIME_END,WEEKENDS,NAME,FOODS) VALUES(?,?,?,?,?,?)";

    private static final String SQL_UPDATE_FOOD =
            "UPDATE restaurants SET ADDRESS_ID=?,TIME_START=?,TIME_END=?,WEEKENDS=?,NAME=?,FOODS=? WHERE ID=?";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public ArrayList<Restaurants> findAll() throws DaoException {
        ArrayList<Restaurants> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FOOD);
            abonents.addAll(loadFromResultSet(resultSet));
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }

        return abonents;
    }

    @Override
    public Restaurants findEntityById(int id) throws DaoException {
        Restaurants country = null;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_FOOD_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            for (Restaurants c : loadFromResultSet(resultSet)) country = c;
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
    public boolean delete(Restaurants t) throws DaoException {
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
    public boolean create(Restaurants t) throws DaoException {
        if (t == null) return false;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_FOOD,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,t.getLocation().getId());
            preparedStatement.setTime(2, Time.valueOf(t.getWorkTimeStart()));
            preparedStatement.setTime(3, Time.valueOf(t.getWorkTimeEnd()));
            StringBuilder str = new StringBuilder();
            for (DayOfWeek tmp:
                 t.getWeekends()) {
                str.append(tmp.getValue());
            }
            preparedStatement.setString(4, str.toString());
            preparedStatement.setString(5, t.getName());
            StringBuilder nstr = new StringBuilder();
            for (var tmp :
                    t.getFoods()) {
                nstr.append(String.valueOf(tmp.getId()));
                nstr.append(" ");
            }
            preparedStatement.setString(6, nstr.toString());
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
    public void update(Restaurants country, int id, Address address, LocalTime workTimeStart, LocalTime workTimeEnd, HashSet<DayOfWeek> weekends, String name, ArrayList<Food> foods) throws DaoException {
        if (country == null) return;
        try{
            connection = ConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_FOOD);
            preparedStatement.setInt(1,address.getId());
            preparedStatement.setTime(2, Time.valueOf(workTimeStart));
            preparedStatement.setTime(3, Time.valueOf(workTimeEnd));
            StringBuilder str = new StringBuilder();
            for (DayOfWeek tmp:
                    weekends) {
                str.append(tmp.getValue());
            }
            preparedStatement.setString(4,str.toString());
            preparedStatement.setString(5,name);
            StringBuilder nstr = new StringBuilder();
            for (var tmp :
                    foods) {
                nstr.append(String.valueOf((tmp)));
                nstr.append(" ");
            }
            preparedStatement.setString(6, nstr.toString());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                country.setWeekends(weekends);
                country.setWorkTimeStart(workTimeStart);
                country.setWorkTimeEnd(workTimeEnd);
                country.setLocation(address);
                country.setName(name);
                country.setFoods(foods);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
    }

    private List<Restaurants> loadFromResultSet(ResultSet resultSet) throws SQLException, DaoException {
        if (resultSet == null) return null;

        List<Restaurants> countries = new ArrayList<>();
        while(resultSet.next()){
            Restaurants country = new Restaurants();
            country.setId(resultSet.getInt(1));
            AddressDAO tmp_loc = new AddressDAO();
            country.setLocation(tmp_loc.findEntityById(resultSet.getInt(2)));
            country.setWorkTimeStart(resultSet.getTime(3).toLocalTime());
            country.setWorkTimeEnd(resultSet.getTime(4).toLocalTime());
            country.setWeekends(parseString(resultSet.getString(5)));
            country.setName(resultSet.getString(6));
            ArrayList<Food> tmp_food = new ArrayList<>();
            for (var tmp :
                    parseStringF(resultSet.getString(7))) {
                FoodDAO dao = new FoodDAO();
                tmp_food.add(dao.findEntityById(tmp));
            }
            country.setFoods(tmp_food);
            countries.add(country);
        }
        return countries;
    }

    private HashSet<DayOfWeek> parseString(String str){
        HashSet<DayOfWeek> days = new HashSet<DayOfWeek>();
        for (var tmp : str.toCharArray()) {
            DayOfWeek tmp_day;
            tmp_day  = DayOfWeek.of(Integer.parseInt(String.valueOf(tmp)));
            days.add(tmp_day);
        }
        return days;
    }
    private ArrayList<Integer> parseStringF(String str){

        return Arrays
                .stream(str.split(" ")) // split
                .map(Integer::parseInt) // convert to String to Integer
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
