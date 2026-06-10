package mvp;

public class NotificacaoCliente implements PedidoObserver {
    private final String nome;

    public NotificacaoCliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("Cliente %s recebeu aviso do pedido #%s: %s%n", nome, numeroPedido, status);
    }
}
