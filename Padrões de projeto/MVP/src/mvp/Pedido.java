package mvp;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final String numero;
    private final ItemPedido carrinho;
    private final List<PedidoObserver> observers = new ArrayList<>();
    private PagamentoStrategy pagamentoStrategy;
    private String status = "Criado";

    public Pedido(String numero, ItemPedido carrinho) {
        this.numero = numero;
        this.carrinho = carrinho;
    }

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void adicionarObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    public void exibirResumo() {
        System.out.println("Resumo do pedido #" + numero);
        carrinho.exibir("  ");
        System.out.printf("Total: R$ %.2f%n", carrinho.getPreco());
    }

    public void confirmarPagamento() {
        if (pagamentoStrategy == null) {
            throw new IllegalStateException("Escolha uma forma de pagamento antes de finalizar.");
        }

        pagamentoStrategy.pagar(carrinho.getPreco());
        atualizarStatus("Pagamento confirmado");
    }

    public void atualizarStatus(String novoStatus) {
        status = novoStatus;
        System.out.printf("%nStatus do pedido #%s: %s%n", numero, status);
        notificarTodos();
    }

    private void notificarTodos() {
        for (PedidoObserver observer : observers) {
            observer.atualizar(numero, status);
        }
    }
}
