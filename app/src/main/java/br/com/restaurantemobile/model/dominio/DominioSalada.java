package br.com.restaurantemobile.model.dominio;

import br.com.restaurantemobile.R;

public enum DominioSalada implements ITipoCategoria {

    SALADA_DE_BATATA("Salada de batata", 1, R.drawable.salada_de_batata),
    ALFACE("Alface", 2, R.drawable.alface),
    SALADA_VERDE("Salada verde", 3, R.drawable.salada_verde),
    PEPINO_AGRIDOCE("Pepino Agridoce", 4, R.drawable.pepino_agridoce);

    private String descricao;
    private int codigo;
    private int image;

    DominioSalada(String descricao, int codigo, int image){
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
