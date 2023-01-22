package br.com.minifinanceiro.services;

import br.com.minifinanceiro.dao.FinanceiroDao;
import br.com.minifinanceiro.models.Financeiro;

import java.util.ArrayList;

public class FinanceiroService {

    FinanceiroDao financeiroDao = FinanceiroDao.getInstance();

    private static final FinanceiroService FINANCEIRO_SERVICE = new FinanceiroService();
    private FinanceiroService(){
    }
    public static FinanceiroService getInstance(){
        return FINANCEIRO_SERVICE;
    }

    public boolean addFinanceiro(Financeiro financeiro){
        return financeiroDao.addFinanceiro(financeiro);
    }
    public ArrayList<Financeiro> listaFinanceirosAll(){
        return financeiroDao.getFinanceiros();
    }

    public Financeiro removerFinanceiro(int index){
        return financeiroDao.removeFinanceiro(index);
    }

    public Financeiro retornarFinanceiroIndex(int index){
        return financeiroDao.retornarFinanceiroIndex(index);
    }

    public void liquidarFinanceiro(int index){
        financeiroDao.liquidarFinanceiro(index);
    }

}
