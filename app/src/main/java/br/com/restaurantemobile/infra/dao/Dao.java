package br.com.restaurantemobile.infra.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.restaurantemobile.infra.DataBaseHelper;

/**
 * Created by Jabel on 09/30/2017.
 */

public abstract class Dao<T> {

    DataBaseHelper dataBaseHelper;

    protected SQLiteDatabase reader;
    protected SQLiteDatabase writer;

    public Dao(Context context){
        this.dataBaseHelper = new DataBaseHelper(context);
        this.reader = dataBaseHelper.getReadableDatabase();
        this.writer = dataBaseHelper.getWritableDatabase();
    }

    abstract void inserir(T t);
    abstract List<T> buscarTodos();
    abstract T buscarPorId(long id);
    abstract void deletar(long id);
}
