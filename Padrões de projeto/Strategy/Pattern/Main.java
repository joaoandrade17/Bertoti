package pattern;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(450.00);

        // Pagando com PIX
        pedido.setEstrategiaPagamento(new PagamentoPix());
        pedido.finalizarPedido();

        // Mudando para Cartão em 3x
        pedido.setEstrategiaPagamento(new PagamentoCartao(3));
        pedido.finalizarPedido();

        // Mudando para Boleto
        pedido.setEstrategiaPagamento(new PagamentoBoleto());
        pedido.finalizarPedido();
    }
}
