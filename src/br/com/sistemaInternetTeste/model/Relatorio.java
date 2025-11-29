
package br.com.sistemaInternetTeste.model;

import java.util.Date;

/**
 * Classe que recebe os atributos de um Relatorio
 *
 */
public class Relatorio {

    private int id;
    private String nomeVendedor;
    private double valorVenda;
    private Date dataVenda;

    public Relatorio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}
