package br.com.minifinanceiro.tools;

public class Menu {

    private static final Menu MENU = new Menu();
    private Menu(){}

    public static Menu getInstance(){
        return MENU;
    }

    public void head(){
        System.out.println("*********************************************");
        System.out.println("**           "+ Tools.textoFormatadoBlue("MiniFinanceiro - Java") + "         **");
        System.out.println("************************************ "+ Tools.textoFormatadoYellow("0.13v") +" **");
        System.out.println(" ");
    }
    public void menuInicial(){
        head();
        menuTela01Opcoes();
    }

    public void menuTela01Opcoes(){
        System.out.println("*********************************************");
        System.out.println("---------------------------------------------");
        System.out.println("|           1 - Utilizar o sistema          |");
        System.out.println("|           2 - Sair                        |");
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        System.out.print("Digite o numero da opção correspondente: ");
    }

    public void menuTela02Opcoes(){
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("|           1 - Despesas                    |");
        System.out.println("|           2 - Fornecedores                |");
        System.out.println("|           3 - Menu inicial                |");
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        System.out.print("Digite o numero da opção correspondente: ");
    }

    public void menuDespesas01(){
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("|           1 - Incluir financeiro          |");
        System.out.println("|           2 - Liquidar financeiro         |");
        System.out.println("|           3 - Excluir financeiro          |");
        System.out.println("|           4 - Listar todos os financeiros |");
        System.out.println("|           5 - Voltar                      |");
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        System.out.print("Digite o numero da opção correspondente: ");
    }

    public void menuFornecedores01(){
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("|           1 - Incluir fornecedor          |");
        System.out.println("|           2 - Excluir fornecedor          |");
        System.out.println("|           3 - Listar todos fornecedores   |");
        System.out.println("|           4 - Voltar                      |");
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        System.out.print("Digite o numero da opção correspondente: ");
    }

    public void menuIncluirDespesa(){
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("|           DIGITE OS DADOS CONFORME        |");
        System.out.println("|           SOLICITADOS NA TELA             |");
        System.out.println("|           (procure não deixar em branco)  |");
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        imprimindoMSG();
    }

    public void tipoFornecedor(){
        System.out.println("*********************************************");
        System.out.println("---------------------------------------------");
        System.out.println("|           1 - Pessoa Fisica               |");
        System.out.println("|           2 - Pessoa Juridica             |");
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        System.out.print("Digite o numero da opção correspondente: ");
    }

    private void imprimindoMSG() {
        System.out.println(Tools.textoFormatadoYellow("       ... Imprimindo ..."));
        System.out.println();
    }


}
