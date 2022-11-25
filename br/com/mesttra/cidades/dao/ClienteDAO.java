package br.com.mesttra.cidades.dao;

import br.com.mesttra.cidades.connectionfactory.ConnectionFactory;
import br.com.mesttra.cidades.exceptions.ContaNaoEncontradaException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {
    private final Connection conn;

    public ClienteDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public Connection getConn() {
        return conn;
    }

    public boolean removeCliente(String sql, String conta) {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, conta);

            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao processar solicitação!");
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public String verificaCliente(String conta) {
        String sqlPf = "SELECT COUNT(*) FROM cliente_pf " +
                "WHERE CONTA = ?";
        String sqlPj = "SELECT COUNT(*) FROM cliente_pj " +
                "WHERE CONTA = ?";

        Boolean rs = executaQuery(conta, sqlPf);
        Boolean rs2 = executaQuery(conta, sqlPj);

        if (rs != null && rs) return "PF";
        if (rs2 != null && rs2) return "PJ";

        throw new ContaNaoEncontradaException("Conta não encontrada!");
    }

    public boolean executaUpdate(String sql, String conta, double valor) {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, valor);
            stmt.setString(2, conta);

            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao processar solicitação!");
            System.out.println(ex.getMessage());
        }

        return false;
    }

    private Boolean executaQuery(String conta, String sql) {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, conta);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("count") >= 1;
        } catch (Exception ex) {
            System.out.println("Erro ao processar solicitação!");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
