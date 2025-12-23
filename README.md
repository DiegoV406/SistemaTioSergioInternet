🔧 Sistema de Gestão - Autopeças Tio Sergio

📦 Sistema desenvolvido com arquitetura modular aplicando SOLID, boas práticas de refatoração e persistência com MySQL.
O projeto controla usuários, fornecedores, produtos, vendas e estoque, garantindo organização e facilidade de manutenção.

📌 Status do Projeto

🚧 Em evolução 
✅ Refatorado com SOLID e separação de camadas
🧪 Testes unitários implementados

🚀 Funcionalidades Principais

👤 Usuários

Cadastro e autenticação de usuários

Criptografia de senha via serviço de hashing

🏭 Fornecedores

Cadastro e listagem de fornecedores

Persistência com JDBC e Connection Factory (SRP + DIP)

📦 Produtos

Cadastro de novos produtos

Controle de estoque

Exclusão e atualização de itens

🛒 Vendas

Registro de vendas e histórico

Atualização de estoque automática

Repositório em memória com possibilidade de expansão para banco

🧪 Testes Unitários

O projeto conta com testes unitários utilizando JUnit 4, garantindo a confiabilidade das regras de negócio e facilitando a manutenção do código.

🎯 Objetivos dos Testes

Validar cálculos e regras de negócio

Garantir o correto funcionamento dos DAOs

Evitar regressões após refatorações

Facilitar futuras evoluções do sistema

🧩 Exemplo de Teste Implementado

Classe testada: VendasDao

Método: atualizarTotalGeral()

Cenário: Soma do valor total das vendas (valor × quantidade)

✔ O teste verifica se o total geral é calculado corretamente com base nas vendas cadastradas em memória.

🛠️ Ferramentas de Teste

JUnit 4

Projeto Ant (sem Maven)

Execução via NetBeans

🧠 Arquitetura e Padrões Aplicados

A estrutura do projeto agora segue princípios SOLID:

Princípio	Como foi aplicado
S – Responsabilidade Única	Cada classe com um único propósito (DAO, modelo, serviço, criptografia etc.)
O – Aberto/Fechado	Fácil expansão (ex.: criptografia MD5 → SHA256)
L – Substituição de Liskov	Interfaces para DAOs e serviços permitem troca sem impacto
I – Segregação de Interfaces	Repositórios específicos para cada entidade
D – Inversão de Dependência	Código depende de abstrações, não implementações concretas 

🔧 Tecnologias Utilizadas

Tecnologia	
☕ Java 17	Lógica principal do sistema
🗄️ MySQL	Persistência de dados
🔌 JDBC	Conexão e transações com banco
🖥️ Swing	Interface gráfica (GUI)
🔐 MD5 / Hash Interface	Criptografia com possibilidade de novos algoritmos
🧪 JUnit 4 / Testes unitários

📌 Observação

Este projeto foi criado com foco em organização, escalabilidade e manutenção, garantindo que novas funcionalidades possam ser adicionadas com facilidade.
Com a aplicação dos princípios SOLID e testes unitários, o código está mais limpo, reutilizável e preparado para evoluções futuras.

Feito com 💻 + ☕ por Diego Vieira

💬 Em constante evolução 🚀
