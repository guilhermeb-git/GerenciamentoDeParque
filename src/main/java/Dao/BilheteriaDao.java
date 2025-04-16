package Dao;

import Models.Bilheteria;
import Connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BilheteriaDao {

    // Listar todas as bilheteiras
    public List<Bilheteria> listarTodas() {
        String sql = "SELECT * FROM bilheteira";
        List<Bilheteria> lista = new ArrayList<>();

        // Usando ConnectionFactory para obter a conexão
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Bilheteria b = new Bilheteria();
                b.setId(rs.getInt("id"));
                b.setDescricao(rs.getString("descricao"));
                b.setPreco(rs.getBigDecimal("preco"));
                b.setQuantidadeDisponivel(rs.getInt("quantidade_disponivel"));
                b.setHorarioFechamento(rs.getTime("horario_fechamento").toLocalTime());
                lista.add(b);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar bilheteiras: " + e.getMessage());
        }

        return lista;
    }

    // Reduzir quantidade disponível de bilheteira após compra
    public boolean reduzirQuantidade(int bilheteriaId) {
        String sql = "UPDATE bilheteira SET quantidade_disponivel = quantidade_disponivel - 1 WHERE id = ? AND quantidade_disponivel > 0";

        // Usando ConnectionFactory para obter a conexão
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bilheteriaId);

            // Verificar se a atualização foi bem-sucedida
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                System.err.println("Quantidade não foi reduzida. Verifique se há ingressos disponíveis.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao reduzir quantidade de bilheteira: " + e.getMessage());
            return false;
        }
    }
}
