package anti_pattern;

public class PedidoAntiPattern {
    private double valor;
    private String tipoPagamento;
    private int parcelas;

    public PedidoAntiPattern(double valor, String tipoPagamento, int parcelas) {
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.parcelas = parcelas;
    }

    public void finalizarPedido() {
        if (tipoPagamento.equals("pix")) {
            System.out.printf("Pagamento de R$ %.2f realizado via PIX.%n", valor);

        } else if (tipoPagamento.equals("cartao")) {
            double valorParcela = valor / parcelas;
            System.out.printf("Pagamento de R$ %.2f via Cartão em %d x R$ %.2f.%n",
                    valor, parcelas, valorParcela);

        } else if (tipoPagamento.equals("boleto")) {
            System.out.printf("Boleto gerado no valor de R$ %.2f. Prazo: 3 dias úteis.%n", valor);
        }
    }
}
