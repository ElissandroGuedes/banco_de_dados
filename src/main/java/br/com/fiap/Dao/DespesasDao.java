package br.com.fiap.Dao;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Despesas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DespesasDao {
    private Connection conexao;

    public DespesasDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public void insert(Despesas despesas) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_despesas (cd_despesa, descricao, valor, dt_vencimento, categoria, cd_conta, cd_usuario) VALUES (seq_despesas.nextval, ?,?,?,?,?,?)");
        stm.setString(1,despesas.getDescricao());
        stm.setDouble(2,despesas.getValor());
        stm.setDate(3, java.sql.Date.valueOf(despesas.getDtVencimento()));
        stm.setString(4, despesas.getCategoria());
        stm.setLong(5,despesas.getCdConta());
        stm.setLong(6,despesas.getCdUsuario());
        stm.executeUpdate();
    }


    public List<Despesas> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_despesas");
        ResultSet result = stm.executeQuery();
        List<Despesas> lista = new ArrayList<>();
        while (result.next()){
            Long id = result.getLong("cd_despesa");
            String desc = result.getString("descricao");
            double vlr = result.getDouble("valor");
            LocalDate dtVenc = result.getDate("dt_vencimento").toLocalDate();
            String ctg = result.getString("categoria");
            Long cdCt = result.getLong("cd_conta");
            Long cdUs = result.getLong("cd_usuario");

           lista.add(new Despesas(id,desc,vlr,dtVenc,ctg,cdCt,cdUs));
        }
        return lista;
    }
}
