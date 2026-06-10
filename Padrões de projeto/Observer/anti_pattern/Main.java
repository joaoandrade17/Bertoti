package anti_pattern;

public class Main {
    public static void main(String[] args) {
        GerenciadorPedidoAntiPattern pedido = new GerenciadorPedidoAntiPattern("20240001");

        pedido.configurarEmail("cliente@email.com");
        pedido.configurarSMS("(11) 99999-0000");
        pedido.configurarPush("iPhone de João");

        pedido.atualizarStatus("Pagamento confirmado");
        pedido.atualizarStatus("Saiu para entrega");
    }
}
