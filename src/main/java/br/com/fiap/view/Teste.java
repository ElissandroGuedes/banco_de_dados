package br.com.fiap.view;
import br.com.fiap.Dao.ContaDao;
import br.com.fiap.Dao.DespesasDao;
import br.com.fiap.Dao.InvestimentoDao;
import br.com.fiap.Dao.ReceitaDao;
import br.com.fiap.model.Conta;
import br.com.fiap.model.Despesas;
import br.com.fiap.model.Investimento;
import br.com.fiap.model.Receita;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ReceitaDao daoReceita;
        DespesasDao daoDespesas;
        InvestimentoDao daoInvestimento;
        ContaDao daoConta;

        System.out.println("Bem vindo ao sistema de cadastramento e listagem do projeto fintech!");

        try {
            daoReceita = new ReceitaDao();
            daoDespesas = new DespesasDao();
            daoInvestimento = new InvestimentoDao();
            daoConta = new ContaDao();
            int opcao;

            do {
                System.out.println("Escolha uma opção:\n1-Cadastrar Receita\n2-Listar Receitas\n3-Cadastrar Despesa\n4-Listar Despesa\n5-Cadastrar Investimento\n6-Listar Investimento\n7-Cadastrar Conta\n8-Listar Conta\n9-Sair");
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpa o \n

                switch (opcao) {
                    case 1:
                        cadastrarReceita(scanner, daoReceita);
                        break;
                    case 2:
                        listarReceita(daoReceita);
                        break;
                    case 3:
                        cadastrarDespesas(scanner, daoDespesas);
                        break;
                    case 4:
                        listarDespesas(daoDespesas);
                        break;
                    case 5:
                        cadastrarInvestimento(scanner, daoInvestimento);
                        break;
                    case 6:
                        listarInvestimento(daoInvestimento);
                        break;
                    case 7:
                        cadastrarConta(scanner, daoConta);
                        break;
                    case 8:
                        listarConta(daoConta);
                        break;
                    case 9:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente!");
                }

            } while (opcao != 9);

            daoReceita.fecharConexao();

        } catch (SQLException e) {
            System.err.println("Erro ao se conectar ao Banco de Dados: " + e.getMessage());
        }
    }

    private static void cadastrarReceita(Scanner scanner, ReceitaDao daoReceita) {
        try {
            System.out.println("Digite a descrição da receita: ");
            String desc = scanner.nextLine();

            System.out.println("Digite o valor da receita: ");
            double vlr = scanner.nextDouble();
            scanner.nextLine(); // limpa o \n

            System.out.println("Digite a data da receita (dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataStr, formatter);

            System.out.println("Digite a categoria da receita: ");
            String categ = scanner.nextLine();

            System.out.println("Digite o código da conta: ");
            int cdCt = scanner.nextInt();

            System.out.println("Digite o código do usuário: ");
            int cdUs = scanner.nextInt();
            scanner.nextLine(); // limpa o \n

            Receita receita = new Receita(desc, vlr, data, categ, cdCt, cdUs);
            daoReceita.insert(receita);

            System.out.println("Receita cadastrada!");
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar a receita: " + e.getMessage());
        }
    }

    private static void listarReceita(ReceitaDao daoReceita) {
        try {
            List<Receita> receitas = daoReceita.getAll();
            System.out.println("Lista de receitas:");

            for (Receita receita : receitas) {
                System.out.println(receita.getCdReceita() + " , " +
                        receita.getDescricao() + " , " +
                        receita.getValor() + " , " +
                        receita.getDtRecebimento() + " , " +
                        receita.getCategoria() + " , " +
                        receita.getCdConta() + " , " +
                        receita.getCdUsuario());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar as receitas: " + e.getMessage());
        }
    }

    private static void cadastrarDespesas(Scanner scanner, DespesasDao daoDespesas) {
        try {
            System.out.println("Digite a descrição da despesa: ");
            String descr = scanner.nextLine();

            System.out.println("Digite o valor da despesa: ");
            double valr = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite a data da despesa (dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dtVenc = LocalDate.parse(dataStr, formatter);

            System.out.println("Digite a categoria da despesa: ");
            String cteg = scanner.nextLine();

            System.out.println("Digite o código da conta: ");
            int cdCont = scanner.nextInt();

            System.out.println("Digite o código do usuário: ");
            int cdUsu = scanner.nextInt();
            scanner.nextLine();

            Despesas despesas = new Despesas(descr,valr,dtVenc,cteg,cdCont,cdUsu);
            daoDespesas.insert(despesas);

            System.out.println("Despesa cadastrada!");
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar a despesa: " + e.getMessage());
        }
    }

    private static void listarDespesas(DespesasDao daoDespesas) {
        try {
            List<Despesas> despesa = daoDespesas.getAll();
            System.out.println("Lista de despesa:");

            for (Despesas despesas: despesa) {
                System.out.println(despesas.getCdDespesa() + " , " +
                        despesas.getDescricao() + " , " +
                        despesas.getValor() + " , " +
                        despesas.getDtVencimento() + " , " +
                        despesas.getCategoria() + " , " +
                        despesas.getCdConta() + " , " +
                        despesas.getCdUsuario());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar as despesa: " + e.getMessage());
        }
    }

    private static void cadastrarInvestimento(Scanner scanner, InvestimentoDao daoInvestimento) {
        try {
            System.out.println("Digite a descrição do Investimento: ");
            String desc = scanner.nextLine();

            System.out.println("Digite o valor do Investimento: ");
            double vlr = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite a data do Investimento (dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataStr, formatter);

            System.out.println("Digite o tipo do Investimento: ");
            String tipo = scanner.nextLine();

            System.out.println("Digite o código da conta: ");
            int cdCt = scanner.nextInt();

            System.out.println("Digite o código do usuário: ");
            int cdUs = scanner.nextInt();
            scanner.nextLine(); // limpa o \n

            Investimento investimento = new Investimento(desc,vlr,data,tipo,cdCt,cdUs);
            daoInvestimento.insert(investimento);

            System.out.println("Investimento cadastrado!");
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar o Investimento: " + e.getMessage());
        }
    }

    private static void listarInvestimento(InvestimentoDao daoInvestimento) {
        try {
            List<Investimento> investimentos = daoInvestimento.getAll();
            System.out.println("Lista de Investimento:");

            for (Investimento investimento: investimentos) {
                System.out.println(investimento.getCdInvestimento() + " , " +
                        investimento.getDescricao() + " , " +
                        investimento.getValor() + " , " +
                        investimento.getDtInvestimento() + " , " +
                        investimento.getTipoInvestimento() + " , " +
                        investimento.getCdConta() + " , " +
                        investimento.getCdUsuario());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar o Investimento: " + e.getMessage());
        }
    }

    private static void cadastrarConta(Scanner scanner, ContaDao daoConta) {
        try {
            System.out.println("Digite o número da conta: ");
            String nrCt = scanner.nextLine();

            System.out.println("Digite o tipo da conta: ");
            String tpCt = scanner.nextLine();

            System.out.println("Digite o saldo da conta: ");
            double sdCt = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o código do usuário: ");
            int cdUs = scanner.nextInt();
            scanner.nextLine();

            Conta conta = new Conta(nrCt,tpCt,sdCt,cdUs);
            daoConta.insert(conta);

            System.out.println("Conta cadastrada!");
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar a conta: " + e.getMessage());
        }
    }

    private static void listarConta(ContaDao daoConta) {
        try {
            List<Conta> contas = daoConta.getAll();
            System.out.println("Lista de conta:");

            for (Conta conta: contas) {
                System.out.println(conta.getCdConta() + " , " +
                        conta.getNrConta() + " , " +
                        conta.getTipoConta() + " , " +
                        conta.getSaldoConta() + " , " +
                        conta.getCdUsuario());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar a conta: " + e.getMessage());
        }
    }

}
