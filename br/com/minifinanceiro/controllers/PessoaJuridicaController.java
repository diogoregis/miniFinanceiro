package br.com.minifinanceiro.controllers;

import br.com.minifinanceiro.models.Pessoa;
import br.com.minifinanceiro.models.PessoaJuridica;
import br.com.minifinanceiro.repository.IPessoa;

public class PessoaJuridicaController implements IPessoa {

    private static final PessoaJuridicaController PESSOA_JURIDICA_CONTROLLER = new PessoaJuridicaController();

    private PessoaJuridicaController(){}

    public static PessoaJuridicaController getInstance(){
        return PESSOA_JURIDICA_CONTROLLER;
    }

    @Override
    public Pessoa criarPessoa(String nome1, String nome2, String domicilio, String registro) {
        return new PessoaJuridica(nome1, nome2, domicilio, registro);
    }

    @Override
    public void salvarPessoa() {

    }

    @Override
    public void excluirPessoa() {

    }

    @Override
    public void listarPessoa() {

    }

    @Override
    public void listarPessoasAll() {

    }
}
