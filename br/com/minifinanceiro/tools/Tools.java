package br.com.minifinanceiro.tools;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Tools {


    static NumberFormat nf = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static void pause (int segundos){
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            System.err.println("Erro so pausar "+segundos+" segundos.");
        }
    }

    public static String precoFormata(double preco){
        return Tools.nf.format(preco);
    }


}
