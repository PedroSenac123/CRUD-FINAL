package br.ulbra.controller;

import br.ulbra.DAO.LivroDAO;
import br.ulbra.model.Livro;
import java.sql.SQLException;
import java.util.List;

public class LivroController {

    private LivroDAO dao = new LivroDAO();

    public void salvar(Livro l) throws SQLException {
        dao.salvar(l);
    }

    public Livro buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    public List<Livro> listarPorUsuario(int idUsuario) throws SQLException {
        return dao.listarPorUsuario(idUsuario);
    }
    
    public List<Livro> listarPorUsuarioEStatus(int idUsuario, String statusLeitura) throws SQLException {
        return dao.listarPorUsuarioEStatus(idUsuario, statusLeitura);
}
    public List<Livro> listarPorStatus(String status, int idUsuario) throws SQLException {
    return dao.listarPorStatus(status, idUsuario);
}

    public void atualizar(Livro l) throws SQLException {
        dao.atualizar(l);
    }

    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
}
