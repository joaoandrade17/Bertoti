package anti_pattern;

public class Main {
    public static void main(String[] args) {
        CategoriaProdutoAntiPattern eletronicos = new CategoriaProdutoAntiPattern("Eletrônicos");
        eletronicos.adicionarItem(new ProdutoAntiPattern("Fone de Ouvido", 299.90));
        eletronicos.adicionarItem(new ProdutoAntiPattern("Smartphone", 1999.00));

        CategoriaProdutoAntiPattern roupas = new CategoriaProdutoAntiPattern("Roupas");
        roupas.adicionarItem(new ProdutoAntiPattern("Camiseta", 79.90));
        roupas.adicionarItem(new ProdutoAntiPattern("Calça Jeans", 149.90));

        CategoriaProdutoAntiPattern casa = new CategoriaProdutoAntiPattern("Casa");
        casa.adicionarItem(new ProdutoAntiPattern("Cafeteira", 259.90));
        casa.adicionarItem(new ProdutoAntiPattern("Jogo de Panelas", 349.90));

        CategoriaProdutoAntiPattern catalogo = new CategoriaProdutoAntiPattern("Catálogo da Loja");
        catalogo.adicionarSubcategoria(eletronicos);
        catalogo.adicionarSubcategoria(roupas);
        catalogo.adicionarSubcategoria(casa);

        exibirCategoria(catalogo, "");
    }

    private static void exibirCategoria(CategoriaProdutoAntiPattern categoria, String indentacao) {
        System.out.println(indentacao + "[" + categoria.getNome() + "]");

        for (ProdutoAntiPattern item : categoria.getItens()) {
            System.out.printf("%s  - %s: R$ %.2f%n", indentacao, item.getNome(), item.getPreco());
        }

        for (CategoriaProdutoAntiPattern sub : categoria.getSubcategorias()) {
            exibirCategoria(sub, indentacao + "  ");
        }
    }
}
