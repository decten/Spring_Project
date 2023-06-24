package org.example;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConnectionManger {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=1";
    public static final String DB_USER = "sa";
    public static final String DB_PASSWORD = "";
    public static final int MAX_POOL_SIZE = 40;

    private static final DataSource ds;

    static {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(DB_DRIVER);
        hikariDataSource.setJdbcUrl(DB_URL);
        hikariDataSource.setUsername(DB_USER);
        hikariDataSource.setPassword(DB_PASSWORD);
        hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);

        ds = hikariDataSource;
    }
    public static Connection getConnection() throws SQLException {
        try{
            return ds.getConnection();
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }
}
