package br.com.minifinanceiro.dao;

import br.com.minifinanceiro.models.PessoaFisica;

import java.util.ArrayList;

public class PessoaFisicaDao {

    private static ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
    private static final PessoaFisicaDao PESSOA_FISICA_DAO = new PessoaFisicaDao();
    private PessoaFisicaDao(){}
    public static PessoaFisicaDao getInstance(){
        return PESSOA_FISICA_DAO;
    }

    public ArrayList<PessoaFisica> getPessoasFisicas(){return pessoasFisicas;}
    public boolean addPessoaFisica(PessoaFisica pessoaFisica){
        return pessoasFisicas.add(pessoaFisica);
    }
    public PessoaFisica removePessoaFisica(int index){
        return pessoasFisicas.remove(index);
    }
    public PessoaFisica retornarPessoaFisicaIndex(int index){return pessoasFisicas.get(index);}

}
