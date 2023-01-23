package br.com.minifinanceiro.tools;

import br.com.minifinanceiro.controllers.FinanceiroController;
import br.com.minifinanceiro.controllers.PessoaFisicaController;
import br.com.minifinanceiro.controllers.PessoaJuridicaController;
import br.com.minifinanceiro.models.Pessoa;
import br.com.minifinanceiro.models.PessoaFisica;
import br.com.minifinanceiro.models.PessoaJuridica;

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
        menu.menuFornecedores01();
        receberOpcao();
        opcoesMenuFornecedores();
    }

    private void opcoesMenuFornecedores() {
        switch (opcao){
            case 1:
                incluirNovoFornecedor();
                rodarMenuOpcoesFornecedores();
                break;
            case 2:
                opcoesMenuFornecedoresExluir();
                rodarMenuOpcoesFornecedores();
                break;
            case 3:
                listarFornecedoresAll();
                rodarMenuOpcoesFornecedores();
                break;
            case 4:
                rodarMenuOpcoesTela02();
                break;
            default:
                System.out.println("Informe uma opção valida");
                System.out.println(" ");
                opcoesMenuDespesas();
                break;
        }
    }

    private void incluirNovoFornecedor() {
        rodarMenuTipoFornecedor();
        receberOpcao();
        switch(opcao){
            case 1:
                cadastroFornecedorPessoaFisica();
                rodarMenuOpcoesFornecedores();
                break;
            case 2:
                cadastroFornecedorPessoaJuridica();
                rodarMenuOpcoesFornecedores();
                break;
            default:
                opcaoInvalida();
                rodarMenuOpcoesFornecedores();
                break;
        }
    }

    private void cadastroFornecedorPessoaJuridica() {

        String nome, sobrenome, domicilio, registro;
        PessoaJuridica pessoaJuridica;
        menu.menuIncluirDespesa();
        System.out.println("Digte a Razão Social ");
        nome = tecla.nextLine();
        System.out.println("Digte o Nome Fantasia: ");
        sobrenome = tecla.nextLine();
        System.out.println("Digte o domicilio no formato CIDADE, PAIS: (ex Orlando, USA)");
        domicilio = tecla.nextLine();
        System.out.println("Digte o CNPJ : ");
        registro = tecla.nextLine();
        pessoaJuridica = (PessoaJuridica) pessoaJuridicaController.criarPessoa(nome, sobrenome, domicilio, registro);
        pessoaJuridicaController.salvarPessoa(pessoaJuridica);

    }

    private void cadastroFornecedorPessoaFisica() {
        String nome, sobrenome, domicilio, registro;
        PessoaFisica pessoaFisica;
        menu.menuIncluirDespesa();
        System.out.println("Digte o primeiro nome: ");
        nome = tecla.nextLine();
        System.out.println("Digte o sobrenome: ");
        sobrenome = tecla.nextLine();
        System.out.println("Digte o domicilio no formato CIDADE, PAIS: (ex Orlando, USA)");
        domicilio = tecla.nextLine();
        System.out.println("Digte seu CPF: ");
        registro = tecla.nextLine();
        pessoaFisica = (PessoaFisica) pessoaFisicaController.criarPessoa(nome, sobrenome, domicilio, registro);
        pessoaFisicaController.salvarPessoa(pessoaFisica);
    }

    private void opcoesMenuFornecedoresExluir() {

        rodarMenuTipoFornecedor();
        receberOpcao();
        switch (opcao){
            case 1:
                pessoaFisicaController.excluirPessoa();
                break;
            case 2:
                pessoaJuridicaController.excluirPessoa();
                break;
            default:
                opcaoInvalida();
                rodarMenuOpcoesFornecedores();
                break;
        }
        rodarMenuOpcoesFornecedores();

    }

    private void rodarMenuTipoFornecedor() {

        menu.tipoFornecedor();

    }

    private void opcaoInvalida() {
        System.out.println(Tools.textoFormatadoYellow("Opção invalida"));
        System.out.println(Tools.textoFormatadoWhite("Cancelando operação, nenhuma modificação realizada."));
    }

    private boolean confirmaOperacao() {
        System.out.println("CONFIRMA ? (1) Sim / (2) Não");
        receberOpcao();
        switch (opcao){
            case 1:
                return true;
            case 2:
                return false;
            default:
                opcaoInvalida();

                rodarMenuOpcoesTela02();
                return false;
        }
    }

    private void listarFornecedoresAll() {
        System.out.println(Tools.textoFormatadoBlue(">>> FORNECEDORES <<<"));
        System.out.println();
        System.out.println(Tools.textoFormatadoYellow(">>> Pessoa Fisica: " ));
        pessoaFisicaController.listarPessoasAll();
        System.out.println(" ");
        System.out.println(Tools.textoFormatadoYellow(">>> Pessoa Juridica: " ));
        pessoaJuridicaController.listarPessoasAll();
        Tools.pause(2);
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
                rodarMenuOpcoesDespesas();
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
