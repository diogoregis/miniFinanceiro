package br.com.minifinanceiro.tools;

import java.util.Scanner;

public class Sistema {

    private static final Sistema SISTEMA = new Sistema(Menu.getInstance());
    private Menu menu;
    static Scanner tecla = new Scanner(System.in);

    private Sistema(Menu menu){
        this.menu = menu;
    }

    public static Sistema getInstance(){
        return SISTEMA;
    }

    public void digaOla(){
        EntradaCadastro.escreva();
    }

    public void aloMenu(){
        menu.ola();
    }

    protected static class EntradaCadastro {
        private static void escreva(){
            System.out.println("olá");
            tecla.close();
        }
    }
}
