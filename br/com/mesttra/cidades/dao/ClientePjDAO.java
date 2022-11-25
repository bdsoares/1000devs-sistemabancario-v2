package br.com.mesttra.cidades.dao;

import br.com.mesttra.cidades.pojo.ClientePfPOJO;
import br.com.mesttra.cidades.pojo.ClientePjPOJO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientePjDAO extends ClienteDAO {
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public ClientePjDAO() { }

    public boolean cadastraCliente(ClientePjPOJO cliente) {
        String sql = "INSERT INTO public.cliente_pj(" +
                "conta, agencia, telefone, saldo, limite, cnpj, razao_social, nome_fantasia)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = super.getConn().prepareStatement(sql)) {
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
        String sql = "DELETE FROM cliente_pj WHERE conta = ?";

        return clienteDAO.removeCliente(sql, conta);
    }

    public boolean ajustaLimite(String conta, double novoLimite) {
        String sql = "UPDATE cliente_pj SET limite = ? WHERE conta = ?";

        return clienteDAO.executaUpdate(sql, conta, novoLimite);
    }

    public boolean adicionaSaldo(String conta, double valor) {
        String sql = "UPDATE cliente_pj SET saldo = saldo + ? WHERE conta = ?";

        return clienteDAO.executaUpdate(sql, conta, valor);
    }

    public ClientePjPOJO consultaCliente (String conta) {
        String sql = "SELECT * FROM cliente_pj WHERE conta = ?";
        try (PreparedStatement stmt = clienteDAO.getConn().prepareStatement(sql)) {
            stmt.setString(1, conta);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new ClientePjPOJO(
                    rs.getString("conta"),
                    rs.getString("agencia"),
                    rs.getString("telefone"),
                    rs.getDouble("saldo"),
                    rs.getDouble("limite"),
                    rs.getString("cnpj"),
                    rs.getString("razao_social"),
                    rs.getString("nome_fantasia")
            );
        } catch (Exception ex) {
            System.out.println("Erro ao processar solicitação!");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
