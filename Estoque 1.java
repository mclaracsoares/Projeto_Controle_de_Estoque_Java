import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos;
    private ArrayList<String> historicoCompras;

    public Estoque() {
        produtos = new ArrayList<>();
        historicoCompras = new ArrayList<>();
    }
public void adicionarProduto(Produto produto) {
    if (verificarProdutoExistente(produto.getNome())) {
        System.out.println("Já existe um produto com esse nome no estoque.");
    } else {
        produtos.add(produto);
        System.out.println("Produto adicionado ao estoque.");
    }
}

private boolean verificarProdutoExistente(String nomeProduto) {
    for (Produto produto : produtos) {
        if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
            return true; // produto encontrado
        }
    }
    return false; // produto não encontrado
}

    public void removerProduto(String nomeProduto) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtos.remove(i);
                System.out.println("Produto removido do estoque.");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    public void consultarProduto(String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                System.out.println("Produto encontrado:");
                System.out.println(produto);
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    public void atualizarProduto(String nomeProduto, int novaQuantidade, double novoPreco) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produto.setQuantidade(novaQuantidade);
                produto.setPreco(novoPreco);
                System.out.println("Produto atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    public Produto buscarProduto(String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }

    public void registrarCompra(String compra) {
        historicoCompras.add(compra);
    }
    
    public ArrayList<Produto> getProdutos() { // retorna lista de produtos !!
        return produtos;
    }
}
