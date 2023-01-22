package br.com.minifinanceiro.tools;

public class Menu {

    private static final Menu MENU = new Menu();

    private Menu(){}

    public static Menu getInstance(){
        return MENU;
    }

    public void ola(){
        System.out.println("Estou dizendo ola");
    }
}
