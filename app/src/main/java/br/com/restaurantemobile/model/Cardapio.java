package br.com.restaurantemobile.model;

import java.io.Serializable;

/**
 * Created by Jabel on 09/23/2017.
 */

public class Cardapio implements Serializable {

    public static String TABLE_NAME = "Cardapio";
    public static String[] TABLE_COLUMNS =  {"id", "descricao", "valor", "categoria"};

    private long id;
    private String descricao;
    private double valor;
    private String categoria;

    public Cardapio(){
        super();
    }

    public Cardapio(long id, String descricao, double valor, String categoria){
        super();
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

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