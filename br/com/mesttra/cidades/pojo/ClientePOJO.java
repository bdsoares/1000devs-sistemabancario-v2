package br.com.mesttra.cidades.pojo;

public abstract class ClientePOJO {
    private final String conta;
    private final String agencia;
    private final String telefone;
    private double saldo;
    private double limite;
    private boolean contaAtiva;

    public ClientePOJO(String conta, String agencia, String telefone, double saldo, double limite, boolean contaAtiva) {
        this.conta = conta;
        this.agencia = agencia;
        this.telefone = telefone;
        this.saldo = saldo;
        this.limite = limite;
        this.contaAtiva = contaAtiva;
    }

    public void exibirConta() {
        System.out.println("Conta: " + getConta());
        System.out.println("Agencia: " + getAgencia());
        System.out.println("Telefone: " + getTelefone());
        System.out.printf("Saldo: R$%.2f\n", getSaldo());
        System.out.printf("Limite: R$%.2f\n", getLimite());
    }

    public String getConta() {
        return conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public boolean isContaAtiva() {
        return contaAtiva;
    }

    public void setContaAtiva(boolean contaAtiva) {
        this.contaAtiva = contaAtiva;
    }
}