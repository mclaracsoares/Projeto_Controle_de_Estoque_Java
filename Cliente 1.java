import java.util.ArrayList;
import java.util.Scanner;

// Representa o cliente com nome, CPF e o carrinho de compras
public class Cliente {
    private String cpf; // CPF
    private String nome; // Nome
    private ArrayList<String> carrinho; // Carrinho de compras

    // Construtor da classe Cliente que inicializa-a
    public Cliente(String nome, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
        this.carrinho = new ArrayList<>(); // Inicializa o carrinho de compras como uma lista vazia
    }

    // Métodos getters e setters para acessar e modificar os atributos do cliente

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getCarrinho() {
        return carrinho;
    }

    // Buscar um produto no estoque pelo nome
    public Produto buscarProdutoNoEstoque(String nomeProduto, Estoque estoque) {
        return estoque.buscarProduto(nomeProduto);
    }

    // Permitir que o cliente compre produtos do estoque
    public void comprarProduto(Estoque estoque, Produto produto) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "s";

        // Loop para permitir que o cliente compre vários produtos
        while (continuar.equalsIgnoreCase("s")) {
            System.out.print("Digite o nome do produto que deseja comprar: ");
            String nomeProduto = scanner.nextLine();

            produto = buscarProdutoNoEstoque(nomeProduto, estoque); // Busca o produto no estoque
            if (produto != null) {
                if (produto.getQuantidade() > 0) { // Verifica se o produto está disponível no estoque
                    System.out.println("Produto encontrado: ");
                    System.out.println(produto);

                    int quantidadeDesejada = 0;
                    // Loop para garantir que a quantidade inserida seja um número inteiro positivo
                    while (quantidadeDesejada <= 0) {
                        System.out.print("Digite a quantidade desejada: ");
                        if (scanner.hasNextInt()) {
                            quantidadeDesejada = scanner.nextInt();
                            scanner.nextLine();
                            if (quantidadeDesejada <= 0) {
                                System.out.println("Quantidade inválida. Digite um número inteiro positivo.");
                            }
                        } else {
                            System.out.println("Quantidade inválida. Digite um número inteiro positivo.");
                            scanner.next();
                        }
                    }

                    double precoTotal = quantidadeDesejada * produto.getPreco();
                    System.out.printf("Preço total: R$%.2f%n", precoTotal);

                    // Verifica se a quantidade desejada está disponível no estoque
                    if (quantidadeDesejada <= produto.getQuantidade()) {
                        System.out.print("Deseja adicionar ao carrinho? ");
                        String adicionarCarrinho = String.valueOf(scanner.nextLine().toLowerCase().charAt(0));
                        if (adicionarCarrinho.equals("s")) {
                            carrinho.add(nomeProduto + " (Quantidade: " + quantidadeDesejada + ")");
                            produto.setQuantidade(produto.getQuantidade() - quantidadeDesejada);
                            System.out.println("Produto adicionado ao carrinho.");
                        }
                    } else {
                        System.out.println("Quantidade não disponível, existem apenas " + produto.getQuantidade() + " produtos.");
                        System.out.print("Deseja adicionar mesmo assim? ");
                        String adicionarMesmoAssim = String.valueOf(scanner.nextLine().toLowerCase().charAt(0));
                        if (adicionarMesmoAssim.equals("s")) {
                            carrinho.add(nomeProduto + " (Quantidade: " + produto.getQuantidade() + ")");
                            produto.setQuantidade(0);
                            System.out.println("Produto adicionado ao carrinho com a quantidade disponível.");
                        }
                    }
                } else {
                    System.out.println("Produto esgotado");
                }
            } else {
                System.out.println("Produto não encontrado no estoque.");
            }

            System.out.print("Deseja continuar comprando? ");
            continuar = String.valueOf(scanner.nextLine().toLowerCase().charAt(0));
        }

        // Mostra os produtos no carrinho após a conclusão das compras
        if (!carrinho.isEmpty()) {
            System.out.println("Produtos no carrinho:");
            for (String item : carrinho) {
                System.out.println(item);
            }
        } else {
            System.out.println("Carrinho vazio.");
        }
    }

    // Mostrar os produtos no carrinho
    public void mostrarCarrinho() {
        if (!carrinho.isEmpty()) {
            System.out.println("Produtos no carrinho:");
            for (String item : carrinho) {
                System.out.println(item);
            }
        } else {
            System.out.println("Carrinho vazio.");
        }
    }

    // Validar o CPF
    private static boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }
}
