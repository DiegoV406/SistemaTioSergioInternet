
package br.com.sistemaInternetTeste.repository;

import br.com.sistemaInternetTeste.model.Usuario;

public interface UsuarioRepository {
    
    int salvar(Usuario usuario);

    boolean existePorNome(String nome);
    
    Usuario validarLogin(String login, String senha);
}
