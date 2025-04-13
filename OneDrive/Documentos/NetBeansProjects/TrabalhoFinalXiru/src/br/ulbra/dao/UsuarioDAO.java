package br.ulbra.dao;

import br.ulbra.config.ConnectionFactory;
import br.ulbra.entity.Produto;
import br.ulbra.entity.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public boolean verificarLoginSenha(String login, String password) {

        String sql = "SELECT * from TB_USERS where login = ? and password = ? ";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection connection = null;
        Boolean contemDados = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                contemDados = true;
            } else {
                contemDados = false;
            }

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("ERRO::OperBancoDados::verificarLoginSenha");
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return contemDados;
    }

    public void salvarUsuarioBD(Usuario novoUsuario) {

        Boolean sucesso = null;
        String sql = "insert into TB_USERS (USER_NAME, EMAIL, LOGIN, PASSWORD, FONE_USER, CPF_USER, CEP_USER, LOGRADOURO_USER, NUMERO_USER, BAIRRO_USER, CIDADE_USER, ESTADO_USER) values (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?)";
        PreparedStatement pst = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, novoUsuario.getNomeUsu());
            pst.setString(2, novoUsuario.getEmailUsu());
            pst.setString(3, novoUsuario.getLoginUsu());
            pst.setString(4, novoUsuario.getSenhaUsu());
            pst.setString(5, novoUsuario.getFoneUsu());
            pst.setString(6, novoUsuario.getCpfUsu());
            pst.setString(7, novoUsuario.getCepUsu());
            pst.setString(8, novoUsuario.getLogradouroUsu());
            pst.setString(9, novoUsuario.getNumeroUsu());
            pst.setString(10, novoUsuario.getBairroUsu());
            pst.setString(11, novoUsuario.getCidadeUsu());
            pst.setString(12, novoUsuario.getEstadoUsu());
            pst.executeUpdate();
            System.out.println("Registro inserido com sucesso no banco de dados!");
            sucesso = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Login ou email existente no banco de dados!");
            sucesso = false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO::GerenciadorBancoDados::salvarUsuarioBD");
            sucesso = false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT id_user, user_name, email, fone_user, cep_user FROM TB_USERS";  
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();  
            pst = connection.prepareStatement(sql); 
            rs = pst.executeQuery();  

            
            while (rs.next()) {
                int idUsuario = rs.getInt("ID_USER"); 
                String nomeP = rs.getString("USER_NAME");  
                String email = rs.getString("EMAIL");  
                String fone = rs.getString("FONE_USER");  
                String cep = rs.getString("CEP_USER");  

                Usuario user = new Usuario(idUsuario, fone, email, fone, cep);
                listaUsuarios.add(user);
                
                
            }

        } catch (Exception e) {
            e.printStackTrace();  // Exibe o erro no console, caso ocorra
            System.out.println("Erro ao selecionar os produtos do banco de dados.");
        } finally {
            // Fecha os recursos (PreparedStatement, Connection) para liberar memória
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listaUsuarios;  // Retorna a lista de produtos
    }
    
    
}
