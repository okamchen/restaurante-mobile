package com.fontoura.jabel.restaurantemobile.model;

import java.io.Serializable;

/**
 * Created by Jabel on 09/23/2017.
 */

public class Cardapio implements Serializable {

    private long id;
    private String descricao;
    private double valor;
    private String categoria;

    public static final String CATEGORIA_BEBIDAS = "bebidas";
    public static final String CATEGORIA_ENTRADAS = "entradas";
    public static final String CATEGORIA_PRATOS = "pratos";
    public static final String CATEGORIA_SALADAS = "saladas";
    public static final String CATEGORIA_SOBREMESAS = "sobremesas";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
