package br.ulbra.DAO;

import br.ulbra.model.Livro;
import br.ulbra.DAO.AbstractDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO extends AbstractDAO implements CrudRepository<Livro> {

    public void salvar(Livro l) throws SQLException {
        String sql = "INSERT INTO livro (titulo, autor, genero, status_leitura, progresso, nota, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getGenero());
            ps.setString(4, l.getStatus_leitura());
            ps.setInt(5, l.getProgresso());
            ps.setDouble(6, l.getNota());
            ps.setInt(7, l.getId_usuario());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    l.setId_livro(rs.getInt(1));
                }
            }
        }
    }

    // 🔹 Buscar livro pelo ID
    public Livro buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM livro WHERE id_livro = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Livro(
                            rs.getInt("id_livro"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getString("genero"),
                            rs.getString("status_leitura"),
                            rs.getInt("progresso"),
                            rs.getDouble("nota"),
                            rs.getInt("id_usuario")
                    );
                }
            }
        }
        return null;
    }

    public List<Livro> listarPorUsuarioEStatus(int idUsuario, String statusLeitura) throws SQLException {
        String sql = "SELECT * FROM livro WHERE id_usuario = ? AND status_leitura = ? ORDER BY titulo";
        List<Livro> lista = new ArrayList<>();

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ps.setString(2, statusLeitura);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Livro l = new Livro(
                            rs.getInt("id_livro"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getString("genero"),
                            rs.getString("status_leitura"),
                            rs.getInt("progresso"),
                            rs.getDouble("nota"),
                            rs.getInt("id_usuario")
                    );
                    lista.add(l);
                }
            }
        }
        return lista;
    }

    public List<Livro> listarPorStatus(String status, int idUsuario) throws SQLException {
        String sql = "SELECT * FROM livro WHERE status_leitura LIKE ? AND id_usuario = ? ORDER BY titulo";

        List<Livro> lista = new ArrayList<>();

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + status + "%");
            ps.setInt(2, idUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Livro l = new Livro();
                    l.setId_livro(rs.getInt("id_livro"));
                    l.setTitulo(rs.getString("titulo"));
                    l.setAutor(rs.getString("autor"));
                    l.setGenero(rs.getString("genero"));
                    l.setStatus_leitura(rs.getString("status_leitura"));
                    l.setProgresso(rs.getInt("progresso"));
                    l.setNota(rs.getDouble("nota"));
                    l.setId_usuario(rs.getInt("id_usuario"));
                    lista.add(l);
                }
            }
        }

        return lista;
    }

    public List<Livro> listarPorUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM livro WHERE id_usuario = ? ORDER BY titulo";
        List<Livro> lista = new ArrayList<>();

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Livro l = new Livro(
                            rs.getInt("id_livro"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getString("genero"),
                            rs.getString("status_leitura"),
                            rs.getInt("progresso"),
                            rs.getDouble("nota"),
                            rs.getInt("id_usuario")
                    );
                    lista.add(l);
                }
            }
        }
        return lista;
    }

    // 🔹 Atualizar livro existente
    public void atualizar(Livro l) throws SQLException {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, genero = ?, status_leitura = ?, progresso = ?, nota = ? WHERE id_livro = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getGenero());
            ps.setString(4, l.getStatus_leitura());
            ps.setInt(5, l.getProgresso());
            ps.setDouble(6, l.getNota());
            ps.setInt(7, l.getId_livro());

            ps.executeUpdate();
        }
    }

    // 🔹 Remover livro pelo ID
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM livro WHERE id_livro = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void removerPorUsuario(int idUsuario) throws SQLException {
        String sql = "DELETE FROM livro WHERE id_usuario = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        }
    }

    public List<Livro> listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
