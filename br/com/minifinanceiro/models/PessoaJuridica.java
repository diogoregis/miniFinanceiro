package br.com.minifinanceiro.models;

public class PessoaJuridica extends Pessoa{

    private String nomeFantasia;
    private String cnpj;
    private boolean empresaMatriz;

    public PessoaJuridica(String nome, String cidadeDomicilio, String nomeFantasia, String cnpj) {
        super(nome, cidadeDomicilio);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean getEmpresaMatriz() {
        return empresaMatriz;
    }

    protected void setEmpresaMatriz(boolean empresaMatriz) {
        this.empresaMatriz = empresaMatriz;
    }
}
