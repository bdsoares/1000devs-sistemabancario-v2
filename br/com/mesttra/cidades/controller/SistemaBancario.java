package br.com.mesttra.cidades.controller;

import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Gerente gerente = new Gerente();

        int opcao = 0;
        do {
            try {
                opcao = mostraMenu(in);

                switch (opcao) {
                    case 1 -> {
                        opcao = mostraTipoContas(in);

                        if (opcao == 1 || opcao == 2)
                            gerente.cadastraCliente(in, opcao);
                        else if (opcao == 3)
                            System.out.println();
                        else
                            System.out.println("Opção inválida!");
                    }
                    case 2 -> gerente.removeCliente(in);
                    /*case 3 -> gerente.consultaCliente(in);
                    case 4 -> gerente.ajustaLimite(in);
                    case 5 -> gerente.tranfere(in);
                    case 6 -> gerente.adicionaSaldo(in);
                    case 7 -> gerente.relatorioClientes(true);
                    case 8 -> {
                        do {
                            opcao = mostraMenuRemovidos(in);

                            switch (opcao) {
                                case 1 -> gerente.relatorioClientes(false);
                                case 2 -> gerente.consultaCliente(in);
                                case 3 -> gerente.restauraCliente(in);
                                case 4 -> System.out.println();
                                default -> System.out.println("Opção inválida, por favor tente novamente!");
                            }
                        } while (opcao != 4);
                    }*/
                    case 10 -> System.out.println("Obrigado por utilizar o sistema, até logo!");
                    default -> System.out.println("Opção inválida, por favor tente novamente!");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (opcao != 10);
    }

    private static int mostraMenu(Scanner in) {
        System.out.println("# ===== Sistema Bancário ===== #");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Remover cliente");
        System.out.println("3. Consultar cliente");
        System.out.println("4. Ajustar limite");
        System.out.println("5. Realizar transferência");
        System.out.println("6. Adicionar saldo");
        System.out.println("7. Relatório de clientes");
        System.out.println("8. Clientes removidos");
        System.out.println("9. Empréstimos");
        System.out.println("10. Sair");
        System.out.println("# ============================ #");
        System.out.print("Insira uma opção: ");
        return Integer.parseInt(in.nextLine());
    }

    private static int mostraTipoContas(Scanner in) {
        System.out.println("# ===== Sistema Bancário ===== #");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.println("3. Cancelar");
        System.out.println("# ============================ #");
        System.out.print("Insira uma opção: ");
        return Integer.parseInt(in.nextLine());
    }

    private static int mostraMenuRemovidos(Scanner in) {
        System.out.println("# ===== Contas Removidas ===== #");
        System.out.println("1. Relatório de contas removidas");
        System.out.println("2. Consultar conta removida");
        System.out.println("3. Restaurar conta");
        System.out.println("4. Voltar");
        System.out.println("# ============================ #");
        System.out.print("Insira uma opção: ");
        return Integer.parseInt(in.nextLine());
    }
}