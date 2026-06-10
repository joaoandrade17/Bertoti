package anti_pattern;

public class GerenciadorPedidoAntiPattern {
    private String numeroPedido;
    private String status;

    private String emailDestinatario;
    private String telefoneDestinatario;
    private String dispositivoDestinatario;

    public GerenciadorPedidoAntiPattern(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void configurarEmail(String email) {
        this.emailDestinatario = email;
    }

    public void configurarSMS(String telefone) {
        this.telefoneDestinatario = telefone;
    }

    public void configurarPush(String dispositivo) {
        this.dispositivoDestinatario = dispositivo;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        System.out.println("\n[Pedido #" + numeroPedido + "] Status: " + novoStatus);

        if (emailDestinatario != null) {
            System.out.printf("[EMAIL → %s] Pedido #%s: %s%n",
                    emailDestinatario, numeroPedido, status);
        }
        if (telefoneDestinatario != null) {
            System.out.printf("[SMS → %s] Pedido #%s: %s%n",
                    telefoneDestinatario, numeroPedido, status);
        }
        if (dispositivoDestinatario != null) {
            System.out.printf("[PUSH → %s] Pedido #%s: %s%n",
                    dispositivoDestinatario, numeroPedido, status);
        }
    }
}
