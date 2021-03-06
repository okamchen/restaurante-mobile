package br.com.restaurantemobile.model.dominio;

import br.com.restaurantemobile.R;

public enum DominioBebida implements ITipoCategoria {

    COCA_COLA("Coca Cola", 1 , R.drawable.coca_cola),
    SUCO_LARANJA("Suco de Laranja", 2 , R.drawable.suco_laranja),
    AGUA("Água", 3 , R.drawable.agua),
    AGUA_COM_GAS("Água com Gás", 4 , R.drawable.agua),
    CERVEJA("Cerveja", 5 , R.drawable.cerveja),
    VINHO("Vinho", 6 ,R.drawable.vinho);

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
