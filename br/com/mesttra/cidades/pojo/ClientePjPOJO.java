package br.com.mesttra.cidades.pojo;

public class ClientePjPOJO extends ClientePOJO {
    private final String cnpj;
    private final String razaoSocial;
    private final String nomeFantasia;

    public ClientePjPOJO(String conta, String agencia, String telefone, double saldo, double limite, boolean contaAtiva, String cnpj, String razaoSocial, String nomeFantasia) {
        super(conta, agencia, telefone, saldo, limite, contaAtiva);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public void exibirConta() {
        super.exibirConta();
        System.out.println("CNPJ: " + this.getCnpj());
        System.out.println("Razão Social: " + this.getRazaoSocial());
        System.out.println("Nome Fantasia: " + this.getNomeFantasia());
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}
