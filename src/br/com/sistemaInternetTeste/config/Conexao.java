
package br.com.sistemaInternetTeste.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/sistematiosergio";
    private static final String USER = "root";
    private static final String PASS = "Campinas1*";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage(), e);
        }
    }
}
