
package br.com.sistemaInternetTeste.repository;


import br.com.sistemaInternetTeste.model.Vendas;

public interface VendasRepository {
    
    void adicionar(Vendas vendas);
    public double atualizarTotalGeral();
}
