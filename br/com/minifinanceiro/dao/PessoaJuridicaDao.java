package br.com.minifinanceiro.dao;

import br.com.minifinanceiro.models.PessoaJuridica;

import java.util.ArrayList;

public class PessoaJuridicaDao {

    private static ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();
    private static final PessoaJuridicaDao PESSOA_JURIDICA_DAO = new PessoaJuridicaDao();
    private PessoaJuridicaDao(){}
    public static PessoaJuridicaDao getInstance(){
        return PESSOA_JURIDICA_DAO;
    }

    public ArrayList<PessoaJuridica> getPessoasJuridicas(){return pessoasJuridicas;}
    public boolean addPessoaJuridica(PessoaJuridica PessoaJuridica){
        return pessoasJuridicas.add(PessoaJuridica);
    }
    public PessoaJuridica removePessoaJuridica(int index){
        return pessoasJuridicas.remove(index);
    }
    public PessoaJuridica retornarPessoaJuridicaIndex(int index){return pessoasJuridicas.get(index);}

}
