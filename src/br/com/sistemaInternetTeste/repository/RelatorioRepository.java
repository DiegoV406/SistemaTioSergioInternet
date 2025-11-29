
package br.com.sistemaInternetTeste.repository;


import br.com.sistemaInternetTeste.model.Relatorio;
import java.util.List;

public interface RelatorioRepository {
    
    int salvar(Relatorio relatorio);
    List<Relatorio> getRelatorio();
}
