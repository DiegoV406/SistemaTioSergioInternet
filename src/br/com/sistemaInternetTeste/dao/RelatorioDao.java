
package br.com.sistemaInternetTeste.dao;

import br.com.sistemaInternetTeste.config.Conexao;
import br.com.sistemaInternetTeste.model.Relatorio;
import br.com.sistemaInternetTeste.repository.RelatorioRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que recebe os metodos para fazer o crud da classe Relatorio
 *
 */
public class RelatorioDao implements RelatorioRepository{

    private final Conexao connection;

    public RelatorioDao(Conexao connection) {
        this.connection = connection;
    }

    /**
     * * Metodo para salvar arquivos no bancos de dados
     * @param relatorio Objeto da classe relatorio
     * @return Retorna erro se não foi possivel conectar ao banco de dados
     */
    @Override
    public int salvar(Relatorio relatorio) {
        final String sql = "INSERT INTO relatorio (nomeVendedor, valorVenda, data) VALUES (?, ?, ?)";

        try (Connection conn = connection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, relatorio.getNomeVendedor());
            st.setDouble(2, relatorio.getValorVenda());
            st.setDate(3, new java.sql.Date(relatorio.getDataVenda().getTime()));

            return st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar relatório: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para buscar valores no banco de dados
     * @return Retorna uma lista 
     */
    @Override
    public List<Relatorio> getRelatorio() {
        final String sql = "SELECT * FROM relatorio";

        try (Connection conn = connection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {

            List<Relatorio> lista = new ArrayList<>();

            while (rs.next()) {
                Relatorio relatorio = new Relatorio();
                relatorio.setId(rs.getInt("id"));
                relatorio.setNomeVendedor(rs.getString("nomeVendedor"));
                relatorio.setValorVenda(rs.getDouble("valorVenda"));
                relatorio.setDataVenda(rs.getDate("data"));

                lista.add(relatorio);
            }
            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar relatórios: " + e.getMessage(), e);
        }
    }
}
