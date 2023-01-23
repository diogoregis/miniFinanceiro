package br.com.minifinanceiro.controllers;

import br.com.minifinanceiro.models.Pessoa;
import br.com.minifinanceiro.models.PessoaJuridica;
import br.com.minifinanceiro.repository.IPessoa;
import br.com.minifinanceiro.services.PessoaJuridicaService;
import br.com.minifinanceiro.tools.Tools;

import java.util.Scanner;

public class PessoaJuridicaController implements IPessoa {

    Scanner tc = new Scanner(System.in);

    PessoaJuridicaService pessoaJuridicaService = PessoaJuridicaService.getInstance();
    private static final PessoaJuridicaController PESSOA_JURIDICA_CONTROLLER = new PessoaJuridicaController();
    private PessoaJuridicaController(){}

    public static PessoaJuridicaController getInstance(){
        return PESSOA_JURIDICA_CONTROLLER;
    }

    @Override
    public Pessoa criarPessoa(String nome1, String nome2, String domicilio, String registro) {
        return new PessoaJuridica(nome1, nome2, domicilio, registro);
    }
    public void salvarPessoa(PessoaJuridica pessoaJuridica) {
        if(pessoaJuridicaService.addPessoaJuridica(pessoaJuridica)){
            System.out.println("Adicionado com sucesso !");
        } else {
            System.out.println("!!! ERRO AO TENTAR SALVAR !!!");
        }
    }

    @Override
    public void excluirPessoa() {
        int index;
        PessoaJuridica valorAntigo;
        System.out.println("");
        System.out.println("Qual deseja excluir ? - informe o numero do index");
        listarPessoasAll();
        index = Integer.parseInt(tc.nextLine());
        if(index < 0){
            valorAntigo = removerPessoa(index);
            if(validarIndex(valorAntigo)){
                System.out.println(" ");
                System.out.println("Sucesso, " + valorAntigo.getNome() + ", foi excluido");
                System.out.println(" ");
            } else {
                System.out.println(" ");
                System.out.println("Index não encontrado");
                System.out.println(" ");
            }

        } else{
            System.out.println("Tente um valor maior que 0 (zero), na proxima");
        }
    }

    private PessoaJuridica removerPessoa(int index){
        return pessoaJuridicaService.removePessoaJuridica(index);
    }

    private boolean validarIndex(PessoaJuridica valorAntigo){
        if(valorAntigo == null){
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void listarPessoa(int index) {
        imprimirFormatado(pessoaJuridicaService.retornarPessoaJuridicaIndex(index));
    }

    @Override
    public void listarPessoasAll() {

        if(!pessoaJuridicaService.retornarListaAll().isEmpty()){
            System.out.println(" ");
            System.out.println("-----------------");
            for (PessoaJuridica pessoa:pessoaJuridicaService.retornarListaAll()) {
                imprimirFormatado(pessoa);
                Tools.pause(1);
            }
        }else {
            System.out.println(" ");
            System.out.println("Ainda não existem dados cadastrados");
        }


    }

    private void imprimirFormatado(PessoaJuridica pessoaJuridica){

        System.out.println(">>> " + pessoaJuridica.getNome() + " | " + "Fornecedor: "+ pessoaJuridica.getNomeFantasia() +
                " | " + pessoaJuridica.getCnpj() + " | " + "( " + pessoaJuridica.getCidadeDomicilio() + " )");
        System.out.println("-----------------");
    }

    public Pessoa retornarPessoaIndex(int index) {
        return pessoaJuridicaService.retornarPessoaJuridicaIndex(index);
    }

    public void salvarForceValidado(PessoaJuridica pessoa) {
        pessoaJuridicaService.addPessoaJuridica(pessoa);
    }
}
