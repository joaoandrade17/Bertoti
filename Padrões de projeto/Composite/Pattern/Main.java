package pattern;

public class Main {
    public static void main(String[] args) {
        CategoriaProduto catalogo = new CategoriaProduto("Catálogo da Loja");

        CategoriaProduto eletronicos = new CategoriaProduto("Eletrônicos");
        CategoriaProduto roupas = new CategoriaProduto("Roupas");
        CategoriaProduto casa = new CategoriaProduto("Casa");

        eletronicos.adicionar(new Produto("Fone de Ouvido", 299.90));
        eletronicos.adicionar(new Produto("Smartphone", 1999.00));

        roupas.adicionar(new Produto("Camiseta", 79.90));
        roupas.adicionar(new Produto("Calça Jeans", 149.90));

        casa.adicionar(new Produto("Cafeteira", 259.90));
        casa.adicionar(new Produto("Jogo de Panelas", 349.90));

        catalogo.adicionar(eletronicos);
        catalogo.adicionar(roupas);
        catalogo.adicionar(casa);

        catalogo.exibir("");

        System.out.printf("%nValor total do catálogo: R$ %.2f%n", catalogo.getPreco());
    }
}
