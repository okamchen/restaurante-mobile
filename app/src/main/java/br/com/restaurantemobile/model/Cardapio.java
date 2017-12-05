package br.com.restaurantemobile.model;

import java.io.Serializable;

public class Cardapio implements Serializable {

    public static String TABLE_NAME = "Cardapio";
    public static String[] TABLE_COLUMNS =  {"id", "codigo",  "descricao", "valor", "categoria"};

    private long id;
    private int codigo;
    private String descricao;
    private double valor;
    private String categoria;

    public Cardapio(){
        super();
    }

    public static Cardapio clone(Cardapio cardapio){
        return new Cardapio(cardapio.getId(), cardapio.getCodigo(), cardapio.getDescricao(), cardapio.getValor(), cardapio.getCategoria());
    }

    public Cardapio(long id, int codigo, String descricao, double valor, String categoria){
        super();
        this.id = id;
        this.codigo = codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
