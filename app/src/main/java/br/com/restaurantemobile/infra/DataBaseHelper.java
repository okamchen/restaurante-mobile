package br.com.restaurantemobile.infra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.restaurantemobile.model.dominio.DominioBebida;
import br.com.restaurantemobile.model.dominio.DominioCategoriaCardapio;
import br.com.restaurantemobile.model.dominio.DominioPratoEntrada;
import br.com.restaurantemobile.model.dominio.DominioPratoPrincipal;
import br.com.restaurantemobile.model.dominio.DominioSalada;
import br.com.restaurantemobile.model.dominio.DominioSobremesa;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "restaurateMobile.db";
    private static final int DATABASE_VERSION = 16;

    private static  final String TABLE_CLIENTE = "cliente";
    private static  final String TABLE_CARDAPIO = "cardapio";
    private static  final String TABLE_PEDIDO = "pedido";
    private static  final String TABLE_PEDIDO_CARDAPIO = "pedido_cardapio";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        runMigrationsVersion(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int ondVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEDIDO_CARDAPIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARDAPIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEDIDO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTE);
        onCreate(db);
    }

    public void runMigrationsVersion(SQLiteDatabase db){

        StringBuilder sbCliente = new StringBuilder();

        sbCliente.append("CREATE TABLE " + TABLE_CLIENTE + " (");
        sbCliente.append("id integer PRIMARY KEY AUTOINCREMENT,");
        sbCliente.append("nome varchar);");

        db.execSQL(sbCliente.toString());

        StringBuilder sbPedido = new StringBuilder();

        sbPedido.append("CREATE TABLE " +TABLE_PEDIDO+ " ( ");
        sbPedido.append("id integer PRIMARY KEY AUTOINCREMENT, ");
        sbPedido.append("id_cliente integer, ");
        sbPedido.append("mesa integer, ");
        sbPedido.append("data date,");
        sbPedido.append("valor_total decimal);");

        db.execSQL(sbPedido.toString());

        StringBuilder sbCardapio = new StringBuilder();

        sbCardapio.append("CREATE TABLE " + TABLE_CARDAPIO + " (");
        sbCardapio.append("id integer PRIMARY KEY AUTOINCREMENT,");
        sbCardapio.append("codigo integer,");
        sbCardapio.append("descricao varchar,");
        sbCardapio.append("valor decimal,");
        sbCardapio.append("categoria varchar);");

        db.execSQL(sbCardapio.toString());

        StringBuilder sbPedidoCardapio = new StringBuilder();

        sbPedidoCardapio .append("CREATE TABLE "+ TABLE_PEDIDO_CARDAPIO + " (");
        sbPedidoCardapio .append("id_pedido integer,");
        sbPedidoCardapio .append("id_cardapio integer,");
        sbPedidoCardapio .append("quantidade integer);");

        db.execSQL(sbPedidoCardapio.toString());

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", '" + DominioBebida.COCA_COLA.getDescricao() + "', 3.50, '" + DominioCategoriaCardapio.BEBIDAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.SUCO_LARANJA.getCodigo() +", '" + DominioBebida.SUCO_LARANJA.getDescricao() + "', 4.50, '" + DominioCategoriaCardapio.BEBIDAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.AGUA.getCodigo() +", '" + DominioBebida.AGUA.getDescricao() + "', 2.50, '" + DominioCategoriaCardapio.BEBIDAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.AGUA_COM_GAS.getCodigo() +", '" + DominioBebida.AGUA_COM_GAS.getDescricao() + "', 2.50, '" + DominioCategoriaCardapio.BEBIDAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.CERVEJA.getCodigo() +", '" + DominioBebida.CERVEJA.getDescricao() + "', 6.50, '" + DominioCategoriaCardapio.BEBIDAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.VINHO.getCodigo() +", '" + DominioBebida.VINHO.getDescricao() + "', 10.0, '" + DominioCategoriaCardapio.BEBIDAS + "');");

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoEntrada.MINI_BATATINHAS_RECHEADAS.getCodigo() +", '" + DominioPratoEntrada.MINI_BATATINHAS_RECHEADAS.getDescricao() + "', 11, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoEntrada.CHIPS_ABOBRINHA.getCodigo() +", '" + DominioPratoEntrada.CHIPS_ABOBRINHA.getDescricao() + "', 9.75, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoEntrada.ASPARGO_PRESUNTO_CRU.getCodigo() +", '" + DominioPratoEntrada.ASPARGO_PRESUNTO_CRU.getDescricao() + "', 17.50, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoEntrada.PAO_BATATA.getCodigo() +", '" + DominioPratoEntrada.PAO_BATATA.getDescricao() + "', 3.50, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoEntrada.FRITAS_CHEDDAR.getCodigo() +", '" + DominioPratoEntrada.FRITAS_CHEDDAR.getDescricao() + "', 10.00, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoEntrada.FILE_VIOLINHA.getCodigo() +", '" + DominioPratoEntrada.FILE_VIOLINHA.getDescricao() + "', 10.00, '" + DominioCategoriaCardapio.ENTRADAS + "');");

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoPrincipal.MACARRAO_COM_QUEIJO.getCodigo() +", '" + DominioPratoPrincipal.MACARRAO_COM_QUEIJO.getDescricao() + "', 12, '" + DominioCategoriaCardapio.PRATOS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoPrincipal.ALAMINUTA.getCodigo() +", '" + DominioPratoPrincipal.ALAMINUTA.getDescricao() + "', 16.75, '" + DominioCategoriaCardapio.PRATOS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoPrincipal.XIZAO.getCodigo() +", '" + DominioPratoPrincipal.XIZAO.getDescricao() + "', 13.75, '" + DominioCategoriaCardapio.PRATOS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioPratoPrincipal.STROGONOFE_DE_CARNE.getCodigo() +", '" + DominioPratoPrincipal.STROGONOFE_DE_CARNE.getDescricao() + "', 15.75, '" + DominioCategoriaCardapio.PRATOS + "');");

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioSalada.SALADA_DE_BATATA.getCodigo() +", '" + DominioSalada.SALADA_DE_BATATA.getDescricao() + "', 8.75, '" + DominioCategoriaCardapio.SALADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioSalada.ALFACE.getCodigo() +", '" + DominioSalada.ALFACE.getDescricao() + "', 5.75, '" + DominioCategoriaCardapio.SALADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioSalada.SALADA_VERDE.getCodigo() +", '" + DominioSalada.SALADA_VERDE.getDescricao() + "', 5.75, '" + DominioCategoriaCardapio.SALADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioSalada.PEPINO_AGRIDOCE.getCodigo() +", '" + DominioSalada.PEPINO_AGRIDOCE.getDescricao() + "', 5.75, '" + DominioCategoriaCardapio.SALADAS + "');");

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioSobremesa.TORTA_DE_SORVETE.getCodigo() +", '" + DominioSobremesa.TORTA_DE_SORVETE.getDescricao() + "', 4.75, '" + DominioCategoriaCardapio.SOBREMESAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioSobremesa.PUDIM.getCodigo() +", '" + DominioSobremesa.PUDIM.getDescricao() + "', 2.75, '" + DominioCategoriaCardapio.SOBREMESAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioSobremesa.SAGU.getCodigo() +", '" + DominioSobremesa.SAGU.getDescricao() + "', 3.25, '" + DominioCategoriaCardapio.SOBREMESAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioSobremesa.GELATINA.getCodigo() +", '" + DominioSobremesa.GELATINA.getDescricao() +"', 1.75, '" + DominioCategoriaCardapio.SOBREMESAS + "');");

    }
}