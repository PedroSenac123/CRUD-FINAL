package br.ulbra.dao;

import br.ulbra.model.Usuario;
import br.ulbra.DAO.AbstractDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAO extends AbstractDAO implements CrudRepository<Usuario> {

    private String criptografarSenha(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public void salvar(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuario (nome, senha ) VALUES (?, ?)";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, u.getNome());
            ps.setString(2, criptografarSenha(u.getSenha())); // Hash seguro

            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Falha ao inserir usuário.");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    u.setId(rs.getInt(1));
                }
            }
        }
    }

    public Usuario buscarPorId(int id) throws SQLException {
        String sql = "SELECT id_usuario,nome, senha FROM usuario WHERE id_usuario = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("senha")
                    );
                }
            }
        }
        return null;
    }

    public List<Usuario> listar() throws SQLException {
        String sql = "SELECT id_usuario, nome FROM usuario ORDER BY nome";
        List<Usuario> lista = new ArrayList<>();

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome")
                );
                lista.add(u);
            }
        }
        return lista;
    }

    public void atualizar(Usuario u) throws SQLException {
        String sql = "UPDATE usuario SET nome = ? WHERE id_usuario = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getNome());
            ps.setInt(2, u.getId());

            ps.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    /**
     * Autentica um usuário pelo login e senha usando BCrypt
     */
    public Usuario autenticar(String nome, String senha) throws SQLException {
        String sql = "SELECT id_usuario, nome, senha FROM usuario WHERE nome = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hash = rs.getString("senha");
                    if (BCrypt.checkpw(senha, hash)) {
                        return new Usuario(
                                rs.getInt("id_usuario"),
                                rs.getString("nome"),
                                hash
                        );
                    }
                }
            }
        }
        return null;
    }

    /**
     * Verifica se já existe um usuário com o login informado
     */
    public boolean existeLogin(String nome) throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuario WHERE nome = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}
