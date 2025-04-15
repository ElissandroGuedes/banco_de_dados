package br.com.fiap.model;

public class Conta {
    private long cdConta;
    private String nrConta;
    private String tipoConta;
    private double saldoConta;
    private long cdUsuario;

    public Conta() {
    }

    public Conta(long cdConta, String nrConta, String tipoConta, double saldoConta, long cdUsuario) {
        this.cdConta = cdConta;
        this.nrConta = nrConta;
        this.tipoConta = tipoConta;
        this.saldoConta = saldoConta;
        this.cdUsuario = cdUsuario;
    }

    public Conta(String nrConta, String tipoConta, double saldoConta, long cdUsuario) {
        this.nrConta = nrConta;
        this.tipoConta = tipoConta;
        this.saldoConta = saldoConta;
        this.cdUsuario = cdUsuario;
    }

    public long getCdConta() {
        return cdConta;
    }

    public void setCdConta(long cdConta) {
        this.cdConta = cdConta;
    }

    public String getNrConta() {
        return nrConta;
    }

    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public long getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(long cdUsuario) {
        this.cdUsuario = cdUsuario;
    }
}
