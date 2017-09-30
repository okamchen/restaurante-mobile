package com.fontoura.jabel.restaurantemobile.infra.dao;

import android.database.sqlite.SQLiteDatabase;

import com.fontoura.jabel.restaurantemobile.model.Cardapio;

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

    }

    @Override
    public List<Cardapio> buscarTodos() {
        return null;
    }

    @Override
    public Cardapio buscarPorId(long id) {
        return null;
    }

    @Override
    public void deletar(long id) {

    }
}
