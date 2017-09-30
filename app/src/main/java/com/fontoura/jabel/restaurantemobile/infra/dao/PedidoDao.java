package com.fontoura.jabel.restaurantemobile.infra.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fontoura.jabel.restaurantemobile.model.Cliente;
import com.fontoura.jabel.restaurantemobile.model.Pedido;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jabel on 09/30/2017.
 */

public class PedidoDao implements Dao<Pedido> {

    private SQLiteDatabase reader;
    private SQLiteDatabase writer;

    public PedidoDao(SQLiteDatabase reader, SQLiteDatabase writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void inserir(Pedido pedido) {
        writer.insert("pedido", null, pegaDadosDoCliente(pedido));
    }

    private ContentValues pegaDadosDoCliente(Pedido pedido) {
        ContentValues dados = new ContentValues();
        dados.put("id", pedido.getId());
        dados.put("id_cliente", pedido.getCliente().getId());
        dados.put("valor_total", pedido.getValor_total());
        dados.put("mesa", pedido.getMesa());
        dados.put("data", pedido.getData().toString());

        return dados;
    }

    @Override
    public List<Pedido> buscarTodos() {
        String sql = "SELECT * FROM pedido;";
        Cursor c = reader.rawQuery(sql, null);

        List<Pedido> pedidos = new ArrayList<Pedido>();

        while(c.moveToNext()) {

            pedidos.add(montarPedido(c));
        }
        c.close();

        return pedidos;
    }

    public List<Pedido> buscarPorCliente(Cliente cliente) {
        Cursor cursor = reader.rawQuery("SELECT * FROM pedido WHERE Id_cliente = ?", new String[]{ Long.toString(cliente.getId()) });

        List<Pedido> pedidos = new ArrayList<Pedido>();

        while(cursor.moveToNext()) {

            pedidos.add(montarPedido(cursor));
        }

        cursor.close();
        return pedidos;
    }

    @Override
    public Pedido buscarPorId(long id) {
        Cursor cursor = reader.rawQuery("SELECT * FROM pedido WHERE Id = ?", new String[]{ Long.toString(id) });
        cursor.moveToNext();

        Pedido pedido = montarPedido(cursor);

        cursor.close();
        return pedido;
    }

    @Override
    public void deletar(long id) {
        writer.delete("pedido", "id = ?", new String[]{ String.valueOf(id)});
    }

    public Pedido montarPedido(Cursor c) {
        Pedido pedido = new Pedido();

        pedido.setId(c.getLong(c.getColumnIndex("id")));
        pedido.setCliente(new ClienteDao(reader, writer).buscarPorId(c.getLong(c.getColumnIndex("id_cliente"))));
        pedido.setData(new Date(c.getLong(c.getColumnIndex("data"))));
        pedido.setMesa(c.getLong(c.getColumnIndex("mesa")));
        pedido.setValor_total(c.getDouble(c.getColumnIndex("valor")));

        return pedido;
    }
}
