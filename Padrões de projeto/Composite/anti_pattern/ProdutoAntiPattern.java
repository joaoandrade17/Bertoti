package anti_pattern;

public class ProdutoAntiPattern {
    private String nome;
    private double preco;

    public ProdutoAntiPattern(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
