package br.com.restaurantemobile.model.dominio;

public enum DominioCategoriaCardapio {

    BEBIDAS("bebidas", DominioBebida.values()),
    ENTRADAS("entradas", DominioPratoEntrada.values()),
    PRATOS("pratos", DominioPratoPrincipal.values()),
    SALADAS("saladas", DominioSalada.values()),
    SOBREMESAS("sobremesas", DominioSobremesa.values());

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
