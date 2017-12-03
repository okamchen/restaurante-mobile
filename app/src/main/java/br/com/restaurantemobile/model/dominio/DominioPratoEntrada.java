package br.com.restaurantemobile.model.dominio;

import br.com.restaurantemobile.R;

public enum DominioPratoEntrada implements ITipoCategoria {

    MINI_BATATINHAS_RECHEADAS("Mini batatinhas recheadas", 1, R.drawable.mini_batatinha_reacheada),
    CHIPS_ABOBRINHA("Chips de abobrinha", 2, R.drawable.chips_de_abobrinha),
    ASPARGO_PRESUNTO_CRU("Aspargo com presunto cru", 3, R.drawable.aspargo_presunto_cru),
    PAO_BATATA("Pão de batata", 4, R.drawable.pao_de_batata),
    FRITAS_CHEDDAR("Fritas com cheddar", 5, R.drawable.fritas_com_cheddar),
    FILE_VIOLINHA("Filé de Violinha", 6, R.drawable.file_de_violinha);

    private String descricao;
    private int codigo;
    private int image;

    DominioPratoEntrada(String descricao, int codigo, int image){
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
