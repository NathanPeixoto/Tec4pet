package br.com.tec4me.tec4pet.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pet {
    private String id;
    private String nome;
    private String raca;
    private int anoDeNascimento;
    private boolean vacinado;
    private List<String> procedimentos;
    
    
    public List<String> getProcedimentos() {
        return procedimentos;
    }
    public void setProcedimentos(List<String> procedimentos) {
        this.procedimentos = procedimentos;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }
    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }
    public boolean isVacinado() {
        return vacinado;
    }
    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }
}
    
