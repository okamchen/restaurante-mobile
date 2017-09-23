package com.fontoura.jabel.restaurantemobile;

/**
 * Created by Jabel on 09/23/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "restaurateMobile.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        StringBuilder cmd = new StringBuilder();
        cmd.append("CREATE TABLE pedido ( ");
        cmd.append("id integer PRIMARY KEY AUTOINCREMENT, ");
        cmd.append("id_cliente integer, ");
        cmd.append("mesa integer, ");
        cmd.append("data date,");
        cmd.append("valor_total decimal);");

        cmd.append("CREATE TABLE cliente (");
        cmd.append("id integer PRIMARY KEY AUTOINCREMENT,");
        cmd.append("nome varchar PRIMARY KEY AUTOINCREMENT);");

        cmd.append("CREATE TABLE cardapio (");
        cmd.append("id integer PRIMARY KEY AUTOINCREMENT,");
        cmd.append("descricao varchar,");
        cmd.append("valor decimal,");
        cmd.append("categoria varchar);");

        cmd.append("CREATE TABLE pedido_cardapio (");
        cmd.append("id_pedido integer,");
        cmd.append("id_cardapio integer,");
        cmd.append("quantidade integer);");

        database.execSQL(cmd.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

//        switch (oldVersion) {
//            case 1:
//                database.execSQL("alter table clientes add column dtNascimento timestamp;");
//
//            case 2:
//                database.execSQL("alter table clientes add column tpSexo char( 1 );");
//
//            case 4:
//                database.execSQL("alter table clientes add column tpPessoa char( 1 );");
//                database.execSQL("alter table clientes add column cdCpfCnpj varchar( 15 );");
//        }
    }
}















