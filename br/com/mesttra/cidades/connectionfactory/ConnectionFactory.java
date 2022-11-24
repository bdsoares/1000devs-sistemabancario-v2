package br.com.mesttra.cidades.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            String POSTGRES_USER = System.getenv("POSTGRES_USER");
            String POSTGRES_PASS = System.getenv("POSTGRES_PASS");

            return DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:15432/sb", POSTGRES_USER, POSTGRES_PASS
            );
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
