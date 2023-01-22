package br.com.minifinanceiro.controllers;

import br.com.minifinanceiro.models.Financeiro;
import br.com.minifinanceiro.models.Pessoa;
import br.com.minifinanceiro.models.PessoaJuridica;
import br.com.minifinanceiro.services.FinanceiroService;

import java.util.Date;

public class FinanceiroController {

    FinanceiroService financeiroService = FinanceiroService.getInstance();
    private static final FinanceiroController FINANCEIRO_CONTROLLER = new FinanceiroController();
    private FinanceiroController(){

    }
    public static FinanceiroController getInstance(){
        return FINANCEIRO_CONTROLLER;
    }

    public void addFinanceiro(Financeiro financeiro){
        if(financeiroService.addFinanceiro(financeiro)){
            System.out.println("Adicionado com sucesso !");
        } else {
            System.out.println("!!! ERRO AO TENTAR SALVAR !!!");
        }
    }

    public Financeiro criarFinanceiro(String descricao, PessoaJuridica empresa, Pessoa fornecedor, double valorTotal, double valorPago, Date vencimento, Date dataPamento){
        Financeiro financeiro = new Financeiro(descricao, empresa, fornecedor, valorTotal, valorPago, vencimento, dataPamento);
        return financeiro;
    }

    private double restaPagar(double valorTotal, double valorPago){
        return valorTotal - valorPago;
    }

    private boolean verificaValor(double valorTotal, double valorPago){
        if(valorTotal - valorPago > 0.00){
            return true;
        } else {
            return false;
        }
    }

}
