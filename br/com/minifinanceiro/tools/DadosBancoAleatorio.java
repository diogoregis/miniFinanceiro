package br.com.minifinanceiro.tools;

import br.com.minifinanceiro.controllers.FinanceiroController;
import br.com.minifinanceiro.controllers.PessoaFisicaController;
import br.com.minifinanceiro.controllers.PessoaJuridicaController;
import br.com.minifinanceiro.models.PessoaFisica;
import br.com.minifinanceiro.models.PessoaJuridica;

import java.util.Random;

public class DadosBancoAleatorio {

    public void criarDadosAll(){
        popularPessoaFisica();
        popularPessoaJuridica();
        popularFinanceiro();
    }

    public void popularPessoaFisica(){
        for(int i = 0; nomes1.length > i; i++ ){
            int y = aleatorio.nextInt(4);
            int x = aleatorio.nextInt(4);
            int q = aleatorio.nextInt(4);
            int w = aleatorio.nextInt(4);
            PessoaFisica pessoa = (PessoaFisica) pessoaFisica.criarPessoa(nomes1[y], nomes2[x], domicilios[q], cpf[w]);
            pessoaFisica.salvarForceValidado(pessoa);
        }
    }

    public void popularPessoaJuridica(){
        for(int i = 0; nomes3.length > i; i++ ){
            int y = aleatorio.nextInt(4);
            int x = aleatorio.nextInt(4);
            int q = aleatorio.nextInt(4);
            int w = aleatorio.nextInt(4);
            PessoaJuridica pessoa = (PessoaJuridica) pessoaJuridica.criarPessoa(nomes3[y], nomes4[x], domicilios[q], cnpj[w]);
            pessoaJuridica.salvarForceValidado(pessoa);
        }
    }

    private void popularFinanceiro() {

        for(int i = 0; descricoes.length > i; i++ ){
            int y = aleatorio.nextInt(3);
            double x = 1 + aleatorio.nextDouble(2612);
            financeiro.salvarForceValidado(financeiro.criarFinanceiro(descricoes[y],pessoaJuridica.retornarPessoaIndex(y),x));

        }

    }


    private static final DadosBancoAleatorio DADOS_BANCO_ALEATORIO = new DadosBancoAleatorio();
    private DadosBancoAleatorio(){}

    public static DadosBancoAleatorio getInstance(){
        return DADOS_BANCO_ALEATORIO;
    }
    private PessoaFisicaController pessoaFisica= PessoaFisicaController.getInstance();
    private PessoaJuridicaController pessoaJuridica = PessoaJuridicaController.getInstance();
    private FinanceiroController financeiro = FinanceiroController.getInstance();
    private Random aleatorio = new Random();
    private String nomes1[] = {"Bebeto", "Romario", "Cristiane", "Marta"};
    private String nomes2[] = {"da Silva", "Soares", "Belmonte", "Malbec"};
    private String nomes3[] = {"Castro Brother Comercio LTDA", " C J BEZERRA LTDA", "Belmonte Ind e Comercio EPP", "SUPER CASSIO EPP"};
    private String nomes4[] = {"Supermercado Bela Compra", "Flores Atacadista", "TendTudo", "Varejo São Luiz"};
    private String cpf[] = {"084.835.963-89", "123.963.741-98", "023.450.563-01", "009.484.400-30" };
    private String cnpj[] = {"23.723.401/0001-75", "77.232.604/0001-98", "30.117.515/0001-37", "09.118.957/0001-01" };
    private String domicilios[] = {"Berlin, GEA", "Boston, USA", "São Paulo, BRA", "Recife, BRA", "Paris, FRA", "Olinda, BRA", "San Francisco, USA"};
    private String descricoes[] = {"Conta de Energia", "Duplicata Mercantil", "Conta de Internet"};

}
