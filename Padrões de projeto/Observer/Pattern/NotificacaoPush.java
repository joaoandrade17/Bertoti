package pattern;

public class NotificacaoPush implements NotificacaoObserver {
    private String dispositivo;

    public NotificacaoPush(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("[PUSH → %s] Pedido #%s: %s%n", dispositivo, numeroPedido, status);
    }
}
