package br.com.mesttra.sb.pojo;

public class ClientePfPOJO extends ClientePOJO {
    private final String cpf;
    private final String nome;
    private final int idade;

    public ClientePfPOJO(String conta, String agencia, String telefone, double saldo, double limite, String cpf, String nome, int idade) {
        super(conta, agencia, telefone, saldo, limite);
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public void exibirConta() {
        super.exibirConta();
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
