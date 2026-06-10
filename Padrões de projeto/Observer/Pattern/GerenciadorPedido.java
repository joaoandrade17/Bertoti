package pattern;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedido {
    private String numeroPedido;
    private String status;
    private List<NotificacaoObserver> observers = new ArrayList<>();

    public GerenciadorPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void adicionarObserver(NotificacaoObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(NotificacaoObserver observer) {
        observers.remove(observer);
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        System.out.println("\n[Pedido #" + numeroPedido + "] Status atualizado para: " + novoStatus);
        notificarTodos();
    }

    private void notificarTodos() {
        for (NotificacaoObserver observer : observers) {
            observer.atualizar(numeroPedido, status);
        }
    }
}
