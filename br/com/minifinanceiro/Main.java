package br.com.minifinanceiro;

import br.com.minifinanceiro.models.PessoaFisica;

public class Main {

    public static void main(String[] args) {

        PessoaFisica pessoaFisica = new PessoaFisica("Fulano de Tal","Recife, BRA", "da Silva", "04352096314", 'M');
        PessoaFisica pessoaFisica2 = new PessoaFisica("Fulano de Tal","Recife, BRA", "da Silva", "04352096314", 'M');
        PessoaFisica pessoaFisica3 = new PessoaFisica("Fulano de Tal","Recife, BRA", "da Silva", "04352096314", 'M');


        System.out.println(pessoaFisica);
        System.out.println(pessoaFisica2);
        System.out.println(pessoaFisica3);

    }

}
