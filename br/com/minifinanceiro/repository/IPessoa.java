package br.com.minifinanceiro.repository;

import br.com.minifinanceiro.models.Pessoa;
import br.com.minifinanceiro.models.PessoaFisica;

public interface IPessoa {

    Pessoa criarPessoa(String nome1, String nome2, String domicilio, String registro);

    public void excluirPessoa();

    public void listarPessoa(int index);

    public void listarPessoasAll();


}
