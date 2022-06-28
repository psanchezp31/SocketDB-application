package co.edu.poli.socketdb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/datos";
    private static final String DB_USERNAME = "poli01";
    private static final String DB_PASSWORD = "1234";
    private static final DbUtil INSTANCE = new DbUtil();
    private Connection connection;

    private DbUtil() {
    }

    public static DbUtil getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public Connection initDatabaseConnection() throws SQLException {
        System.out.println("------------------------------------");
        System.out.println("Connecting to the database...");
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        connection.setAutoCommit(false);
        if (connection.isValid(5)) {
            System.out.println("Connected to database.");
        }
        System.out.print("------------------------------------\n\n");
        return connection;
    }

    public void closeDatabaseConnection() throws SQLException {
        System.out.print("\n\n------------------------------------\n");
        System.out.println("Closing database connection...");
        connection.close();
        if (!connection.isValid(5)) {
            System.out.println("Database disconnected.");
        }
        System.out.println("------------------------------------");
    }

}
