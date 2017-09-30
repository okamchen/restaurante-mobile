package com.fontoura.jabel.restaurantemobile.infra;

/**
 * Created by Jabel on 09/23/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

import com.fontoura.jabel.restaurantemobile.infra.dao.Dao;
import com.fontoura.jabel.restaurantemobile.model.Cardapio;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "restaurateMobile.db";
    private static final int DATABASE_VERSION = 2;
    private Dao dao;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        context.deleteDatabase(DATABASE_NAME);
        System.out.println("deletado");
    }

    public void insert() {

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        StringBuilder cmd = new StringBuilder();
        cmd.append("CREATE TABLE cliente (");
        cmd.append("id integer PRIMARY KEY AUTOINCREMENT,");
        cmd.append("nome varchar);");

        cmd.append("CREATE TABLE pedido ( ");
        cmd.append("id integer PRIMARY KEY AUTOINCREMENT, ");
        cmd.append("id_cliente integer, ");
        cmd.append("mesa integer, ");
        cmd.append("data date,");
        cmd.append("valor_total decimal);");

        cmd.append("CREATE TABLE cardapio (");
        cmd.append("id integer PRIMARY KEY AUTOINCREMENT,");
        cmd.append("descricao varchar,");
        cmd.append("valor decimal,");
        cmd.append("categoria varchar);");

        cmd.append("CREATE TABLE pedido_cardapio (");
        cmd.append("id_pedido integer,");
        cmd.append("id_cardapio integer,");
        cmd.append("quantidade integer);");

        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Coca-Cola', 3.50, " + Cardapio.CATEGORIA_BEBIDAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Suco de Laranja', 4.50, " + Cardapio.CATEGORIA_BEBIDAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Água', 0, " + Cardapio.CATEGORIA_BEBIDAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Água com gás', 2.50, " + Cardapio.CATEGORIA_BEBIDAS + ");");

        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Mini batatinhas recheadas', 11, " + Cardapio.CATEGORIA_ENTRADAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Chips de abobrinha', 9.75, " + Cardapio.CATEGORIA_ENTRADAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Aspargo com presunto cru', 17.50, " + Cardapio.CATEGORIA_ENTRADAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Pão de batata', 3.50, " + Cardapio.CATEGORIA_ENTRADAS + ");");

        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Macarrão com queijo', 12, " + Cardapio.CATEGORIA_PRATOS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Alaminuta', 16.75, " + Cardapio.CATEGORIA_PRATOS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Xizão', 13.75, " + Cardapio.CATEGORIA_PRATOS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Strogonofe de carne', 15.75, " + Cardapio.CATEGORIA_PRATOS + ");");

        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Salada de batata', 8.75, " + Cardapio.CATEGORIA_SALADAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Alface', 5.75, " + Cardapio.CATEGORIA_SALADAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Salada verde', 5.75, " + Cardapio.CATEGORIA_SALADAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Pepino em conserva', 5.75, " + Cardapio.CATEGORIA_SALADAS + ");");

        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Torta de sorvete', 4.75, " + Cardapio.CATEGORIA_SOBREMESAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Pudim', 2.75, " + Cardapio.CATEGORIA_SOBREMESAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Sagu', 3.25, " + Cardapio.CATEGORIA_SOBREMESAS + ");");
        cmd.append("INSERT INTO cardapio (descricao, valor, categoria) VALUES('Gelatina', 1.75, " + Cardapio.CATEGORIA_SOBREMESAS + ");");


        database.execSQL(cmd.toString());
        System.out.println("criado");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
    }
}















