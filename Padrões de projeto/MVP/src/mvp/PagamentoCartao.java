package mvp;

public class PagamentoCartao implements PagamentoStrategy {
    private final int parcelas;

    public PagamentoCartao(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public void pagar(double valor) {
        double valorParcela = valor / parcelas;
        System.out.printf("Pagamento no cartão aprovado: %dx de R$ %.2f%n", parcelas, valorParcela);
    }
}
