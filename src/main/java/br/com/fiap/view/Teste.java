package br.com.fiap.view;
import br.com.fiap.Dao.ReceitaDao;
import br.com.fiap.model.Receita;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        try {
            ReceitaDao dao = new ReceitaDao();
            List<Receita>receitas = dao.getAll();
            for (Receita receita : receitas){
                System.out.println(receita.getCdReceita() + " , " + receita.getDescricao() + " , " + receita.getValor() + " , " + receita.getDtRecebimento() + " , " + receita.getCategoria() + " , " + receita.getCdConta() + " , " + receita.getCdUsuario());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
             System.err.println(e.getMessage());
        }

        try {
            ReceitaDao dao = new ReceitaDao();
            String dataStr = "30/06/2022";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataStr,formatter);
            Receita receita = new Receita("Restituição de IR",2000.00,data,"Outras",22,18);
            dao.insert(receita);
            dao.fecharConexao();
            System.out.println("Receita cadastrada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
