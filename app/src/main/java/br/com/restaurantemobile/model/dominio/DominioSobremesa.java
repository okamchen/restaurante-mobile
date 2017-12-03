package br.com.restaurantemobile.model.dominio;

import br.com.restaurantemobile.R;

public enum DominioSobremesa implements ITipoCategoria {

    TORTA_DE_SORVETE("Torta de sorvete", 1, R.drawable.torta_de_sorvete),
    PUDIM("Pudim", 2, R.drawable.pudim),
    SAGU("Sagu", 3, R.drawable.sagu),
    GELATINA("Gelatina", 4, R.drawable.gelatina);

    private String descricao;
    private int codigo;
    private int image;

    DominioSobremesa(String descricao, int codigo, int image){
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
