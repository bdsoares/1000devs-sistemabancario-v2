package br.com.mesttra.cidades.dao;

import br.com.mesttra.cidades.connectionfactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {
    private final Connection conn;

    public ClienteDAO() {
        this.conn = new ConnectionFactory().getConnection();
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

    public Boolean verificaContaExistente(String conta) {
        String sqlPf = "SELECT COUNT(*) FROM cliente_pf " +
                "WHERE CONTA = ?";
        String sqlPj = "SELECT COUNT(*) FROM cliente_pj " +
                "WHERE CONTA = ?";

        Boolean rs = executaQuery(conta, sqlPf);
        Boolean rs2 = executaQuery(conta, sqlPj);
        if (rs != null && rs2 != null) return rs || rs2;

        return null;
    }

    public Integer buscaTipoConta(String conta) {
        String sqlPf = "SELECT COUNT(*) FROM cliente_pf " +
                "WHERE CONTA = ?";
        String sqlPj = "SELECT COUNT(*) FROM cliente_pj " +
                "WHERE CONTA = ?";

        Boolean rs = executaQuery(conta, sqlPf);
        Boolean rs2 = executaQuery(conta, sqlPj);

        if (rs != null && rs) return 1;    // Pessoa Fisica
        if (rs2 != null && rs2) return 2;  // Pessoa Juridica

        return null;    // Conta não encontrada.
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
