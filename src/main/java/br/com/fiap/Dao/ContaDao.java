package br.com.fiap.Dao;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {

    private Connection conexao;

    public ContaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public void insert(Conta conta) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_conta (cd_conta,nr_conta,tipo_conta,saldo,cd_usuario) VALUES (seq_conta.nextval, ?,?,?,?)");
        stm.setString(1, conta.getNrConta());
        stm.setString(2, conta.getTipoConta());
        stm.setDouble(3, conta.getSaldoConta());
        stm.setLong(4, conta.getCdUsuario());
        stm.executeUpdate();
    }

    public List<Conta> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_conta");
        ResultSet result = stm.executeQuery();
        List<Conta> lista = new ArrayList<>();
        while (result.next()){
            Long id = result.getLong("cd_conta");
            String nrConta = result.getString("nr_conta");
            String tpConta = result.getString("tipo_conta");
            double sdConta = result.getDouble("saldo");
            long cdUsuario = result.getInt("cd_usuario");
            lista.add(new Conta(id, nrConta,tpConta,sdConta, cdUsuario));
        }
        return lista;
    }

}
