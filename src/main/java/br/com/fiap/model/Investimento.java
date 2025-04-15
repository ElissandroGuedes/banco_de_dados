package br.com.fiap.model;

import java.time.LocalDate;

public class Investimento {
    private long cdInvestimento;
    private String descricao;
    private double valor;
    private LocalDate dtInvestimento;
    private String tipoInvestimento;
    private long cdConta;
    private long cdUsuario;

    public Investimento() {
    }

    public Investimento(long cdInvestimento, String descricao, double valor, LocalDate dtInvestimento, String tipoInvestimento, long cdConta, long cdUsuario) {
        this.cdInvestimento = cdInvestimento;
        this.descricao = descricao;
        this.valor = valor;
        this.dtInvestimento = dtInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.cdConta = cdConta;
        this.cdUsuario = cdUsuario;
    }

    public Investimento(String descricao, double valor, LocalDate dtInvestimento, String tipoInvestimento, long cdConta, long cdUsuario) {
        this.descricao = descricao;
        this.valor = valor;
        this.dtInvestimento = dtInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.cdConta = cdConta;
        this.cdUsuario = cdUsuario;
    }

    public long getCdInvestimento() {
        return cdInvestimento;
    }

    public void setCdInvestimento(long cdInvestimento) {
        this.cdInvestimento = cdInvestimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDtInvestimento() {
        return dtInvestimento;
    }

    public void setDtInvestimento(LocalDate dtInvestimento) {
        this.dtInvestimento = dtInvestimento;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public long getCdConta() {
        return cdConta;
    }

    public void setCdConta(long cdConta) {
        this.cdConta = cdConta;
    }

    public long getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(long cdUsuario) {
        this.cdUsuario = cdUsuario;
    }
}
