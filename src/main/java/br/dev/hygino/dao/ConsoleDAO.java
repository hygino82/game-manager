package br.dev.hygino.dao;

import br.dev.hygino.model.Console;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsoleDAO {

    private static ConsoleDAO instance;

    public static ConsoleDAO getInstance() {
        if (instance == null) {
            instance = new ConsoleDAO();
        }
        return instance;
    }

    private ConsoleDAO() {
    }

    public void insert(Console c) {
        final String sql = "INSERT INTO console(name, company, releaseDate) values (?, ?, ?)";

        try (Connection conn = ConnectionSetup.connect()) {
            final PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getCompany());
            stmt.setDate(3, Date.valueOf(c.getReleaseDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println("Ocorreu um erro ao inserir o console.");
            e.printStackTrace();
        }
        System.out.println("Terminou");
    }

    public List<Console> getConsoleList() {
        final List<Console> consoleList = new ArrayList<>();
        final String sql = "SELECT * FROM console";

        try (Connection conn = ConnectionSetup.connect()) {
            final PreparedStatement stmt = conn.prepareStatement(sql);
            final ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Console c = new Console(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("company"),
                        rs.getDate("releaseDate").toLocalDate()
                );
                consoleList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // mais útil para debugar
            System.out.println("Ocorreu um erro ao buscar os consoles.");
        }

        return consoleList;
    }

    public void update(Console c) {
        final String sql = "UPDATE console SET name = ?, company = ?, releaseDate = ? WHERE id = ?";

        try (Connection conn = ConnectionSetup.connect()) {
            final PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getCompany());
            stmt.setDate(3, Date.valueOf(c.getReleaseDate())); // LocalDate para java.sql.Date
            stmt.setInt(4, c.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar o console.");
        }
    }

    public void remove(int id) {
        final String sql = "DELETE  FROM console WHERE id = ?";

        try (Connection conn = ConnectionSetup.connect()) {
            final PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro");
        }
    }
}
