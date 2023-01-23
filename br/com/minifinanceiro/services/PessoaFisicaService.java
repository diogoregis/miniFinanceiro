package br.com.minifinanceiro.services;

import br.com.minifinanceiro.dao.PessoaFisicaDao;
import br.com.minifinanceiro.models.PessoaFisica;

import java.util.ArrayList;

public class PessoaFisicaService {

    PessoaFisicaDao pessoaFisicaDao = PessoaFisicaDao.getInstance();
    private static final PessoaFisicaService PESSOA_FISICA_SERVICE = new PessoaFisicaService();
    private PessoaFisicaService(){}
    public static PessoaFisicaService getInstance(){
        return PESSOA_FISICA_SERVICE;
    }

    public ArrayList<PessoaFisica> retornarListaAll(){
        return pessoaFisicaDao.getPessoasFisicas();
    }
    public boolean addPessoaFisica(PessoaFisica pessoaFisica){
        return pessoaFisicaDao.addPessoaFisica(pessoaFisica);
    }
    public PessoaFisica removePessoaFisica(int index){
        return pessoaFisicaDao.removePessoaFisica(index);
    }

    public PessoaFisica retornarPessoaFisicaIndex(int index){
        return pessoaFisicaDao.retornarPessoaFisicaIndex(index);
    }

}
