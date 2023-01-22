package br.com.minifinanceiro.models;

public class EmpresaProprio extends PessoaJuridica{

    private static final EmpresaProprio EMPRESA_PROPRIO = new EmpresaProprio("Exxon Mobil Corporation","Boston, USA", "Exxon Mobil Corporation", "21.036.324/0001-09" );
    private EmpresaProprio(String nome, String cidadeDomicilio, String nomeFantasia, String cnpj) {
        super(nome, cidadeDomicilio, nomeFantasia, cnpj);
        setEmpresaMatriz(true);
    }

    public static EmpresaProprio getInstance(){
        return EMPRESA_PROPRIO;
    }
}
