package br.com.restaurantemobile.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.restaurantemobile.model.Cardapio;
import br.com.restaurantemobile.model.dominio.DominioCategoriaCardapio;

/**
 * Created by Jabel on 09/30/2017.
 */

public class CardapioDao extends Dao<Cardapio> {

    private CardapioDao(Context context){
        super(context);
    }

    public static CardapioDao build(Context context) {
        return new CardapioDao(context);
    }

    @Override
    public void inserir(Cardapio cardapio) {
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

    public List<Cardapio> buscarPorCategoria(DominioCategoriaCardapio categoria) {

        Cursor c = reader.rawQuery("SELECT id, descricao, categoria, valor FROM cardapio WHERE categoria =?", new String[]{ categoria.name() });

        List<Cardapio> listaCardapio = new ArrayList<>();

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
