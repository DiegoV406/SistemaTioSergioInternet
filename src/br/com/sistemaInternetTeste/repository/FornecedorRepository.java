
package br.com.sistemaInternetTeste.repository;

import br.com.sistemaInternetTeste.model.Fornecedor;
import java.util.List;

public interface FornecedorRepository {

    int salvar(Fornecedor fornecedor);

    List<Fornecedor> getFornecedor();
}
