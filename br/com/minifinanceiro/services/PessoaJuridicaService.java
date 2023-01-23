package br.com.minifinanceiro.services;

import br.com.minifinanceiro.dao.PessoaJuridicaDao;
import br.com.minifinanceiro.models.PessoaJuridica;

import java.util.ArrayList;

public class PessoaJuridicaService {

    PessoaJuridicaDao pessoaJuridicaDao = PessoaJuridicaDao.getInstance();
    private static final PessoaJuridicaService PESSOA_JURIDICA_SERVICE = new PessoaJuridicaService();
    private PessoaJuridicaService(){}
    public static PessoaJuridicaService getInstance(){
        return PESSOA_JURIDICA_SERVICE;
    }

    public ArrayList<PessoaJuridica> retornarListaAll(){
        return pessoaJuridicaDao.getPessoasJuridicas();
    }
    public boolean addPessoaJuridica(PessoaJuridica pessoaJuridica){
        return pessoaJuridicaDao.addPessoaJuridica(pessoaJuridica);
    }
    public PessoaJuridica removePessoaJuridica(int index){
        return pessoaJuridicaDao.removePessoaJuridica(index);
    }

    public PessoaJuridica retornarPessoaJuridicaIndex(int index){
        return pessoaJuridicaDao.retornarPessoaJuridicaIndex(index);
    }

}
