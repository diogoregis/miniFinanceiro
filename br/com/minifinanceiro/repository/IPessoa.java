package br.com.minifinanceiro.repository;

import br.com.minifinanceiro.models.Pessoa;

public interface IPessoa {

    Pessoa criarPessoa(String nome1, String nome2, String domicilio, String registro);

    public void salvarPessoa();

    public void excluirPessoa();

    public void listarPessoa();

    public void listarPessoasAll();


}
