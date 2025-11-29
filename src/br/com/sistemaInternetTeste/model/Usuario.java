
package br.com.sistemaInternetTeste.model;

/**
 * Classe que recebe os atributos do objeto Usuario
 *
 */
public class Usuario {

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String setor;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return nome + ";" + login + ";" + senha + ";" + setor;

    }
}
