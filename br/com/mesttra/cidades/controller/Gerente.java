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

        if (clienteDAO.verificaContaExistente(conta) || clienteDAO.verificaContaExistente(conta) == null) {
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
        System.out.print("Informe o número da conta: ");
        String conta = in.nextLine();

        Integer tipoConta = clienteDAO.buscaTipoConta(conta);

        if (tipoConta == 1 && clientePfDAO.removeCliente(conta))         // Pessoa Fisica.
            System.out.println("Conta PF Removida com Sucesso!");
        else if (tipoConta == 2 && clientePjDAO.removeCliente(conta))    // Pessoa Juridica.
            System.out.println("Conta PJ Removida com Sucesso!");
        else
            System.out.println("Conta não encontrada!");
    }
}