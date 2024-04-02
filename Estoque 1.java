import java.util.ArrayList;

// Representa o estoque de produtos e mantém um registro de histórico de compras
public class Estoque {
    private ArrayList<Produto> produtos; // Lista de produtos no estoque
    private ArrayList<String> historicoCompras; // Registro de histórico de compras

    // Construtor da classe Estoque que inicializa
    public Estoque() {
        produtos = new ArrayList<>();
        historicoCompras = new ArrayList<>();
    }

    // Add um novo produto ao estoque
    public void adicionarProduto(Produto produto) {
        if (verificarProdutoExistente(produto.getNome())) {
            System.out.println("Já existe um produto com esse nome no estoque.");
        } else {
            produtos.add(produto);
            System.out.println("Produto adicionado ao estoque.");
        }
    }

    // Verificar se um produto já existe no estoque com base no nome (evitar duplicidade)
    private boolean verificarProdutoExistente(String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return true; // Produto encontrado
            }
        }
        return false; // Produto não encontrado
    }

    // Remoção de um produto do estoque pelo nome
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

    // Consultar um produto no estoque pelo nome
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

    // Atualizar a quantidade e o preço de um produto no estoque pelo nome
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

    // Buscar um produto no estoque pelo nome e retornar o Produto correspondente
    public Produto buscarProduto(String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto; // Retorna o produto encontrado
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }

    // Registrar uma compra no histórico de compras
    public void registrarCompra(String compra) {
        historicoCompras.add(compra);
    }
    
    // Obter a lista de produtos no estoque
    public ArrayList<Produto> getProdutos() {
        return produtos; // Retorna a lista de produtos
    }
}
