
package br.com.sistemaInternetTeste.repository;

import br.com.sistemaInternetTeste.model.Produto;
import java.util.List;

public interface ProdutoRepository {
    
    int salvar(Produto produto);
    List<Produto> getProduto();
    boolean excluir(int id);
    Double buscarValorPorNome(String nome);
    Integer buscarQuantidadePorNome(String nome);
    void atualizarQuantidade(int idProduto, int quantidade);
    
}
