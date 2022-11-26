package br.com.mesttra.sb.dao;

import br.com.mesttra.sb.pojo.ClientePjPOJO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientePjDAO extends ClienteDAO {
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public ClientePjDAO() {
    }

    public boolean cadastraCliente(ClientePjPOJO cliente) {
        String sql = "INSERT INTO public.cliente_pj(" +
                "conta, agencia, telefone, saldo, limite, conta_ativa, cnpj, razao_social, nome_fantasia)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = super.getConn().prepareStatement(sql)) {
            stmt.setString(1, cliente.getConta());
            stmt.setString(2, cliente.getAgencia());
            stmt.setString(3, cliente.getTelefone());
            stmt.setDouble(4, cliente.getSaldo());
            stmt.setDouble(5, cliente.getLimite());
            stmt.setBoolean(6, cliente.isContaAtiva());
            stmt.setString(7, cliente.getCnpj());
            stmt.setString(8, cliente.getRazaoSocial());
            stmt.setString(9, cliente.getNomeFantasia());

            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao realizar inserção!");
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public Boolean statusCliente(String conta, boolean status) {
        String sql = "UPDATE cliente_pj SET conta_ativa = ? WHERE conta = ?";

        return clienteDAO.executaUpdateBoolean(sql, conta, status);
    }

    public boolean ajustaLimite(String conta, double novoLimite) {
        String sql = "UPDATE cliente_pj SET limite = ? WHERE conta = ?";

        return clienteDAO.executaUpdateDouble(sql, conta, novoLimite);
    }

    public boolean adicionaSaldo(String conta, double valor) {
        String sql = "UPDATE cliente_pj SET saldo = saldo + ? WHERE conta = ?";

        return clienteDAO.executaUpdateDouble(sql, conta, valor);
    }

    public ClientePjPOJO consultaCliente(String conta, boolean booleano) {
        String sql = "SELECT * FROM cliente_pj WHERE conta = ? AND conta_ativa = ?";
        try (PreparedStatement stmt = clienteDAO.getConn().prepareStatement(sql)) {
            stmt.setString(1, conta);
            stmt.setBoolean(2, booleano);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new ClientePjPOJO(
                    rs.getString("conta"),
                    rs.getString("agencia"),
                    rs.getString("telefone"),
                    rs.getDouble("saldo"),
                    rs.getDouble("limite"),
                    rs.getBoolean("conta_ativa"),
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

    public double consultaTransferencia(String conta) {
        String sqlSaldo = "SELECT saldo FROM cliente_pj WHERE conta = ?";
        String sqlLimite = "SELECT limite FROM cliente_pj WHERE conta = ?";

        double saldo = clienteDAO.consultaSaldoLimite(sqlSaldo, conta, "saldo");
        double limite = clienteDAO.consultaSaldoLimite(sqlLimite, conta, "limite");

        return saldo + limite;
    }

    public boolean transfere(String contaOrigem, double valor) {
        String sql = "UPDATE cliente_pj SET saldo = saldo - ? WHERE conta = ?";

        return clienteDAO.executaUpdateDouble(sql, contaOrigem, valor);
    }

    public boolean recebe(String contaDestino, double valor) {
        String sql = "UPDATE cliente_pj SET saldo = saldo + ? WHERE conta = ?";

        return clienteDAO.executaUpdateDouble(sql, contaDestino, valor);
    }

    public ArrayList<ClientePjPOJO> listaCliente(boolean status) {
        String sql = "SELECT * FROM cliente_pj WHERE conta_ativa = ?";
        ArrayList<ClientePjPOJO> lista = new ArrayList<>();

        try (PreparedStatement stmt = clienteDAO.getConn().prepareStatement(sql)) {
            stmt.setBoolean(1, status);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new ClientePjPOJO(
                        rs.getString("conta"),
                        rs.getString("agencia"),
                        rs.getString("telefone"),
                        rs.getDouble("saldo"),
                        rs.getDouble("limite"),
                        rs.getBoolean("conta_ativa"),
                        rs.getString("cnpj"),
                        rs.getString("razao_social"),
                        rs.getString("nome_fantasia")
                ));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao processar solicitação!");
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    public Boolean restauraCliente(String conta) {
        String sql = "UPDATE cliente_pj SET conta_ativa = true WHERE conta = ?";

        return clienteDAO.executaUpdateBoolean(sql, conta, true);
    }
}
