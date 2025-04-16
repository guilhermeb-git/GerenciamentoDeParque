package Dao;

import Models.Cliente;
import Connection.ConnectionFactory;

import java.sql.*;

public class ClienteDao {

    // Salvar cliente no banco (completo)
    public boolean salvarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email, cpf, senha, telefone) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getSenha());
            stmt.setString(5, cliente.getTelefone());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Buscar cliente por ID
    public Cliente buscarClientePorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        Cliente cliente = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = montarCliente(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    // Verificar login (email + senha)
    public Cliente autenticarCliente(String email, String senha) {
        String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return montarCliente(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Utilitário interno
    private Cliente montarCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setEmail(rs.getString("email"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setSenha(rs.getString("senha"));
        cliente.setTelefone(rs.getString("telefone"));
        return cliente;
    }
}
