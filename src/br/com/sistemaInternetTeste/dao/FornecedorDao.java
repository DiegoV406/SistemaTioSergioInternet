
package br.com.sistemaInternetTeste.dao;

import br.com.sistemaInternetTeste.config.Conexao;
import br.com.sistemaInternetTeste.model.Fornecedor;
import br.com.sistemaInternetTeste.repository.FornecedorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe que recebe os metodos para fazer o crud da classe Fornecedor
 *
 */
public class FornecedorDao implements FornecedorRepository {

    private final Conexao connection;

    public FornecedorDao(Conexao connection) {
        this.connection= connection;
    }

    /** 
     * Metodo para salvar arquivos no bancos de dados 
     *
     * @param fornecedor Objeto da classe Fornecedor 
     * @return Retorna erro se não foi possivel conectar ao banco de dados 
     */
    @Override
    public int salvar(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (nome, cnpj, data) VALUES (?, ?, ?)";

        try (Connection conn = connection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, fornecedor.getNome());
            st.setString(2, fornecedor.getCnpj());
            st.setDate(3, new java.sql.Date(fornecedor.getData().getTime()));

            return st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar fornecedor: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para buscar valores no banco de dados
     *
     * @return Retorna uma lista
     */
    @Override
    public List<Fornecedor> getFornecedor() {
        String sql = "SELECT * FROM fornecedor";

        try (Connection conn = connection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {

            List<Fornecedor> listaFornecedor = new ArrayList<>();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setData(rs.getDate("data"));

                listaFornecedor.add(fornecedor);
            }
            return listaFornecedor;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar fornecedores: " + e.getMessage(), e);
        }
    }
}
