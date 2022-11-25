package br.com.mesttra.cidades.dao;

import br.com.mesttra.cidades.pojo.ClientePOJO;
import br.com.mesttra.cidades.pojo.ClientePfPOJO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public ClientePfPOJO consultaCliente (String conta) {

        String sql = "SELECT * FROM cliente_pf WHERE conta = ?";
        try (PreparedStatement stmt = clienteDAO.getConn().prepareStatement(sql)) {
            stmt.setString(1, conta);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new ClientePfPOJO(
                    rs.getString("conta"),
                    rs.getString("agencia"),
                    rs.getString("telefone"),
                    rs.getDouble("saldo"),
                    rs.getDouble("limite"),
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getInt("idade")
            );
        } catch (Exception ex) {
            System.out.println("Erro ao processar solicitação!");
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public double ConsultaTransferencia (String conta) {

        String sql = "SELECT * FROM cliente_pf WHERE conta = ?";
        String sql2 = "SELECT * FROM cliente_pf WHERE conta = ?";

        double saldo = clienteDAO.consultaSaldoLimite(sql, conta, "saldo");
        double limite = clienteDAO.consultaSaldoLimite(sql2, conta, "limite");

        double saldoTotal = saldo + limite;

        return saldoTotal;


    }

    public boolean transfere (String contaOrigem, double valor) {
        String sql = "UPDATE cliente_pf SET saldo = saldo - ? WHERE conta = ?";


        return clienteDAO.executaUpdate(sql, contaOrigem, valor);
    }

    public boolean recebe (String contaDestino, double valor) {
        String sql = "UPDATE cliente_pf SET saldo = saldo + ? WHERE conta = ?";


        return clienteDAO.executaUpdate(sql, contaDestino, valor);
    }



}
