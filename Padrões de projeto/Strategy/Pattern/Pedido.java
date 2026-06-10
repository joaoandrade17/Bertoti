package pattern;

public class Pedido {
    private double valor;
    private PagamentoStrategy estrategiaPagamento;

    public Pedido(double valor) {
        this.valor = valor;
    }

    public void setEstrategiaPagamento(PagamentoStrategy estrategia) {
        this.estrategiaPagamento = estrategia;
    }

    public void finalizarPedido() {
        if (estrategiaPagamento == null) {
            throw new IllegalStateException("Nenhuma estratégia de pagamento definida!");
        }
        estrategiaPagamento.pagar(valor);
    }
}
