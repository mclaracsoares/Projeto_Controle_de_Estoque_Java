import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {


    private String cpf;
    private String nome;
    private ArrayList<String> carrinho;

    public Cliente(String nome, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
        this.carrinho = new ArrayList<>(); 
    }

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

    public Produto buscarProdutoNoEstoque(String nomeProduto, Estoque estoque) {
        return estoque.buscarProduto(nomeProduto);
    }

    
    public void comprarProduto(Estoque estoque, Produto produto) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "s";
    
        while (continuar.equalsIgnoreCase("s")) {
            System.out.print("Digite o nome do produto que deseja comprar: ");
            String nomeProduto = scanner.nextLine();
    
            produto = buscarProdutoNoEstoque(nomeProduto, estoque); 
            if (produto != null) {
                if (produto.getQuantidade() > 0) {
                    System.out.println("Produto encontrado: ");
                    System.out.println(produto);
    
                    int quantidadeDesejada = 0;
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
    
                    if (quantidadeDesejada <= produto.getQuantidade()) {
                        System.out.print("Deseja adicionar ao carrinho? ");
                        String adicionarCarrinho = String.valueOf(scanner.nextLine().toLowerCase().charAt(0)); // tipo
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
    
        if (!carrinho.isEmpty()) {
            System.out.println("Produtos no carrinho:");
            for (String item : carrinho) {
                System.out.println(item);
            }
        } else {
            System.out.println("Carrinho vazio.");
        }
    }

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

    private static boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }
}
