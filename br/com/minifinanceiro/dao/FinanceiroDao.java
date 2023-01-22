package br.com.minifinanceiro.dao;

import br.com.minifinanceiro.models.Financeiro;

import java.util.ArrayList;

public class FinanceiroDao {

    private static ArrayList<Financeiro> financeiros = new ArrayList<Financeiro>();
    private static final FinanceiroDao FINANCEIRO_DAO = new FinanceiroDao();
    private FinanceiroDao(){};
    public static FinanceiroDao getInstance(){
        return FINANCEIRO_DAO;
    }
    public ArrayList<Financeiro> getFinanceiros() {
        return financeiros;
    }
    public boolean addFinanceiro(Financeiro financeiro) {
        return financeiros.add(financeiro);
    }
    public Financeiro removeFinanceiro(int index){
        return financeiros.remove(index);
    }

    public Financeiro retornarFinanceiroIndex(int index){
        return financeiros.get(index);
    }

    public void liquidarFinanceiro(int index){
        financeiros.get(index).setLiquidado(true);
    }

}
