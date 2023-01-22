package br.com.minifinanceiro.dao;

import br.com.minifinanceiro.models.Financeiro;

import java.util.ArrayList;

public class FinanceiroDao {

    private static ArrayList<Financeiro> financeiros;
    public static ArrayList<Financeiro> getFinanceiros() {
        return financeiros;
    }
    public static boolean addFinanceiro(Financeiro financeiro) {
        return financeiros.add(financeiro);
    }
    public Financeiro removeFinanceiro(int index){

        return financeiros.remove(index);
        // incluir no controller verificação se objeto existe.
    }
}
