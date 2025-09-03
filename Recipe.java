package org.acme;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Recipe extends PanacheEntity {
    public String nome;
    public String categoria;
    public String ingredientes;
    public String instrucoes;
    public String origem;

    //instrucoes e ingredientes deve ser array

    public Recipe() {
    }

    public Recipe(String nome, String categoria, String ingredientes, String instrucoes, String origem) {
        this.nome = nome;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
        this.instrucoes = instrucoes;
        this.origem = origem;
    }
}
