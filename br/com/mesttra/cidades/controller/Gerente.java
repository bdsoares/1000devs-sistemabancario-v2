package br.com.mesttra.cidades.controller;

import br.com.mesttra.cidades.dao.ClienteDAO;
import br.com.mesttra.cidades.dao.ClientePfDAO;
import br.com.mesttra.cidades.dao.ClientePjDAO;
import br.com.mesttra.cidades.pojo.ClientePfPOJO;
import br.com.mesttra.cidades.pojo.ClientePjPOJO;

import java.util.Scanner;

public class Gerente {

    ClientePfDAO clientePfDAO = new ClientePfDAO();
    ClientePjDAO clientePjDAO = new ClientePjDAO();
    ClienteDAO clienteDAO = new ClienteDAO();

    public void cadastraCliente(Scanner in, int tipoCliente) {
        System.out.print("Número da conta: ");
        String conta = in.nextLine();

        if (clienteDAO.verificaCliente(conta) != null) {
            System.out.println("Número de conta já cadastrado, tente novamente!");
            return;
        }

        System.out.print("Agência: ");
        String agencia = in.nextLine();
        System.out.print("Telefone: ");
        String telefone = in.nextLine();
        System.out.print("Saldo: R$");
        double saldo = Double.parseDouble(in.nextLine());
        System.out.print("Limite: R$");
        double limite = Double.parseDouble(in.nextLine());

        if (tipoCliente == 1) {
            System.out.print("CPF: ");
            String cpf = in.nextLine();
            System.out.print("Nome: ");
            String nome = in.nextLine();
            System.out.print("Idade: ");
            short idade = Short.parseShort(in.nextLine());

            ClientePfPOJO novoCliente = new ClientePfPOJO(conta, agencia, telefone, saldo, limite, true, cpf, nome, idade);

            if(clientePfDAO.cadastraCliente(novoCliente))
                System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.print("CNPJ: ");
            String cnpj = in.nextLine();
            System.out.print("Razão social: ");
            String razaoSocial = in.nextLine();
            System.out.print("Razão fantasia: ");
            String nomeFantasia = in.nextLine();

            ClientePjPOJO novoCliente = new ClientePjPOJO(conta, agencia, telefone, saldo, limite, true, cnpj, razaoSocial, nomeFantasia);

            if(clientePjDAO.cadastraCliente(novoCliente))
                System.out.println("Cliente cadastrado com sucesso!");
        }
    }

    public void removeCliente(Scanner in) {
        String conta = solicitaConta(in);
        String tipoConta = clienteDAO.verificaCliente(conta);

        if (tipoConta.equals("PF") && clientePfDAO.removeCliente(conta))         // Pessoa Fisica.
            System.out.println("Conta PF Removida com Sucesso!");
        else if (tipoConta.equals("PJ") && clientePjDAO.removeCliente(conta))    // Pessoa Juridica.
            System.out.println("Conta PJ Removida com Sucesso!");
        else
            System.out.println("Conta não encontrada!");
    }

    public void ajustaLimite(Scanner in) {
        String conta = solicitaConta(in);
        String tipoConta = clienteDAO.verificaCliente(conta);

        System.out.print("Informe o novo limite: R$");
        double novoLimite = Double.parseDouble(in.nextLine());

        if (tipoConta.equals("PF") && clientePfDAO.ajustaLimite(conta, novoLimite))         // Pessoa Fisica.
            System.out.println("Limite Conta PF Ajustado com Sucesso!");
        else if (tipoConta.equals("PJ") && clientePjDAO.ajustaLimite(conta, novoLimite))    // Pessoa Juridica.
            System.out.println("Limite Conta PJ Ajustado com Sucesso!");
        else
            System.out.println("Conta não encontrada!");
    }

    public void adicionaSaldo(Scanner in) {
        String conta = solicitaConta(in);
        String tipoConta = clienteDAO.verificaCliente(conta);

        System.out.print("Informe o valor a ser adicionado: R$");
        double valor = Double.parseDouble(in.nextLine());

        if (tipoConta.equals("PF") && clientePfDAO.adicionaSaldo(conta, valor))         // Pessoa Fisica.
            System.out.println("Saldo Adicionado à Conta PF com Sucesso!");
        else if (tipoConta.equals("PJ") && clientePjDAO.adicionaSaldo(conta, valor))    // Pessoa Juridica.
            System.out.println("Saldo Adicionado à Conta PJ com Sucesso!");
        else
            System.out.println("Conta não encontrada!");
    }

    private String solicitaConta(Scanner in) {
        System.out.print("Informe o número da conta: ");
        return in.nextLine();
    }
}
