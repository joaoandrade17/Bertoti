# Composite AntiPattern - UML

## Diagrama de classes

```mermaid
classDiagram
    direction LR

    class CategoriaProdutoAntiPattern {
        -String nome
        -List~ProdutoAntiPattern~ itens
        -List~CategoriaProdutoAntiPattern~ subcategorias
        +CategoriaProdutoAntiPattern(String nome)
        +adicionarItem(ProdutoAntiPattern item) void
        +adicionarSubcategoria(CategoriaProdutoAntiPattern subcategoria) void
        +getItens() List
        +getSubcategorias() List
        +getNome() String
    }

    class ProdutoAntiPattern {
        -String nome
        -double preco
        +ProdutoAntiPattern(String nome, double preco)
        +getNome() String
        +getPreco() double
    }

    CategoriaProdutoAntiPattern o-- "0..*" ProdutoAntiPattern : itens
```

## Compatibilidade com o anti-pattern

| Elemento | Papel |
|----------|-------|
| `CategoriaProdutoAntiPattern` | Classe que gerencia produtos e subcategorias separadamente |
| `ProdutoAntiPattern` | Classe de produto simples |
| `itens` | Lista exclusiva para produtos |
| `subcategorias` | Lista recursiva de outras categorias |

## Problemas

- Não existe interface comum entre produto e categoria.
- O cliente precisa chamar métodos diferentes para produtos e subcategorias.
- O código precisa saber se está lidando com `CategoriaProdutoAntiPattern` ou `ProdutoAntiPattern`.
- A hierarquia existe, mas não existe tratamento transparente como no Composite.

## Como corrigir?

Criar a interface `ComponenteProduto` e fazer tanto o produto quanto a categoria implementarem `exibir()` e `getPreco()`.
