package br.com.restaurantemobile.model.dominio;

/**
 * Created by kone on 10/12/17.
 */

public enum DominioCategoriaCardapio {

    BEBIDAS("bebidas"),
    ENTRADAS("entradas"),
    PRATOS("pratos"),
    SALADAS("saladas"),
    SOBREMESAS("sobremesas");

    private String descricao;

    DominioCategoriaCardapio(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
