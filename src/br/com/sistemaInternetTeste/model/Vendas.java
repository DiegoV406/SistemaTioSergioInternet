
package br.com.sistemaInternetTeste.model;

/**
 * Classe que recebe os atributos do objeto Vendas
 *
 */
public class Vendas {

    private String descricao;
    private int quantidade;
    private String data;
    private double valor;

    public Vendas() {
    }

    public Vendas(String descricao, int quantidade, String data, double valor) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.data = data;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}

