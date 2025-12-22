
package br.com.sistemaInternetTeste.dao;

import br.com.sistemaInternetTeste.model.Vendas;
import br.com.sistemaInternetTeste.repository.VendasRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que recebe os metodos da classe Vendas
 *
 */
public class VendasDao implements VendasRepository {

    private static List<Vendas> listaVendas = new ArrayList<>();

    /**
     * Metodo resposavel por adicionar objetos em uma lista
     * @param venda Objeto da classe vendas
     */
    @Override
    public void adicionar(Vendas venda) {
        listaVendas.add(venda);
    }

    /**
     * Metodo responsavel por listar os objetos de uma lista
     * @return Retorna uma lista
     */
    
    public static List<Vendas> listar() {
        return listaVendas;
    }
    
    @Override
    public double atualizarTotalGeral() {
    double totalGeral = 0.0;

    for (Vendas venda : VendasDao.listar()) {
        totalGeral += venda.getValor() * venda.getQuantidade();
    }

    return totalGeral;
}
    
}

