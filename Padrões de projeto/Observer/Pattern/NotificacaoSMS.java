package pattern;

public class NotificacaoSMS implements NotificacaoObserver {
    private String telefone;

    public NotificacaoSMS(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("[SMS → %s] Pedido #%s: %s%n", telefone, numeroPedido, status);
    }
}
