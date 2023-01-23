package br.com.minifinanceiro.tools;

import br.com.minifinanceiro.controllers.FinanceiroController;
import br.com.minifinanceiro.controllers.PessoaFisicaController;
import br.com.minifinanceiro.controllers.PessoaJuridicaController;
import br.com.minifinanceiro.models.Pessoa;

import java.util.Scanner;

public class Sistema {
    Scanner tecla = new Scanner(System.in);
    private int opcao;
    private int index;
    Menu menu = Menu.getInstance();
    FinanceiroController financeiroController = FinanceiroController.getInstance();
    PessoaFisicaController pessoaFisicaController = PessoaFisicaController.getInstance();
    PessoaJuridicaController pessoaJuridicaController = PessoaJuridicaController.getInstance();
    private static final Sistema SISTEMA = new Sistema();
    private Sistema(){}
    public static Sistema getInstance(){
        return SISTEMA;
    }

    public void run(){

    }

    public void inicial(){
        menu.menuInicial();
        receberOpcao();
        rodarMenuInicial();
    }

    public void rodarMenuInicial(){
        switch (opcao){
            case 1:
                gerarDadosAleatorios();
                rodarMenuOpcoesTela02();
                break;
            case 2:
                Tools.teclaEncerrar();
                break;
            default:
                System.out.println("Informe uma opção valida");
                System.out.println(" ");
                menu.menuTela01Opcoes();
                break;
        }
    }


    public void rodarMenuOpcoesTela02(){
        menu.menuTela02Opcoes();
        receberOpcao();
        opcoesMenuTela02();
        
    }
    
    public void opcoesMenuTela02(){
        switch (opcao){
            case 1:
                rodarMenuOpcoesDespesas();
                break;
            case 2:
                rodarMenuOpcoesFornecedores();
                break;
            case 3:
                inicialSemHead();
                break;
            default:
                System.out.println("Informe uma opção valida");
                System.out.println(" ");
                rodarMenuOpcoesTela02();
                break;
        }
    }

    private void rodarMenuOpcoesFornecedores() {
    }

    private void rodarMenuOpcoesDespesas() {
        menu.menuDespesas01();
        receberOpcao();
        opcoesMenuDespesas();
    }

    private void opcoesMenuDespesas() {
        switch (opcao){
            case 1:
                incluirNovaDespesa();
                rodarMenuOpcoesDespesas();
                break;
            case 2:
                opcoesMenuDespesasLiquidar();
                break;
            case 3:
                opcoesMenuDespesasExcluir();
                opcoesMenuDespesas();
                break;
            case 4:
                financeiroController.imprimirListaFinanceiroAll();
                rodarMenuOpcoesDespesas();
                break;
            case 5:
                rodarMenuOpcoesTela02();
                break;
            default:
                System.out.println("Informe uma opção valida");
                System.out.println(" ");
                opcoesMenuDespesas();
                break;
        }
    }

    private void opcoesMenuDespesasLiquidar() {
        financeiroController.imprimirListaFinanceiroAll();
        receberIndex();
        System.out.println("CONFIRMA ? (1) Sim / (2) Não");
        receberOpcao();
        switch (opcao){
            case 1:
                financeiroController.liquidarPagamento(index);
                rodarMenuOpcoesDespesas();
                break;
            case 2:
                System.out.println("OPERAÇÃO NÃO REALIZADA");
                rodarMenuOpcoesDespesas();
                break;
            default:
                cancelandoOperacao();
        }
    }

    private void opcoesMenuDespesasExcluir() {
        financeiroController.imprimirListaFinanceiroAll();
        receberIndex();
        financeiroController.removerFinanceiro(index);

    }

    private void receberIndex() {
        System.out.println("Informe o numero correspondente");
        index = Integer.parseInt(tecla.nextLine());
    }

    private void incluirNovaDespesa() {
        menu.menuIncluirDespesa();
        String descricao;
        Pessoa fornecedor = null;
        double valorTotal;

        System.out.println("Vamos escolher o fornecedor, seu fornecedor é: ");
        System.out.println("( 1 ) PESSOA FISICA       ( 2 ) PESSOA JURIDICA");
        opcao = Integer.parseInt(tecla.nextLine());
        switch (opcao){
            case 1:
                pessoaFisicaController.listarPessoasAll();
                receberIndex();
                fornecedor = pessoaFisicaController.retornarPessoaIndex(index);
                break;
            case 2:
                pessoaJuridicaController.listarPessoasAll();
                receberIndex();
                fornecedor = pessoaJuridicaController.retornarPessoaIndex(index);
                break;
            default:
                cancelandoOperacao();
                break;
                
        }
        
        System.out.println("Informe um nome ou descrição para esse financeiro: ");
        descricao = tecla.nextLine();
        System.out.println("Informe o valor da despesa a ser paga (utilize . para os centavos): ");
        valorTotal = Double.parseDouble(tecla.nextLine());
        financeiroController.addFinanceiro(financeiroController.criarFinanceiro(descricao,fornecedor,valorTotal));
    }

    private void cancelandoOperacao() {
        System.out.println("... Opção invalida, cancelando operação ...");
        rodarMenuOpcoesTela02();
    }

    public void receberOpcao(){
        opcao = Integer.parseInt(tecla.nextLine());
    }
    
    public void gerarDadosAleatorios(){
        DadosBancoAleatorio dadosBancoAleatorio = DadosBancoAleatorio.getInstance();
        dadosBancoAleatorio.criarDadosAll();
        System.out.println("CRIANDO BANCO DE DEMOSTRAÇÃO ALEATORIO");
        System.out.println(" ");
        System.out.print("0%");
        Tools.pause(1);
        System.out.print("........");
        System.out.print("25%.....");
        Tools.pause(1);
        System.out.print("50%.....");
        Tools.pause(1);
        System.out.print(".............100%");
        System.out.println(" ");
        System.out.println("Sucesso !");
        Tools.pause(1);
    }

    public void inicialSemHead(){
        menu.menuTela01Opcoes();
        receberOpcao();
        rodarMenuInicial();
    }


}
