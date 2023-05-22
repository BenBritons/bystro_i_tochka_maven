package by.fpmibsu.bystro_i_tochka.DAO;

import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements BaseAddressDAO {

    private static final String SQL_SELECT_ALL_ADDRESS =
            "SELECT * FROM address";

    private static final String SQL_SELECT_ADDRESS_BY_ID =
            "SELECT * FROM address WHERE ID=?";

    private static final String SQL_DELETE_ADDRESS =
            "DELETE FROM address WHERE ID=?";

    private static final String SQL_CREATE_ADDRESS =
            "INSERT INTO address(STREET,HOUSE,FLATNUMBER) VALUES(?,?,?)";

    private static final String SQL_UPDATE_ADDRESS =
            "UPDATE address SET STREET=?,HOUSE=?,FLATNUMBER=? WHERE ID=?";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;


    @Override
    public List<Address> findAll() throws DaoException {
        List<Address> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ADDRESS);
            while(resultSet.next()){
                Address abonent = new Address();
                abonent.setId(resultSet.getInt("ID"));
                abonent.setStreet(resultSet.getString("STREET"));
                abonent.setHouse(resultSet.getInt("HOUSE"));
                abonent.setFlatNumber(resultSet.getInt("FLATNUMBER"));
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
    public Address findEntityById(int id) throws DaoException {
        Address country = null;
        try{
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_ADDRESS_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            for (Address c : loadFromResultSet(resultSet)) country = c;
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
    public boolean delete(Address address) throws DaoException {
        if (address == null) return false;
        try{
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_ADDRESS);
            preparedStatement.setLong(1,address.getId());
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
    public boolean create(Address address) throws DaoException {
        if (address == null) return false;
        try{
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_ADDRESS,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,address.getStreet());
            preparedStatement.setInt(2,address.getHouse());
            preparedStatement.setInt(3, address.getFlatNumber());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                    address.setId(resultSet.getInt(1));
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
    public void update(Address country, int id, String street, int house, int flatnumber) throws DaoException {
        if (country == null) return;
        try{
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ADDRESS);
            preparedStatement.setString(1,street);
            preparedStatement.setInt(2,house);
            preparedStatement.setInt(3,flatnumber);
            preparedStatement.setLong(4,country.getId());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1){
                country.setFlatNumber(flatnumber);
                country.setStreet(street);
                country.setHouse(house);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            close(preparedStatement);
            close(connection);
        }

    }


    @Override
    public void close(Statement statement) {
        BaseAddressDAO.super.close(statement);
    }

    @Override
    public void close(Connection connection) {
        BaseAddressDAO.super.close(connection);
    }

    private List<Address> loadFromResultSet(ResultSet resultSet) throws SQLException{
        if (resultSet == null) return null;

        List<Address> countries = new ArrayList<>();
        while(resultSet.next()){
            Address country = new Address();
            country.setId(resultSet.getInt(1));
            country.setStreet(resultSet.getString(2));
            country.setHouse(resultSet.getInt(3));
            country.setFlatNumber(resultSet.getInt(4));
            countries.add(country);
        }
        return countries;
    }

}
