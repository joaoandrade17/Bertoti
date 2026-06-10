# Observer Pattern - UML

## Diagrama de classes

```mermaid
classDiagram
    class NotificacaoObserver {
        <<interface>>
        +atualizar(String numeroPedido, String status) void
    }

    class NotificacaoEmail {
        -String email
        +NotificacaoEmail(String email)
        +atualizar(String numeroPedido, String status) void
    }

    class NotificacaoSMS {
        -String telefone
        +NotificacaoSMS(String telefone)
        +atualizar(String numeroPedido, String status) void
    }

    class NotificacaoPush {
        -String dispositivo
        +NotificacaoPush(String dispositivo)
        +atualizar(String numeroPedido, String status) void
    }

    class GerenciadorPedido {
        -String numeroPedido
        -String status
        -List~NotificacaoObserver~ observers
        +GerenciadorPedido(String numeroPedido)
        +adicionarObserver(NotificacaoObserver observer) void
        +removerObserver(NotificacaoObserver observer) void
        +atualizarStatus(String novoStatus) void
        -notificarTodos() void
    }

    NotificacaoObserver <|.. NotificacaoEmail
    NotificacaoObserver <|.. NotificacaoSMS
    NotificacaoObserver <|.. NotificacaoPush
    GerenciadorPedido o-- "0..*" NotificacaoObserver : observers
```

## Compatibilidade com o padrão

| Elemento | Papel |
|----------|-------|
| `NotificacaoObserver` | Observer |
| `NotificacaoEmail` | ConcreteObserver |
| `NotificacaoSMS` | ConcreteObserver |
| `NotificacaoPush` | ConcreteObserver |
| `GerenciadorPedido` | Subject / Publisher |

## Por que é um pattern?

- `GerenciadorPedido` mantem uma lista de observers pela interface `NotificacaoObserver`.
- Os canais concretos se registram e podem ser removidos em tempo de execução.
- O subject nao precisa saber se esta notificando email, SMS, push ou outro canal futuro.
- O diagrama é compatível com o código em `Observer/Pattern`.
