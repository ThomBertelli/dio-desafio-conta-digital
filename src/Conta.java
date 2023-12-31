public class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected Cliente titular;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.titular = cliente;
    }


    @Override
    public void sacar(double valor) {
        saldo -= valor;

    }

    @Override
    public void depositar(double valor) {

        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);

    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Titular: %s", this.titular.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Conta número: %d", this.numeroConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }


}
