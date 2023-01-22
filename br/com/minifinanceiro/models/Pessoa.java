package br.com.minifinanceiro.models;

import java.util.Calendar;
import java.util.Date;

public abstract class Pessoa {

    private static int numId;

    private final int id;
    private String nome;
    private String cidadeDomicilio;
    private Date dataCadastro;
    private boolean cadastroAtivo = true;

    private static int proximoNum(){
        return ++numId;
    }

    protected Pessoa(String nome, String cidadeDomicilio) {
        this.id = proximoNum();
        this.nome = nome;
        this.cidadeDomicilio = cidadeDomicilio;
        this.dataCadastro = Calendar.getInstance().getTime();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidadeDomicilio() {
        return cidadeDomicilio;
    }

    public void setCidadeDomicilio(String cidadeDomicilio) {
        this.cidadeDomicilio = cidadeDomicilio;
    }

    protected Date getDataCadastro(){
        return dataCadastro;
    }

    public boolean isCadastroAtivo() {
        return cadastroAtivo;
    }

    public void setCadastroAtivo(boolean cadastroAtivo) {
        this.cadastroAtivo = cadastroAtivo;
    }

    protected void dataDeCadastro (){

    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cidadeDomicilio='" + cidadeDomicilio + '\'' +
                '}';
    }
}
