package br.com.fiap.model;

import java.time.LocalDate;

public class Receita {
    private long cdReceita;
    private String descricao;
    private double valor;
    private LocalDate dtRecebimento;
    private String categoria;
    private long cdConta;
    private long cdUsuario;

    public Receita() {
    }

    public Receita(long cdReceita, String descricao, double valor, LocalDate dtRecebimento, String categoria, long cdConta, long cdUsuario) {
        this.cdReceita = cdReceita;
        this.descricao = descricao;
        this.valor = valor;
        this.dtRecebimento = dtRecebimento;
        this.categoria = categoria;
        this.cdConta = cdConta;
        this.cdUsuario = cdUsuario;
    }

    public Receita(String descricao, double valor, LocalDate dtRecebimento, String categoria, long cdConta, long cdUsuario) {
        this.descricao = descricao;
        this.valor = valor;
        this.dtRecebimento = dtRecebimento;
        this.categoria = categoria;
        this.cdConta = cdConta;
        this.cdUsuario = cdUsuario;
    }

    public long getCdReceita() {
        return cdReceita;
    }

    public void setCdReceita(long cdReceita) {
        this.cdReceita = cdReceita;
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

    public LocalDate getDtRecebimento() {
        return dtRecebimento;
    }

    public void setDtRecebimento(LocalDate dtRecebimento) {
        this.dtRecebimento = dtRecebimento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
