package br.dev.hygino.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionSetup {
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro";
    private static final String USER = "root";
    private static final String PASSWORD = "89631139";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
