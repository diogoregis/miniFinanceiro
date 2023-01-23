    package br.com.minifinanceiro.controllers;

    import br.com.minifinanceiro.models.Pessoa;
    import br.com.minifinanceiro.models.PessoaFisica;
    import br.com.minifinanceiro.repository.IPessoa;
    import br.com.minifinanceiro.services.PessoaFisicaService;
    import br.com.minifinanceiro.tools.Tools;
    import java.util.Scanner;

    public class PessoaFisicaController implements IPessoa {
        Scanner tc = new Scanner(System.in);
        PessoaFisicaService pessoaFisicaService = PessoaFisicaService.getInstance();
        private static final PessoaFisicaController PESSOA_FISICA_CONTROLLER = new PessoaFisicaController();
        private PessoaFisicaController(){}
        public static PessoaFisicaController getInstance(){
            return PESSOA_FISICA_CONTROLLER;
        }


        @Override
        public Pessoa criarPessoa(String nome1, String nome2, String domicilio, String registro) {
            return new PessoaFisica(nome1, nome2, domicilio,registro);
        }

        public void salvarPessoa(PessoaFisica pessoaFisica) {
            if(pessoaFisicaService.addPessoaFisica(pessoaFisica)){
                System.out.println("Adicionado com sucesso !");
            } else {
                System.out.println("!!! ERRO AO TENTAR SALVAR !!!");
            }
        }

        @Override
        public void excluirPessoa() {
            int index;
            PessoaFisica valorAntigo;
            System.out.println(" ");
            listarPessoasAll();
            System.out.println("Qual financeiro deseja excluir ? - informe o numero do index");
            index = Integer.parseInt(tc.nextLine());
            if(index > 0){
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

        private PessoaFisica removerPessoa(int index){
            return pessoaFisicaService.removePessoaFisica(index);
        }

        private boolean validarIndex(PessoaFisica valorAntigo){
            if(valorAntigo == null){
                return false;
            } else {
                return true;
            }
        }
        @Override
        public void listarPessoa(int index) {
            imprimirFormatado(pessoaFisicaService.retornarPessoaFisicaIndex(index));
        }

        @Override
        public void listarPessoasAll() {

            if(!pessoaFisicaService.retornarListaAll().isEmpty()){
                System.out.println(" ");
                System.out.println("-----------------");
                int i = 0;
                for (PessoaFisica pessoa:pessoaFisicaService.retornarListaAll()) {
                    System.out.print(i++ + " ");
                    imprimirFormatado(pessoa);
                    Tools.pause(1);

                }
            }else {
                System.out.println(" ");
                System.out.println("Ainda não existem dados cadastrados");
            }


        }

        private void imprimirFormatado(PessoaFisica pessoaFisica){

            System.out.println(">>> " + pessoaFisica.getNome() + " "+ pessoaFisica.getSobreNome() +
                    " | " + pessoaFisica.getCpf() + " | " + "( " + pessoaFisica.getCidadeDomicilio() + " )");
            System.out.println("-----------------");
        }

        public PessoaFisica retornarPessoaIndex(int index){
            return pessoaFisicaService.retornarPessoaFisicaIndex(index);
        }

        public void salvarForceValidado(PessoaFisica pessoaFisica){
            pessoaFisicaService.addPessoaFisica(pessoaFisica);
        }

    }
