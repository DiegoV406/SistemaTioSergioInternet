
package br.com.sistemaInternetTeste.dao;

import br.com.sistemaInternetTeste.config.Conexao;
import br.com.sistemaInternetTeste.model.Usuario;
import br.com.sistemaInternetTeste.repository.UsuarioRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsavel por receber os metodos que iram realizar o crud entre a
 * classe Usuario e o banco de dados
 *
 */
public class UsuarioDao implements UsuarioRepository{

    private final Conexao connectionFactory;

    public UsuarioDao(Conexao connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Metodo que salva valores na tabela filmes do banco de dados
     * @param usuario Objeto da classe Usuario
     * @return Retorna um erro se não for possivel conectar no banco de dados para salvar 
     */
    @Override
    public int salvar(Usuario usuario) {
        final String sql = "INSERT INTO usuario (nome, login, senha, setor) VALUES (?, ?, ?, ?)";

        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());  // Ideal: aplicar hash (BCrypt)
            stmt.setString(4, usuario.getSetor());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar usuário: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo que procura se existe determinado nome na tabela Usuario
     * @param nome Variével do tipo String para o nome
     * @return Retorna false se o valor não for encontrado
     */
    @Override
    public boolean existePorNome(String nome) {
        final String sql = "SELECT 1 FROM usuario WHERE nome = ? LIMIT 1";

        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar existência de usuário: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo para validar o login do usuario
     * @param login nome do usuario
     * @param senha senha do usuario
     * @return Retorna um usuario
     */
    @Override
    public Usuario validarLogin(String login, String senha) {
        final String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ? LIMIT 1";

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setSetor(rs.getString("setor"));

                    return usuario;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao validar login: " + e.getMessage(), e);
        }

        return null; 
    }
}
