package anti_pattern;

public class Main {
    public static void main(String[] args) {
        PedidoAntiPattern pedido1 = new PedidoAntiPattern(450.00, "pix", 1);
        pedido1.finalizarPedido();

        PedidoAntiPattern pedido2 = new PedidoAntiPattern(450.00, "cartao", 3);
        pedido2.finalizarPedido();

        PedidoAntiPattern pedido3 = new PedidoAntiPattern(450.00, "boleto", 1);
        pedido3.finalizarPedido();
    }
}
