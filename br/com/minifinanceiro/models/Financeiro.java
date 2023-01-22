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
    private boolean liquidado;
    private EmpresaProprio empresaProprio;

    public Financeiro(String descricaoDespesa, PessoaJuridica empresa, Pessoa fornecedor, double valorTotal) {
        this.id = proximoNum();
        this.descricaoDespesa = descricaoDespesa;
        this.empresa = empresa;
        this.fornecedor = fornecedor;
        this.valorTotal = valorTotal;

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


    public boolean isLiquidado() {
        return liquidado;
    }

    public void setLiquidado(boolean liquidado) {
        this.liquidado = liquidado;
    }


    @Override
    public String toString() {
        return "Financeiro{" +
                "id=" + id +
                ", descricaoDespesa='" + descricaoDespesa + '\'' +
                ", empresa=" + empresa +
                ", fornecedor=" + fornecedor +
                ", valorTotal=" + valorTotal +
                ", liquidado=" + liquidado +
                ", empresaProprio=" + empresaProprio +
                '}';
    }
}
