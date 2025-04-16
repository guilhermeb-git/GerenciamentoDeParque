package Dao;

import Models.Ingresso;
import Connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngressoDao {

    // Método para listar todos os ingressos
    public List<Ingresso> listarTodos() {
        List<Ingresso> ingressos = new ArrayList<>();
        String sql = "SELECT * FROM ingresso"; // SQL para pegar todos os ingressos

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Iterar sobre os resultados e adicionar cada ingresso à lista
            while (rs.next()) {
                Ingresso ingresso = new Ingresso();
                ingresso.setId(rs.getInt("id"));
                ingresso.setClienteId(rs.getInt("cliente_id"));
                ingresso.setAtracaoId(rs.getInt("atracao_id"));
                ingresso.setDataCompra(rs.getTimestamp("data_compra").toLocalDateTime());
                ingresso.setFormaPagamento(rs.getString("forma_pagamento"));
                ingresso.setValidado(rs.getBoolean("validado"));

                ingressos.add(ingresso);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingressos;
    }

    // Método para validar ingresso
    public boolean validarIngresso(int ingressoId) {
        String sql = "UPDATE ingresso SET validado = true WHERE id = ? AND validado = false"; // Atualiza apenas ingressos não validados

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ingressoId);

            int rowsAffected = stmt.executeUpdate();

            // Se a atualização for bem-sucedida, retorna true
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Outros métodos do IngressoDao...
}
