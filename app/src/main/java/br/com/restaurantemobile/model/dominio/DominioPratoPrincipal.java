package br.com.restaurantemobile.model.dominio;

import br.com.restaurantemobile.R;

public enum DominioPratoPrincipal implements ITipoCategoria {

    MACARRAO_COM_QUEIJO("Macarrão com queijo", 1, R.drawable.macarra_com_queijo),
    ALAMINUTA("Alaminuta", 2, R.drawable.alaminuta),
    XIZAO("Xizão", 3, R.drawable.xizao),
    STROGONOFE_DE_CARNE("Strogonofe de carne", 4, R.drawable.strogonoff_de_carne);

    private String descricao;
    private int codigo;
    private int image;

    DominioPratoPrincipal(String descricao, int codigo, int image){
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
