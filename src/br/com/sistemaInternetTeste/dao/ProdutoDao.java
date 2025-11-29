
package br.com.sistemaInternetTeste.dao;

import br.com.sistemaInternetTeste.config.Conexao;
import br.com.sistemaInternetTeste.model.Produto;
import br.com.sistemaInternetTeste.repository.ProdutoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que recebe os metodos para fazer o crud da classe Produto
 *
 */
public class ProdutoDao implements ProdutoRepository{

    private final Conexao connection;

    public ProdutoDao(Conexao connection) {
        this.connection = connection;
    }

    /**
     * Metodo que salva valores na tabela produto do banco de dados
     * @param produto Objeto da classe Produto
     * @return Retorna um erro se não for possivel conectar no banco de dados para salvar 
     */
    @Override
    public int salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, quantidade, valor, data, fornecedor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, produto.getNome());
            st.setInt(2, produto.getQuantidade());
            st.setDouble(3, produto.getValor());
            st.setDate(4, new java.sql.Date(produto.getData().getTime()));
            st.setString(5, produto.getNomeFornecedor());

            return st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para buscar valores no banco de dados
     * @return Retorna uma lista 
     */
    @Override
    public List<Produto> getProduto() {
        String sql = "SELECT * FROM produto";

        try (Connection conn = connection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {

            List<Produto> produtos = new ArrayList<>();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValor(rs.getDouble("valor"));
                produto.setData(rs.getDate("data"));
                produto.setNomeFornecedor(rs.getString("fornecedor"));

                produtos.add(produto);
            }
            return produtos;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo responsavel por excluir um valor do banco de dados pelo id
     * @param id Id do objeto a ser excluido
     * @return Retorna erro se não foi possivel excluir
     */
    @Override
    public boolean excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = connection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, id);
            return st.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo responsavel por buscar o valor do produto pelo nome
     * @param nome Nome do produto a ser buscado
     * @return Retorna o valor do produto
     */
    @Override
    public Double buscarValorPorNome(String nome) {
        String sql = "SELECT valor FROM produto WHERE nome = ? LIMIT 1";

        try (Connection conn = connection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, nome);
            ResultSet rs = st.executeQuery();

            return rs.next() ? rs.getDouble("valor") : null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar valor: " + e.getMessage(), e);
        }
    }

    /**
      * Metodo responsavel por buscar a quantidade do produto pelo nome
      * @param nome Nome do produto a ser buscado
      * @return Retorna a quantidade do produto
      */
    @Override
    public Integer buscarQuantidadePorNome(String nome) {
        String sql = "SELECT quantidade FROM produto WHERE nome = ? LIMIT 1";

        try (Connection conn = connection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, nome);
            ResultSet rs = st.executeQuery();

            return rs.next() ? rs.getInt("quantidade") : null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar quantidade: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo responsavel por atualizar a quantidade do produto no banco de dados
     * @param idProduto Id do produto a ser atualizado
     * @param novaQuantidade Novo valor 
     */
    @Override
    public void atualizarQuantidade(int idProduto, int novaQuantidade) {
        String sql = "UPDATE produto SET quantidade = ? WHERE id = ?";

        try (Connection conn = connection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, novaQuantidade);
            st.setInt(2, idProduto);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar quantidade: " + e.getMessage(), e);
        }
    }
}
