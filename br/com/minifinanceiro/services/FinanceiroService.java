package br.com.minifinanceiro.services;

import br.com.minifinanceiro.dao.FinanceiroDao;
import br.com.minifinanceiro.models.Financeiro;

public class FinanceiroService {

    private static final FinanceiroService FINANCEIRO_SERVICE = new FinanceiroService();
    private FinanceiroService(){
    }
    public static FinanceiroService getInstance(){
        return FINANCEIRO_SERVICE;
    }

    public boolean addFinanceiro(Financeiro financeiro){
        return FinanceiroDao.addFinanceiro(financeiro);
    }

}
