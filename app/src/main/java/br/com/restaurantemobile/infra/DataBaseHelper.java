package br.com.restaurantemobile.infra;

/**
 * Created by Jabel on 09/23/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.restaurantemobile.model.dominio.DominioBebida;
import br.com.restaurantemobile.model.dominio.DominioCategoriaCardapio;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "restaurateMobile.db";
    private static final int DATABASE_VERSION = 10;

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

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Coca-Cola', 3.50, '" + DominioCategoriaCardapio.BEBIDAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Suco de Laranja', 4.50, '" + DominioCategoriaCardapio.BEBIDAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Água', 0, '" + DominioCategoriaCardapio.BEBIDAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Água com gás', 2.50, '" + DominioCategoriaCardapio.BEBIDAS + "');");

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Mini batatinhas recheadas', 11, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Chips de abobrinha', 9.75, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Aspargo com presunto cru', 17.50, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Pão de batata', 3.50, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Fritas com cheddar', 10.00, '" + DominioCategoriaCardapio.ENTRADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Filé de Violinha', 10.00, '" + DominioCategoriaCardapio.ENTRADAS + "');");

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Macarrão com queijo', 12, '" + DominioCategoriaCardapio.PRATOS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Alaminuta', 16.75, '" + DominioCategoriaCardapio.PRATOS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Xizão', 13.75, '" + DominioCategoriaCardapio.PRATOS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Strogonofe de carne', 15.75, '" + DominioCategoriaCardapio.PRATOS + "');");

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Salada de batata', 8.75, '" + DominioCategoriaCardapio.SALADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Alface', 5.75, '" + DominioCategoriaCardapio.SALADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Salada verde', 5.75, '" + DominioCategoriaCardapio.SALADAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Pepino em conserva', 5.75, '" + DominioCategoriaCardapio.SALADAS + "');");

        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Torta de sorvete', 4.75, '" + DominioCategoriaCardapio.SOBREMESAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Pudim', 2.75, '" + DominioCategoriaCardapio.SOBREMESAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Sagu', 3.25, '" + DominioCategoriaCardapio.SOBREMESAS + "');");
        db.execSQL("INSERT INTO cardapio (codigo, descricao, valor, categoria) VALUES(" + DominioBebida.COCA_COLA.getCodigo() +", 'Gelatina', 1.75, '" + DominioCategoriaCardapio.SOBREMESAS + "');");

    }
}















