
package br.com.sistemaInternetTeste.model;

import java.util.Date;

/**
 * Classe que recebe os atributos de um objeto Fornecedor
 * 
 */
public class Fornecedor {

    private int id;
    private String nome;
    private String cnpj;
    private Date data;

    public Fornecedor() {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
