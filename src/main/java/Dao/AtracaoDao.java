package Dao;

import Models.Atracao;
import Connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtracaoDao {

    // Método para listar todas as atrações
    public List<Atracao> listarTodas() {
        List<Atracao> lista = new ArrayList<>();
        String sql = "SELECT * FROM atracao";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Atracao atracao = new Atracao();
                atracao.setId(rs.getInt("id"));
                atracao.setNome(rs.getString("nome"));
                atracao.setHorario(rs.getTime("horario").toLocalTime());
                atracao.setCapacidade(rs.getInt("capacidade"));
                lista.add(atracao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
