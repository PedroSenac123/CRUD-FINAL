package br.ulbra.dao;

import br.ulbra.config.ConnectionFactory;
import br.ulbra.entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    private Connection con;

    public ProdutoDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public void SalvarProduto(Produto produto) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO TB_PRODUTOS (NOME_PRODUTO, CATEGORIA_PRODUTO, VALOR_PRODUTO, QTDE_ESTOQUE, DATA_CADASTRO) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, produto.getNomeProd());
            stmt.setString(2, produto.getCategoriaProd());
            stmt.setDouble(3, produto.getValorUnitProd());
            stmt.setInt(4, produto.getQuantidadeProd());
            stmt.setString(5, produto.getDataCadProd());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar produto: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        String sql = "SELECT * FROM TB_PRODUTOS";  // Query para pegar todos os produtos
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();  // Obtém a conexão com o banco de dados
            pst = connection.prepareStatement(sql);  // Prepara a consulta SQL
            rs = pst.executeQuery();  // Executa a consulta e retorna o resultado

            // Itera sobre o resultado e cria um objeto Produto para cada linha
            while (rs.next()) {
                int idProduto = rs.getInt("ID_PRODUTO");  // Recupera o ID do produto
                String nomeProduto = rs.getString("NOME_PRODUTO");  // Recupera o nome do produto
                String categoriaProduto = rs.getString("CATEGORIA_PRODUTO");  // Recupera a categoria
                double valorUnitario = rs.getDouble("VALOR_PRODUTO");  // Recupera o valor unitário
                int quantidadeEstoque = rs.getInt("QTDE_ESTOQUE");  // Recupera a quantidade no estoque
                String dataCadastro = rs.getString("DATA_CADASTRO");  // Recupera a data de cadastro

                // Criação do objeto Produto e adiciona à lista
                Produto produto = new Produto(idProduto, nomeProduto, dataCadastro, categoriaProduto, valorUnitario, quantidadeEstoque);
                listaProdutos.add(produto);  // Adiciona o produto à lista
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

        return listaProdutos;  // Retorna a lista de produtos
    }

    public Produto buscarProdutoPorId(int idProduto) throws SQLException {
        Produto produto = null;

        String sql = "SELECT * FROM TB_PRODUTOS WHERE ID_PRODUTO = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idProduto);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            produto = new Produto();
            produto.setIdProd(rs.getInt("ID_PRODUTO"));
            produto.setNomeProd(rs.getString("NOME_PRODUTO"));
            produto.setValorUnitProd(rs.getDouble("VALOR_PRODUTO"));
            produto.setQuantidadeProd(rs.getInt("QTDE_ESTOQUE"));

        }

        rs.close();
        stmt.close();

        return produto;
    }

    public List<Produto> pesquisarProduto(String nomeProduto) throws SQLException {
    List<Produto> listaProdutos = new ArrayList<>();

    // Conexão com o banco de dados
    Connection conn = ConnectionFactory.getConnection();
    
    // Query para pesquisar produtos que contém o nome no banco
    String sql = "SELECT * FROM tb_produtos WHERE nome_produto LIKE ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + nomeProduto + "%");  // Adiciona o '%' para busca parcial

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setIdProd(rs.getInt("ID_PRODUTO"));
            produto.setNomeProd(rs.getString("NOME_PRODUTO"));
            produto.setCategoriaProd(rs.getString("CATEGORIA_PRODUTO"));
            produto.setValorUnitProd(rs.getDouble("VALOR_PRODUTO"));
            produto.setQuantidadeProd(rs.getInt("QTDE_ESTOQUE"));
            produto.setDataCadProd(rs.getString("DATA_CADASTRO"));

            listaProdutos.add(produto);
        }
    } catch (SQLException e) {
        throw new SQLException("Erro ao pesquisar produtos: " + e.getMessage());
    }

    return listaProdutos;
}
    
}
