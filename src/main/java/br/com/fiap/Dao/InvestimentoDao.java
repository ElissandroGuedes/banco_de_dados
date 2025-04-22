package br.com.fiap.Dao;
import br.com.fiap.exception.InvestimentoDaoException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Investimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDao {

    private Connection conexao;

    public InvestimentoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Investimento investimento) throws SQLException, InvestimentoDaoException {
        try {
            PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_investimento (cd_investimento, descricao, valor,dt_investimento,tipo_investimento,cd_conta,cd_usuario) VALUES (seq_investimento.nextval, ?,?,?,?,?,?)");
            stm.setString(1,investimento.getDescricao() );
            stm.setDouble(2,investimento.getValor());
            stm.setDate(3,java.sql.Date.valueOf(investimento.getDtInvestimento()));
            stm.setString(4,investimento.getTipoInvestimento());
            stm.setLong(5,investimento.getCdConta());
            stm.setLong(6,investimento.getCdUsuario());
            stm.executeUpdate();
        }catch (SQLException e){
            throw new InvestimentoDaoException("Erro ao inserir o investimento",e);
        }
    }

    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public List<Investimento> getAll() throws SQLException, InvestimentoDaoException {
        try {
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_investimento");
            ResultSet result = stm.executeQuery();
            List<Investimento> lista = new ArrayList<>();
            while (result.next()){
                Long id = result.getLong("cd_investimento");
                String desc = result.getString("descricao");
                double vlr = result.getDouble("valor");
                LocalDate dtInvest = result.getDate("dt_investimento").toLocalDate();
                String tpInvest = result.getString("tipo_investimento");
                long cdCt = result.getLong("cd_conta");
                long cdUs = result.getLong("cd_usuario");
                lista.add(new Investimento(id, desc,vlr,dtInvest,tpInvest,cdCt,cdUs));
            }
            return lista;
        } catch (SQLException e){
            throw new InvestimentoDaoException("Erro ao buscar o investimento",e);
        }
    }
}
