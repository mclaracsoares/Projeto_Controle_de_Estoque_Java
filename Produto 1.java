import java.util.ArrayList;
import java.util.Scanner;

// Representa um produto com nome, quantidade e preço.
class Produto {
    private String nome; // Nome do produto
    private int quantidade; // Quantidade 
    private double preco; // Preço 

    // Construtor da classe Produto
    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e setters para acessar e modificar os atributos do produto

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Retorna uma representação textual do objeto Produto
    @Override
    public String toString() {
        return "Nome: " + nome + ", Quantidade: " + quantidade + ", Preço: R$" + preco;
    }
}
