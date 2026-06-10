package pattern;

public class NotificacaoEmail implements NotificacaoObserver {
    private String email;

    public NotificacaoEmail(String email) {
        this.email = email;
    }

    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("[EMAIL → %s] Pedido #%s: %s%n", email, numeroPedido, status);
    }
}
