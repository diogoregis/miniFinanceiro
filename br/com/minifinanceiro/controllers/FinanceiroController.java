package br.com.minifinanceiro.controllers;

import br.com.minifinanceiro.models.Financeiro;
import br.com.minifinanceiro.models.Pessoa;
import br.com.minifinanceiro.models.PessoaJuridica;
import br.com.minifinanceiro.services.FinanceiroService;
import br.com.minifinanceiro.tools.Tools;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FinanceiroController {

    Scanner tc = new Scanner(System.in);
    static FinanceiroService financeiroService = FinanceiroService.getInstance();
    private static final FinanceiroController FINANCEIRO_CONTROLLER = new FinanceiroController();
    private FinanceiroController(){

    }
    public static FinanceiroController getInstance(){
        return FINANCEIRO_CONTROLLER;
    }

    public  void addFinanceiro(Financeiro financeiro){
        if(financeiroService.addFinanceiro(financeiro)){
            System.out.println("Adicionado com sucesso !");
        } else {
            System.out.println("!!! ERRO AO TENTAR SALVAR !!!");
        }
    }

    public  Financeiro criarFinanceiro(String descricao, Pessoa fornecedor, double valorTotal){
        return new Financeiro(descricao, fornecedor, valorTotal);

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

    public void imprimirListaFinanceiroAll(){
        if(listaFinanceiro().isEmpty()){
            System.out.println(" ");
            System.out.println("Ainda NÃO existem financeiros cadastrados.");
        } else {
            System.out.println(" ");
            System.out.println("-----------------");
            int i = 0;
            for (Financeiro despesas:listaFinanceiro()) {
                System.out.print(i++ + " ");
                imprimirFormatado(despesas);
                Tools.pause(1);
            }
            Tools.pause(1);
        }
    }

    private ArrayList<Financeiro> listaFinanceiro(){
        return financeiroService.listaFinanceirosAll();
    }

    public Financeiro removerFinanceiro(int index){
        return financeiroService.removerFinanceiro(index);
    }

    private void escolherExcluirFinanceiro(){
        int index;
        Financeiro valorAntigo;
        System.out.println(" ");
        System.out.println("Qual financeiro deseja excluir ? - informe o numero do index");
        imprimirListaFinanceiroAll();
        index = Integer.parseInt(tc.nextLine());
        if(index < 0){
            valorAntigo = removerFinanceiro(index);
            if(validarIndex(valorAntigo)){
                System.out.println(" ");
                System.out.println("Sucesso, " + valorAntigo.getDescricaoDespesa() + ", foi excluido");
                System.out.println(" ");
            } else {
                System.out.println(" ");
                System.out.println("Index de financeiro não encontrado");
                System.out.println(" ");
            }

            } else{
            System.out.println("Tente um valor maior que 0 (zero), na proxima");
            }


    }

    private boolean validarIndex(Financeiro valorAntigo){
        if(valorAntigo == null){
            return false;
        } else {
            return true;
        }
    }

    private void liquidarFinanceiro(Financeiro despesa){

        if(despesa.isLiquidado()){
            System.out.println(" ");
            System.out.println("Esse Financeiro já se encontra liquidado");
            System.out.println();
        } else {
            despesa.setLiquidado(true);
            System.out.printf(" ");
            System.out.println("Sucesso despesa foi liquidada !");
            System.out.println();
        }
    }

    private void pagarDespesa(){
        int index;
        System.out.println(" ");
        System.out.println("Qual financeiro deseja liquidar ? - informe o numero do index");
        imprimirListaFinanceiroAll();
        index = Integer.parseInt(tc.nextLine());

    }

    private Financeiro retornarFinanceiroIndex(int index){
        return financeiroService.retornarFinanceiroIndex(index);
    }

    private void imprimirFormatado(Financeiro financeiro){

        System.out.print(">>> " + financeiro.getDescricaoDespesa() + " | " + "Fornecedor: "+ financeiro.getFornecedor().getNome() + " " +
                            " | " + Tools.precoFormata(financeiro.getValorTotal()) + " | " + "( " + financeiro.getEmpresa().getNomeFantasia() + " )");
        System.out.print(Tools.liquidaFormata(financeiro.isLiquidado()));
        System.out.println(" ");
        System.out.println("-----------------");
    }

    public void salvarForceValidado(Financeiro financeiro) {
        financeiroService.addFinanceiro(financeiro);
    }

    public void liquidarPagamento(int index) {
        financeiroService.retornarFinanceiroIndex(index).setLiquidado(true);
        System.out.println("");
    }

}
