package anti_pattern;

import java.util.ArrayList;
import java.util.List;

public class CategoriaProdutoAntiPattern {
    private String nome;
    private List<ProdutoAntiPattern> itens = new ArrayList<>();
    private List<CategoriaProdutoAntiPattern> subcategorias = new ArrayList<>();

    public CategoriaProdutoAntiPattern(String nome) {
        this.nome = nome;
    }

    public void adicionarItem(ProdutoAntiPattern item) {
        itens.add(item);
    }

    public void adicionarSubcategoria(CategoriaProdutoAntiPattern subcategoria) {
        subcategorias.add(subcategoria);
    }

    public List<ProdutoAntiPattern> getItens() {
        return itens;
    }

    public List<CategoriaProdutoAntiPattern> getSubcategorias() {
        return subcategorias;
    }

    public String getNome() {
        return nome;
    }
}
