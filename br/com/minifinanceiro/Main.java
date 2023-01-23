package br.com.minifinanceiro;

import br.com.minifinanceiro.tools.Sistema;
import br.com.minifinanceiro.tools.Tools;

public class Main {

    public static void main(String[] args) {

        Sistema sistema = Sistema.getInstance();
        sistema.inicial();
        Tools.pause(1);


    }

}
