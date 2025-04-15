package br.com.fiap.Dao;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Receita;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDao {

    private Connection conexao;

    public ReceitaDao() throws SQLException{
        conexao = ConnectionFactory.getConnection();
    }

    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public void insert(Receita receita) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_receita (cd_receita, descricao, valor,dt_recebimento,categoria,cd_conta,cd_usuario) VALUES (seq_receita.nextval, ?,?,?,?,?,?)");
        stm.setString(1,receita.getDescricao() );
        stm.setDouble(2,receita.getValor());
        stm.setDate(3,java.sql.Date.valueOf(receita.getDtRecebimento()));
        stm.setString(4,receita.getCategoria() );
        stm.setLong(5,receita.getCdConta());
        stm.setLong(6,receita.getCdUsuario());
        stm.executeUpdate();
    }


    public List<Receita> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_receita");
        ResultSet result = stm.executeQuery();
        List<Receita> lista = new ArrayList<>();
        while (result.next()){
            Long id = result.getLong("cd_receita");
            String desc = result.getString("descricao");
            double vlr = result.getDouble("valor");
            LocalDate dtReceb = result.getDate("dt_recebimento").toLocalDate();
            String categ = result.getString("categoria");
            long cdCt = result.getLong("cd_conta");
            long cdUs = result.getLong("cd_usuario");
            lista.add(new Receita(id, desc,vlr,dtReceb,categ,cdCt,cdUs));
        }
        return lista;
    }
}
