package br.com.minifinanceiro.models;

import java.util.Date;

public class Financeiro {

    // trocar DATE por String e adcionar metodo para converter quando quiser fazer calculos.
    private static int numId;
    private int id;
    private String descricaoDespesa;
    private PessoaJuridica empresa;
    private Pessoa fornecedor;
    private double valorTotal;

    public Financeiro(String descricaoDespesa, PessoaJuridica empresa, Pessoa fornecedor, double valorTotal, double valorPago, Date vencimento, Date dataPagamento) {
        this.id = proximoNum();
        this.descricaoDespesa = descricaoDespesa;
        this.empresa = empresa;
        this.fornecedor = fornecedor;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.vencimento = vencimento;
        this.dataPagamento = dataPagamento;
    }

    private static int proximoNum(){
        return ++numId;
    }
    public int getId() {
        return id;
    }

    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public Pessoa getFornecedor() {
        return fornecedor;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorRestaPagar() {
        return valorRestaPagar;
    }

    public void setValorRestaPagar(double valorRestaPagar) {
        this.valorRestaPagar = valorRestaPagar;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public boolean isLiquidado() {
        return liquidado;
    }

    public void setLiquidado(boolean liquidado) {
        this.liquidado = liquidado;
    }

    public boolean isVencido() {
        return vencido;
    }

    public void setVencido(boolean vencido) {
        this.vencido = vencido;
    }

    private double valorPago;
    private double valorRestaPagar;
    private Date vencimento;
    private Date dataPagamento;
    private boolean liquidado;
    private boolean vencido;
    private EmpresaProprio empresaProprio;


}
