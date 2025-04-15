package br.com.fiap.model;

import java.time.LocalDate;

public class Despesas {
     private long cdDespesa;
     private String descricao;
     private double valor;
     private LocalDate dtVencimento;
     private String categoria;
     private long cdConta;
     private long cdUsuario;

    public Despesas() {
    }

    public Despesas(long cdDespesa, String descricao, double valor, LocalDate dtVencimento, String categoria, long cdConta, long cdUsuario) {
        this.cdDespesa = cdDespesa;
        this.descricao = descricao;
        this.valor = valor;
        this.dtVencimento = dtVencimento;
        this.categoria = categoria;
        this.cdConta = cdConta;
        this.cdUsuario = cdUsuario;
    }

    public Despesas(String descricao, double valor, LocalDate dtVencimento, String categoria, long cdConta, long cdUsuario) {
        this.descricao = descricao;
        this.valor = valor;
        this.dtVencimento = dtVencimento;
        this.categoria = categoria;
        this.cdConta = cdConta;
        this.cdUsuario = cdUsuario;
    }

    public long getCdDespesa() {
        return cdDespesa;
    }

    public void setCdDespesa(long cdDespesa) {
        this.cdDespesa = cdDespesa;
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

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(LocalDate dtVencimento) {
        this.dtVencimento = dtVencimento;
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
