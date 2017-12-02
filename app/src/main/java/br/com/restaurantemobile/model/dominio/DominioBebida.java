package br.com.restaurantemobile.model.dominio;

import br.com.restaurantemobile.R;

public enum DominioBebida implements ITipoCategoria {

    COCA_COLA("Coca Cola", 1 , R.drawable.coca_cola),
    AGUA("Água", 2 , R.drawable.salada),
    CERVEJA("Cerveja", 3 , R.drawable.salada),
    VINHO("Vinho", 4 ,R.drawable.salada);

    private String descricao;
    private int codigo;
    private int image;

    DominioBebida(String descricao, int codigo, int image){
        this.descricao = descricao;
        this.codigo = codigo;
        this.image = image;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public int getImage(){ return image; }

    @Override
    public int getCodigo() {
        return codigo;
    }
}
