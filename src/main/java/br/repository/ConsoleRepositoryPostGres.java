package br.repository;

import br.config.PostgresConfig;
import br.model.Console;
import br.repository.exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsoleRepositoryPostGres implements IConsoleRepository {

    @Override
    public List<Console> getGamelist() {
        List<Console> consoles = new ArrayList<>();
        try (Connection conn = PostgresConfig.getConnection()) {
            String query = "SELECT * FROM console";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Console console = new Console();
                        console.setId(rs.getLong("id"));
                        console.setName(rs.getString("name"));
                        console.setCompany(rs.getString("company"));
                        console.setReleaseDate(rs.getDate("release_date").toLocalDate());
                        console.setImageUrl(rs.getString("image_url"));
                        consoles.add(console);
                    }
                }
            }
            return consoles;

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao executar a Query!: " + e.getMessage());
        }
    }

    @Override
    public Console save(Console entity) {
        final String query = "INSERT INTO console (name, company, release_date, image_url) VALUES (?, ?, ?, ?)";
        try (Connection conn = PostgresConfig.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, entity.getName());
                stmt.setString(2, entity.getCompany());
                stmt.setDate(3, java.sql.Date.valueOf(entity.getReleaseDate()));
                stmt.setString(4, entity.getImageUrl());
                stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setId(rs.getLong("id"));
                    }
                }
                return entity;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir console: " + e.getMessage());
            throw new DatabaseException("Erro ao inserir console!: " + e);
        }
    }

    @Override
    public Optional<Console> findById(long id) {
        final String query = "SELECT * FROM console WHERE id = ?";
        try (Connection conn = PostgresConfig.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setLong(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Console console = new Console();
                        console.setId(rs.getLong("id"));
                        console.setName(rs.getString("name"));
                        console.setCompany(rs.getString("company"));
                        console.setReleaseDate(rs.getDate("release_date").toLocalDate());
                        console.setImageUrl(rs.getString("image_url"));
                        return Optional.of(console);
                    } else {
                        return Optional.empty();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao encontrar console por ID: " + e.getMessage());
            throw new DatabaseException("Erro ao encontrar console por ID!: " + e);
        }
    }

    @Override
    public boolean removeConsoleById(long id) {
        final String query = "DELETE FROM console WHERE id = ?";
        try (Connection conn = PostgresConfig.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setLong(1, id);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover console por ID: " + e.getMessage());
            throw new DatabaseException("Erro ao remover console por ID!: " + e);
        }
    }

    @Override
    public Console updateConsole(long id, Console entity) {
        final String query = "UPDATE console SET name = ?, company = ?, release_date = ?, image_url = ? WHERE id = ?";
        try (Connection conn = PostgresConfig.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, entity.getName());
                stmt.setString(2, entity.getCompany());
                stmt.setDate(3, java.sql.Date.valueOf(entity.getReleaseDate()));
                stmt.setString(4, entity.getImageUrl());
                stmt.setLong(5, id);
                stmt.executeUpdate();
                return entity;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar console: " + e.getMessage());
            throw new DatabaseException("Erro ao atualizar console!: " + e);
        }
    }
}
