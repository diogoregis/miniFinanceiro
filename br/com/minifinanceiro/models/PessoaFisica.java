package br.com.minifinanceiro.models;

public class PessoaFisica extends Pessoa {

    private String sobreNome;
    private String cpf;
    public PessoaFisica(String nome, String sobreNome, String cidadeDomicilio,  String cpf) {
        super(nome, cidadeDomicilio);
        this.sobreNome = sobreNome;
        this.cpf = cpf;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "ID='" + getId() + '\'' +
                "Nome='" + getNome() + '\'' +
                "sobreNome='" + sobreNome + '\'' +
                "Domicilio='" + getCidadeDomicilio()+ '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
