package br.com.mesttra.sb.pojo;

public class ClientePjPOJO extends ClientePOJO {
    private final String cnpj;
    private final String razaoSocial;
    private final String nomeFantasia;

    public ClientePjPOJO(String conta, String agencia, String telefone, double saldo, double limite, String cnpj, String razaoSocial, String nomeFantasia) {
        super(conta, agencia, telefone, saldo, limite);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public void exibirConta() {
        System.out.println("# ===== Cliente PJ ===== #");
        super.exibirConta();
        System.out.println("CNPJ: " + this.getCnpj());
        System.out.println("Razão Social: " + this.getRazaoSocial());
        System.out.println("Nome Fantasia: " + this.getNomeFantasia());
        System.out.println("# ====================== #");
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
