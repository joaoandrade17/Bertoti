package pattern;

public class Main {
    public static void main(String[] args) {
        GerenciadorPedido pedido = new GerenciadorPedido("20240001");

        // Cadastrando os observers
        pedido.adicionarObserver(new NotificacaoEmail("cliente@email.com"));
        pedido.adicionarObserver(new NotificacaoSMS("(11) 99999-0000"));
        pedido.adicionarObserver(new NotificacaoPush("iPhone de João"));

        // Mudanças de status disparam notificações automaticamente
        pedido.atualizarStatus("Pagamento confirmado");
        pedido.atualizarStatus("Em separação no estoque");
        pedido.atualizarStatus("Saiu para entrega");
    }
}
