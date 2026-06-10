package pattern;

public class PagamentoBoleto implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.printf("Boleto gerado no valor de R$ %.2f. Prazo: 3 dias úteis.%n", valor);
    }
}
