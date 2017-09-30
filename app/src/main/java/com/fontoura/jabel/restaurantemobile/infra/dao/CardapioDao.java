package com.fontoura.jabel.restaurantemobile.infra.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fontoura.jabel.restaurantemobile.model.Cardapio;
import com.fontoura.jabel.restaurantemobile.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jabel on 09/30/2017.
 */

public class CardapioDao implements Dao<Cardapio> {

    private SQLiteDatabase reader;
    private SQLiteDatabase writer;

    public CardapioDao(SQLiteDatabase reader, SQLiteDatabase writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void insert(Cardapio cardapio) {
        ContentValues dados = pegaDadosDoCardapio(cardapio);

        writer.insert("cardapio", null, dados);
    }

    private ContentValues pegaDadosDoCardapio(Cardapio cardapio) {
        ContentValues dados = new ContentValues();
        dados.put("id", cardapio.getId());
        dados.put("descricao", cardapio.getDescricao());
        dados.put("categoria", cardapio.getCategoria());
        dados.put("valor", cardapio.getValor());

        return dados;
    }

    @Override
    public List<Cardapio> buscarTodos() {
        String sql = "SELECT * FROM cardapio;";
        Cursor c = reader.rawQuery(sql, null);

        List<Cardapio> listaCardapio = new ArrayList<Cardapio>();

        while(c.moveToNext()) {
            Cardapio cardapio = new Cardapio();

            cardapio.setId(c.getLong(c.getColumnIndex("id")));
            cardapio.setDescricao(c.getString(c.getColumnIndex("descricao")));
            cardapio.setCategoria(c.getString(c.getColumnIndex("categoria")));
            cardapio.setValor(c.getDouble(c.getColumnIndex("valor")));

            listaCardapio.add(cardapio);
        }
        c.close();

        return listaCardapio;
    }

    public List<Cardapio> buscarPorCategoria(String categoria) {
        Cursor c = reader.rawQuery("SELECT * FROM cardapio WHERE categoria = ?", new String[]{ categoria });

        List<Cardapio> listaCardapio = new ArrayList<Cardapio>();

        while(c.moveToNext()) {
            Cardapio cardapio = new Cardapio();

            cardapio.setId(c.getLong(c.getColumnIndex("id")));
            cardapio.setDescricao(c.getString(c.getColumnIndex("descricao")));
            cardapio.setCategoria(c.getString(c.getColumnIndex("categoria")));
            cardapio.setValor(c.getDouble(c.getColumnIndex("valor")));

            listaCardapio.add(cardapio);
        }
        c.close();

        return listaCardapio;
    }

    @Override
    public Cardapio buscarPorId(long id) {
        Cursor c = reader.rawQuery("SELECT * FROM cardapio WHERE Id = ?", new String[]{ Long.toString(id) });
        c.moveToNext();

        Cardapio cardapio = new Cardapio();

        cardapio.setId(c.getLong(c.getColumnIndex("id")));
        cardapio.setDescricao(c.getString(c.getColumnIndex("descricao")));
        cardapio.setCategoria(c.getString(c.getColumnIndex("categoria")));
        cardapio.setValor(c.getDouble(c.getColumnIndex("valor")));

        c.close();
        return cardapio;
    }

    @Override
    public void deletar(long id) {
        writer.delete("cardapio", "id = ?", new String[]{ String.valueOf(id)});
    }
}
