package br.com.mesttra.cidades.dao;

import br.com.mesttra.cidades.connectionfactory.ConnectionFactory;
import br.com.mesttra.cidades.pojo.ClientePjPOJO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientePjDAO {
    private final Connection conn;

    public ClientePjDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public boolean cadastraCliente(ClientePjPOJO cliente) {
        String sql = "INSERT INTO public.cliente_pj(" +
                "conta, agencia, telefone, saldo, limite, cnpj, razao_social, nome_fantasia)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getConta());
            stmt.setString(2, cliente.getAgencia());
            stmt.setString(3, cliente.getTelefone());
            stmt.setDouble(4, cliente.getSaldo());
            stmt.setDouble(5, cliente.getLimite());
            stmt.setString(6, cliente.getCnpj());
            stmt.setString(7, cliente.getRazaoSocial());
            stmt.setString(8, cliente.getNomeFantasia());

            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao realizar inserção!");
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public boolean removeCliente(String conta) {
        ClienteDAO clienteDAO = new ClienteDAO();
        String sql = "DELETE FROM cliente_pj WHERE conta = ?";

        return clienteDAO.removeCliente(sql, conta);
    }
}
