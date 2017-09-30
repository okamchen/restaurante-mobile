package com.fontoura.jabel.restaurantemobile.model;

import java.io.Serializable;

/**
 * Created by Jabel on 09/23/2017.
 */

public class Cliente implements Serializable {

    private long id;
    private String nome;

    public Cliente(String nome){
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
