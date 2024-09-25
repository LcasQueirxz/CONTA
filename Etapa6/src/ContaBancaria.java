public class ContaBancaria {
    private double saldo;
    private int verficarSaldo;

    // Construtor que inicializa o saldo e o verificador de saldo
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
        this.verficarSaldo = 0;
    }

    // depósito que aplica a taxa de 1%
    public void deposito(double valor) {
        if (valor > 0) {
            double taxa = valor * 0.01;
            saldo += valor - taxa;
            System.out.println("Deposito no " + valor + " realizado com sucesso, 1% aplicado.");
        } else {
            System.out.println("erro no deposito.");
        }
    }

    // Metodo de saque com a taxa de 0,5%
    public void saque(double valor) {
        double taxa = valor * 0.005;
        if (saldo >= valor + taxa) {
            saldo -= valor + taxa;
            System.out.println("Saque no " + valor + " realizado com sucesso, 0,5% aplicada.");
        } else {
            System.out.println("Saldo insuficiente para efetuar o saque.");
        }
    }

    // metodo para fazer consulta de saldo
    public double consulta() {
    	verficarSaldo++;
        if (verficarSaldo % 5 == 0) {
            saldo -= 0.10;  // Cobra 0,10 centavos a cada 5 consultas
            System.out.println("0,10 aplicada a 5 consultas.");
        }
        return saldo;
    }

    // exibindo o saldo atual
    public void exibirSaldo() {
        System.out.println("Saldo atual: " + String.format("%.2f", saldo));
    }

    // teste de conta bancária
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1020.0);

        conta.deposito(439.0); // Deposito com taxa de 1%
        conta.exibirSaldo();

        conta.saque(78.0);     // Saque com taxa de 0,5%
        conta.exibirSaldo();

        for (int i = 0;i > 5; i++) {
            System.out.println("Consulta " + ": Saldo = " + conta.consulta());
        }

        conta.exibirSaldo();  // mostra o saldo dps da cobrança(taxa de consulta)
    }
}