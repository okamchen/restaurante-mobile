package br.com.restaurantemobile.model.dominio;

import br.com.restaurantemobile.R;

/**
 * Created by kone on 10/12/17.
 */

public enum DominioCategoriaCardapio {

    BEBIDAS("bebidas", DominioBebida.values()),
    ENTRADAS("entradas", DominioBebida.values()),
    PRATOS("pratos", DominioBebida.values()),
    SALADAS("saladas", DominioBebida.values()),
    SOBREMESAS("sobremesas", DominioBebida.values());

    private String descricao;
    private ITipoCategoria[] tipos;

    DominioCategoriaCardapio(String descricao, ITipoCategoria[] tipos){
        this.descricao = descricao;
        this.tipos = tipos;
    }

    public String getDescricao() {
        return descricao;
    }

    public ITipoCategoria[] getTipos(){
        return tipos;
    }

}
