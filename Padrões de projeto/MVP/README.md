# MVP - Delivery com 3 Padroes de Projeto

Este MVP simula um pedido de delivery usando os tres padroes do repositorio:

- **Composite**: `Produto` e `Combo` implementam `ItemPedido`, permitindo montar um carrinho com itens simples e combos aninhados.
- **Strategy**: `Pedido` usa `PagamentoStrategy` para alternar a forma de pagamento entre `PagamentoPix` e `PagamentoCartao`.
- **Observer**: `Pedido` notifica `NotificacaoCliente`, `PainelCozinha` e `AppEntregador` sempre que o status muda.

## UML integrada

```mermaid
classDiagram
    class ItemPedido {
        <<interface>>
        +exibir(String indentacao) void
        +getPreco() double
    }

    class Produto {
        -String nome
        -double preco
        +Produto(String nome, double preco)
        +exibir(String indentacao) void
        +getPreco() double
    }

    class Combo {
        -String nome
        -List~ItemPedido~ itens
        +Combo(String nome)
        +adicionar(ItemPedido item) void
        +exibir(String indentacao) void
        +getPreco() double
    }

    class PagamentoStrategy {
        <<interface>>
        +pagar(double valor) void
    }

    class PagamentoPix {
        +pagar(double valor) void
    }

    class PagamentoCartao {
        -int parcelas
        +PagamentoCartao(int parcelas)
        +pagar(double valor) void
    }

    class PedidoObserver {
        <<interface>>
        +atualizar(String numeroPedido, String status) void
    }

    class NotificacaoCliente {
        -String nome
        +NotificacaoCliente(String nome)
        +atualizar(String numeroPedido, String status) void
    }

    class PainelCozinha {
        +atualizar(String numeroPedido, String status) void
    }

    class AppEntregador {
        +atualizar(String numeroPedido, String status) void
    }

    class Pedido {
        -String numero
        -ItemPedido carrinho
        -List~PedidoObserver~ observers
        -PagamentoStrategy pagamentoStrategy
        -String status
        +Pedido(String numero, ItemPedido carrinho)
        +setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) void
        +adicionarObserver(PedidoObserver observer) void
        +exibirResumo() void
        +confirmarPagamento() void
        +atualizarStatus(String novoStatus) void
        -notificarTodos() void
    }

    ItemPedido <|.. Produto
    ItemPedido <|.. Combo
    Combo o-- "0..*" ItemPedido : itens

    PagamentoStrategy <|.. PagamentoPix
    PagamentoStrategy <|.. PagamentoCartao
    Pedido o-- PagamentoStrategy : pagamento

    PedidoObserver <|.. NotificacaoCliente
    PedidoObserver <|.. PainelCozinha
    PedidoObserver <|.. AppEntregador
    Pedido o-- "0..*" PedidoObserver : observers

    Pedido o-- ItemPedido : carrinho
```

## Compatibilidade com os padrões

| Padrao | Classes no MVP |
|--------|----------------|
| Composite | `ItemPedido`, `Produto`, `Combo` |
| Strategy | `PagamentoStrategy`, `PagamentoPix`, `PagamentoCartao`, `Pedido` |
| Observer | `PedidoObserver`, `NotificacaoCliente`, `PainelCozinha`, `AppEntregador`, `Pedido` |

## Como executar

Na pasta `MVP`:

```bash
javac -d out src/mvp/*.java
java -cp out mvp.Main
```

## Fluxo demonstrado

1. O carrinho e montado com produtos e um combo.
2. O pedido calcula o total usando a arvore do Composite.
3. A forma de pagamento e escolhida via Strategy.
4. Cada mudanca de status dispara notificacoes via Observer.
