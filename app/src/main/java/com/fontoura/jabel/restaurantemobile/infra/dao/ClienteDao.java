package com.fontoura.jabel.restaurantemobile.infra.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.fontoura.jabel.restaurantemobile.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jabel on 09/30/2017.
 */

public class ClienteDao implements Dao<Cliente> {

    private SQLiteDatabase reader;
    private SQLiteDatabase writer;

    public ClienteDao(SQLiteDatabase reader, SQLiteDatabase writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void inserir(Cliente cliente) {
        ContentValues dados = pegaDadosDoCliente(cliente);

        writer.insert("cliente", null, dados);
    }

    @Override
    public List<Cliente> buscarTodos() {
        String sql = "SELECT * FROM cliente;";
        Cursor c = reader.rawQuery(sql, null);

        List<Cliente> clientes = new ArrayList<Cliente>();

        while(c.moveToNext()) {
            Cliente cliente = new Cliente();

            cliente.setId(c.getLong(c.getColumnIndex("id")));
            cliente.setNome(c.getString(c.getColumnIndex("nome")));

            clientes.add(cliente);
        }
        c.close();

        return clientes;
    }

    @Override
    public Cliente buscarPorId(long id) {
        Cursor cursor = reader.rawQuery("SELECT * FROM cliente WHERE Id = ?", new String[]{ Long.toString(id) });
        cursor.moveToNext();

        Cliente cliente = new Cliente();
        cliente.setId(cursor.getLong(cursor.getColumnIndex("id")));
        cliente.setNome(cursor.getString(cursor.getColumnIndex("nome")));

        cursor.close();
        return cliente;
    }

    @Override
    public void deletar(long id) {
        writer.delete("cliente", "id = ?", new String[]{ String.valueOf(id)});
    }

    @NonNull
    private ContentValues pegaDadosDoCliente(Cliente cliente) {
        ContentValues dados = new ContentValues();
        dados.put("id", cliente.getId());
        dados.put("nome", cliente.getNome());
        return dados;
    }
}
