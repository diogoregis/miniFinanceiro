package br.com.minifinanceiro.services;

import br.com.minifinanceiro.repository.IPessoa;

public class PessoaFisicaService {

    private static final PessoaFisicaService PESSOA_FISICA_SERVICE = new PessoaFisicaService();
    private PessoaFisicaService(){}
    public static PessoaFisicaService getInstance(){
        return PESSOA_FISICA_SERVICE;
    }

    

}
