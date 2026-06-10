# Strategy Pattern - UML

## Diagrama de classes

```mermaid
classDiagram
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

    class PagamentoBoleto {
        +pagar(double valor) void
    }

    class Pedido {
        -double valor
        -PagamentoStrategy estrategiaPagamento
        +Pedido(double valor)
        +setEstrategiaPagamento(PagamentoStrategy estrategia) void
        +finalizarPedido() void
    }

    PagamentoStrategy <|.. PagamentoPix
    PagamentoStrategy <|.. PagamentoCartao
    PagamentoStrategy <|.. PagamentoBoleto
    Pedido o-- PagamentoStrategy : usa
```

## Compatibilidade com o padrão

| Elemento | Papel |
|----------|-------|
| `PagamentoStrategy` | Strategy |
| `PagamentoPix` | ConcreteStrategy |
| `PagamentoCartao` | ConcreteStrategy |
| `PagamentoBoleto` | ConcreteStrategy |
| `Pedido` | Context |

## Por que é um pattern?

- `Pedido` depende da interface `PagamentoStrategy`, não das classes concretas.
- A forma de pagamento pode ser trocada em tempo de execução.
- Novas formas de pagamento podem ser adicionadas criando novas classes, sem alterar `Pedido`.
- O diagrama é compatível com o código em `Strategy/pattern`.
