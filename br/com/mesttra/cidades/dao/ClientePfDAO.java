package br.com.mesttra.cidades.dao;

import br.com.mesttra.cidades.connectionfactory.ConnectionFactory;
import br.com.mesttra.cidades.pojo.ClientePfPOJO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientePfDAO {
    private final Connection conn;

    public ClientePfDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public boolean cadastraCliente(ClientePfPOJO cliente) {
        String sql = "INSERT INTO public.cliente_pf (" +
                "conta, agencia, telefone, saldo, limite, cpf, nome, idade)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
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

    /*public boolean removeCliente(String conta) {
        String sql = "DELETE FROM clientespf WHERE conta = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, conta);
            stmt.execute();

            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao realizar remoção!");
            System.out.println(ex.getMessage());
        }

        return false;
    }*/
}
