package br.com.mesttra.sb.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            String POSTGRES_HOST = "//127.0.0.1:15432/";
            String POSTGRES_DB = "sb";
            String POSTGRES_USER = System.getenv("POSTGRES_USER");
            String POSTGRES_PASS = System.getenv("POSTGRES_PASS");

            return DriverManager.getConnection(
                    "jdbc:postgresql:" + POSTGRES_HOST + POSTGRES_DB,
                    POSTGRES_USER, POSTGRES_PASS
            );
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
