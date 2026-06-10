package pattern;

// Leaf: produto simples sem subitens
public class Produto implements ComponenteProduto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.printf("%s- %s: R$ %.2f%n", indentacao, nome, preco);
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
