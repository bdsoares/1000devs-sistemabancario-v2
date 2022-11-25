package br.com.mesttra.cidades.dao;

import br.com.mesttra.cidades.pojo.ClientePfPOJO;

import java.sql.PreparedStatement;

public class ClientePfDAO extends ClienteDAO {
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public ClientePfDAO() { }

    public boolean cadastraCliente(ClientePfPOJO cliente) {
        String sql = "INSERT INTO public.cliente_pf (" +
                "conta, agencia, telefone, saldo, limite, cpf, nome, idade)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = super.getConn().prepareStatement(sql)) {
            stmt.setString(1, cliente.getConta());
            stmt.setString(2, cliente.getAgencia());
            stmt.setString(3, cliente.getTelefone());
            stmt.setDouble(4, cliente.getSaldo());
            stmt.setDouble(5, cliente.getLimite());
            stmt.setString(6, cliente.getCpf());
            stmt.setString(7, cliente.getNome());
            stmt.setInt(8, cliente.getIdade());

            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao realizar inserção!");
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public boolean removeCliente(String conta) {
        String sql = "DELETE FROM cliente_pf WHERE conta = ?";

        return clienteDAO.removeCliente(sql, conta);
    }

    public boolean ajustaLimite(String conta, double novoLimite) {
        String sql = "UPDATE cliente_pf SET limite = ? WHERE conta = ?";

        return clienteDAO.executaUpdate(sql, conta, novoLimite);
    }

    public boolean adicionaSaldo(String conta, double valor) {
        String sql = "UPDATE cliente_pf SET saldo = saldo + ? WHERE conta = ?";

        return clienteDAO.executaUpdate(sql, conta, valor);
    }
}
