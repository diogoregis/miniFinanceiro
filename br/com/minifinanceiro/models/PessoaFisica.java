package br.com.minifinanceiro.models;

public class PessoaFisica extends Pessoa {

    private String sobreNome;
    private String cpf;
    private char sexo;
    public PessoaFisica(String nome, String cidadeDomicilio, String sobreNome, String cpf, char sexo) {
        super(nome, cidadeDomicilio);
        this.sobreNome = sobreNome;
        this.cpf = cpf;
        this.sexo = sexo;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public void dataDeCadastro(){
        System.out.println(getNome() + " " + getSobreNome());
        System.out.println("Foi cadastro: " + getDataCadastro());
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "ID='" + getId() + '\'' +
                "Nome='" + getNome() + '\'' +
                "sobreNome='" + sobreNome + '\'' +
                "Domicilio='" + getCidadeDomicilio()+ '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}
