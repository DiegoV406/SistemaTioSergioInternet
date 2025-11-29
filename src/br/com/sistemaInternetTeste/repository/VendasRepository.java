
package br.com.sistemaInternetTeste.repository;


import br.com.sistemaInternetTeste.model.Vendas;
import java.util.List;

public interface VendasRepository {
    
    void adicionar(Vendas vendas);
    List<Vendas> listar();
}
