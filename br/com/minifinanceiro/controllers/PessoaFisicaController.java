package br.com.minifinanceiro.controllers;

import br.com.minifinanceiro.models.Pessoa;
import br.com.minifinanceiro.models.PessoaFisica;
import br.com.minifinanceiro.repository.IPessoa;

public class PessoaFisicaController implements IPessoa {

    @Override
    public Pessoa criarPessoa(String nome1, String nome2, String domicilio, String registro) {
        return new PessoaFisica(nome1, nome2, domicilio,registro);
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
