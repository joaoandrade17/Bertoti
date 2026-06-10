package pattern;

public class PagamentoCartao implements PagamentoStrategy {
    private int parcelas;

    public PagamentoCartao(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public void pagar(double valor) {
        double valorParcela = valor / parcelas;
        System.out.printf("Pagamento de R$ %.2f via Cartão de Crédito em %d x R$ %.2f.%n",
                valor, parcelas, valorParcela);
    }
}
