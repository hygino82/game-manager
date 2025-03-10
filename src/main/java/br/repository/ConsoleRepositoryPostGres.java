package br.repository;

import br.config.PostgresConfig;
import br.model.Console;
import br.repository.exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        } catch (SQLException e) {
            System.out.println("Erro ao executar a Query!: " + e.getMessage());
        }
        return consoles;
    }
}
