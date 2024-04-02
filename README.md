# projeto: Sistema de Gerenciamento de Estoque e Compras

# Me chamo Maria Clara C. Soares e fui a autora do código.

Esse repositório irá conter um código que abrange um sistema de estoques na linguagem Java.

O sistema permite que um funcionario da loja cadastre o cliente, o auxilie nas compras, visualize o estoque de produtos disponíveis e mantenham um carrinho de compras virtual, acessar as informações pessoais do cliente logado e realizar operações de compra de produtos disponíveis no estoque.

**Funcionalidades**

Login dos Clientes:

· Clientes previamente cadastrados podem ser autenticados no sistema, fornecendo seu nome e CPF.
· Novos clientes podem se cadastrar, fornecendo nome e CPF, ou podem entrar como visitantes sem cadastro.


*Requisitos:*

**Minimos:**

· Implementar um menu interativo para o usuário escolher entre adicionar, remover, consultar e atualizar produtos no estoque.

· Utilizar um array para armazenar informações sobre os produtos (nome, quantidade, preço, etc.).

· Tratar situações como a remoção de produtos que não estão no estoque.

**Adicionais:**

· Acesso a um menu principal que oferece as opções mínimas e, comprar produtos, visualizar o carrinho de compras, dados pessoais do cliente da vez, saldo total das compras realizadas e ver todos os produtos no estoque.

· Pode-se comprar produtos disponíveis no estoque, adicionando-os ao carrinho de compras e especificando a quantidade desejada de cada produto e visualizar o preço total da compra.
Carrinho de Compras:

· Pode-se visualizar os produtos que adicionaram ao carrinho durante a sessão de compras, escolhendo a cada item se deseja continuar comprando ou finalizar a compra.

**Validações:**

· Valida o CPF fornecido pelos clientes para garantir que ele tenha o formato correto de 11 dígitos.
· Verifica se a opção selecionada nos menus de login e principal é válida, fornecendo uma mensagem de erro para opções inválidas.
· Verifica se a quantidade desejada de um produto está disponível no estoque antes de adicionar ao carrinho. Se não estiver disponível, o programa informa ao cliente e oferece a opção de adicionar a quantidade disponível.
· Ao comprar um produto, o programa verifica se a quantidade especificada pelo cliente é um número inteiro positivo.
· Calcula o preço total da compra com base na quantidade de produtos selecionados.
· No menu de encerramento da compra, o programa solicita ao cliente se deseja continuar com outro usuário.
· Em perguntas de Sim/Não para o usuario, o programa aceita qualquer formato de resposta (s/S/Sim/SIM/SiMm...n/N/não/NAO/NaOoo...).

*Estrutura do Código*

**Classe Main:**
Responsável por iniciar o sistema e exibir os menus de login e principal.

**Classe Estoque:**
Gerencia o estoque de produtos, permitindo adicionar, remover, consultar, atualizar e buscar produtos.

**Classe Cliente:**
Representa os clientes do sistema, fornecendo métodos para login, cadastro, compra de produtos e manipulação do carrinho de compras.

**Classe Produto:**
Representa os produtos disponíveis no estoque, com atributos de nome, quantidade e preço.
