package Dao;

import Models.Participacao;
import Connection.ConnectionFactory;

import java.sql.*;

public class ParticipacaoDao {

    public boolean registrarParticipacao(Participacao participacao) {
        String sql = "INSERT INTO participacao (cliente_id, atracao_id) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, participacao.getClienteId());
            stmt.setInt(2, participacao.getAtracaoId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

