package pattern;

import java.util.ArrayList;
import java.util.List;

// Composite: agrupa produtos e subcategorias em um catálogo de loja
public class CategoriaProduto implements ComponenteProduto {
    private String nome;
    private List<ComponenteProduto> filhos = new ArrayList<>();

    public CategoriaProduto(String nome) {
        this.nome = nome;
    }

    public void adicionar(ComponenteProduto componente) {
        filhos.add(componente);
    }

    public void remover(ComponenteProduto componente) {
        filhos.remove(componente);
    }

    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + "[" + nome + "]");
        for (ComponenteProduto filho : filhos) {
            filho.exibir(indentacao + "  ");
        }
    }

    @Override
    public double getPreco() {
        return filhos.stream().mapToDouble(ComponenteProduto::getPreco).sum();
    }
}
