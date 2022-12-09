package com.example.projetofinal.model;

public class Receita {
    private int id;
    private String nome;
    private String ingredientes;
    private String modoPreparo;
    private int idRefeicao;

    public Receita(){

    }

    public Receita(int id, String nome, String ingredientes, String modoPreparo) {
        this.id = id;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
        this.idRefeicao = idRefeicao;

    }

    public int getId() {
        return id;
    }

    public void getByNome(String nome){

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(int idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }
}
