package br.com.minifinanceiro.models;

public class PessoaJuridica extends Pessoa{

    private String nomeFantasia;
    private String cnpj;
    private char tipoRegimeTributario;

    public PessoaJuridica(String nome, String cidadeDomicilio, String nomeFantasia, String cnpj, char tipoRegimeTributario) {
        super(nome, cidadeDomicilio);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.tipoRegimeTributario = tipoRegimeTributario;
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

    public char getTipoRegimeTributario() {
        return tipoRegimeTributario;
    }

    public void setTipoRegimeTributario(char tipoRegimeTributario) {
        this.tipoRegimeTributario = tipoRegimeTributario;
    }
}
