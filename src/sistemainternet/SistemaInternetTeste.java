
package sistemainternet;

import br.com.sistemaInternetTeste.dao.UsuarioDao;
import br.com.sistemaInternetTeste.model.Usuario;
import br.com.sistemaInternetTeste.config.Conexao; 
import br.com.sistemaInternetTeste.dao.Criptografia;
import br.com.sistemaInternetTeste.dao.FornecedorDao;
import br.com.sistemaInternetTeste.dao.ProdutoDao;
import br.com.sistemaInternetTeste.dao.VendasDao;
import br.com.sistemaInternetTeste.model.Fornecedor;
import br.com.sistemaInternetTeste.model.Produto;
import br.com.sistemaInternetTeste.model.Vendas;

import java.util.Date;
import java.util.List;


public class SistemaInternetTeste {

    
    public static void main(String[] args) {
        
        // Cria a conexão e o DAO
        Conexao conexao = new Conexao();
        UsuarioDao usuarioDao = new UsuarioDao(conexao);

        // ===== TESTE 1: SALVAR USUÁRIO =====
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome("João da Silva");
        novoUsuario.setLogin("joao");
        novoUsuario.setSenha("123"); 
        novoUsuario.setSetor("Financeiro");

        int resultado = usuarioDao.salvar(novoUsuario);

        if (resultado > 0) {
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar.");
        }


        // ===== TESTE 2: VALIDAR LOGIN =====
        Usuario usuarioLogado = usuarioDao.validarLogin("joao", "123");

        if (usuarioLogado != null) {
            System.out.println("\n Login realizado!");
            System.out.println("Usuário logado: " + usuarioLogado.getNome());
            System.out.println("Setor: " + usuarioLogado.getSetor());
        } else {
            System.out.println("\n Login inválido!");
        }
        
        // Cria factory e DAO
        Conexao factory = new Conexao();
        FornecedorDao fornecedorDao = new FornecedorDao(factory);

        // ===== TESTE 3: CADASTRAR FORNECEDOR =====
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("Distribuidora São Paulo");
        fornecedor.setCnpj("12345678000199");
        fornecedor.setData(new Date()); // data atual

        int resultado2 = fornecedorDao.salvar(fornecedor);

        if (resultado2 > 0) {
            System.out.println("Fornecedor cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar fornecedor.");
        }


        // ===== TESTE 4: LISTAR FORNECEDORES =====
        List<Fornecedor> lista = fornecedorDao.getFornecedor();

        System.out.println("\n Lista de fornecedores cadastrados:");

        if (lista != null && !lista.isEmpty()) {
            lista.forEach(f -> {
                System.out.println("ID: " + f.getId() +
                        " | Nome: " + f.getNome() +
                        " | CNPJ: " + f.getCnpj() +
                        " | Data: " + f.getData()
                );
            });
        } else {
            System.out.println("Nenhum fornecedor encontrado.");
        }
        
        ProdutoDao dao = new ProdutoDao(new Conexao());

        // ===== TESTE 5: Criando um Produto =======
        Produto novo = new Produto();
        novo.setNome("Coca-Cola 2L");
        novo.setQuantidade(25);
        novo.setValor(8.99);
        novo.setData(new Date());
        novo.setNomeFornecedor("Coca-Cola Company");

        System.out.println(" Salvando produto no banco...");
        dao.salvar(novo);

        // ===== TESTE 6:Listando Todos os Produtos ========
        System.out.println("\n Produtos cadastrados:");
        List<Produto> listaProduto = dao.getProduto();
        listaProduto.forEach(p -> {
            System.out.println(p.getId() + " | " + 
                    p.getNome() + " | " + 
                    p.getQuantidade() + " | R$ " + 
                    p.getValor()
                    );
        });

        // ===== TESTE 7:Buscando produto por nome ======
        System.out.println("\n Valor do produto pesquisado:");
        Double valor = dao.buscarValorPorNome("Coca-Cola 2L");
        System.out.println("Valor encontrado: " + valor);

        // ===== TESTE 8:Buscando quantidade por nome ======
        System.out.println("\n Quantidade em estoque:");
        Integer qtd = dao.buscarQuantidadePorNome("Coca-Cola 2L");
        System.out.println("Quantidade atual: " + qtd);

        // ===== TESTE 9:Atualizar Estoque =====
        System.out.println("\n Atualizando estoque para 15 unidades...");
        dao.atualizarQuantidade(lista.get(lista.size()-1).getId(), 15);

        // ===== TESTE 10:Conferindo  Atualização ======
        System.out.println("\nEstoque atualizado:");
        System.out.println("Nova quantidade = " + dao.buscarQuantidadePorNome("Coca-Cola 2L"));

        
        VendasDao vendasDao = new VendasDao();

        // ===== TESTE 11:Criando objetos de vendas ======
        Vendas v1 = new Vendas("Mouse Gamer", 2, "26/11/2025", 159.90);
        Vendas v2 = new Vendas("Teclado Mecânico", 1, "26/11/2025", 309.99);
        Vendas v3 = new Vendas("Headset RGB", 3, "26/11/2025", 199.50);

        vendasDao.adicionar(v1);
        vendasDao.adicionar(v2);
        vendasDao.adicionar(v3);

        // ===== TESTE 12:Listando os registros adicionados =====
        System.out.println(" Lista de vendas registradas:\n");
        vendasDao.listar().forEach(venda -> {
            System.out.println("Descrição: " + venda.getDescricao());
            System.out.println("Quantidade: " + venda.getQuantidade());
            System.out.println("Data: " + venda.getData());
            System.out.printf("Valor: R$ %.2f", venda.getValor());
            System.out.println("\n-----------------------------------");
        });
        
        // ===== TESTE 13:Criptografando senha =====
        Criptografia criptografia = new Criptografia();

        String senha = "123456";
        String senhaCriptografada = criptografia.getMD5(senha);

        System.out.println("Senha original: " + senha);
        System.out.println("Senha criptografada (MD5): " + senhaCriptografada);
        
        System.out.println("\n Teste finalizado!");
    }
    
    
    
}
