package by.fpmibsu.bystro_i_tochka.DAO;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {
    private static final DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("C:\\Users\\ivanl\\IdeaProjects\\bystro_i_tochka_maven\\src\\main\\resources\\database.properties"));
        } catch (IOException e) {
            System.out.println("Error loading database.properties");
            e.printStackTrace();
        }

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(properties.getProperty("db.url"));
        basicDataSource.setUsername(properties.getProperty("user"));
        basicDataSource.setPassword(properties.getProperty("password"));
        basicDataSource.setDriverClassName(properties.getProperty("db.driver"));

        dataSource = basicDataSource;
    }

    private ConnectionPool() {}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
