package br.com.minifinanceiro;

import br.com.minifinanceiro.tools.Sistema;
import br.com.minifinanceiro.tools.Tools;

public class Main {

    public static void main(String[] args) {

        Sistema.getInstance().digaOla();
        Tools.pause(3);
        Sistema.getInstance().aloMenu();

        Tools.pause(5);

        // trocar DATE por String e adcionar metodo para converter quando quiser fazer calculos.

    }

}
