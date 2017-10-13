package br.com.restaurantemobile.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import br.com.restaurantemobile.model.Cliente;
import br.com.restaurantemobile.model.Pedido;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.restaurantemobile.model.Cardapio;
import br.com.restaurantemobile.model.dominio.DominioCategoriaCardapio;

/**
 * Created by Jabel on 09/30/2017.
 */

public class PedidoDao extends Dao<Pedido> {

    private ClienteDao clienteDao;

    public PedidoDao(Context context) {
        super(context);
        this.clienteDao = clienteDao.build(context);
    }

    public PedidoDao build(Context context){
        return new PedidoDao(context);
    }

    @Override
    public void inserir(Pedido pedido) {
        writer.insert("pedido", null, pegaDadosDoCliente(pedido));
    }

    public void inserir(Pedido pedido, Cardapio cardapio, int quantidade) {
        ContentValues values = new ContentValues();
        values.put("id_cardapio", cardapio.getId());
        values.put("id_pedido", pedido.getId());
        values.put("quantidade", quantidade);

        writer.insert("pedido_cardapio", null, values);

    }

    private ContentValues pegaDadosDoCliente(Pedido pedido) {
        ContentValues dados = new ContentValues();
        dados.put("id", pedido.getId());
        dados.put("id_cliente", pedido.getCliente().getId());
        dados.put("valor_total", pedido.getValorTotal());
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

    private Pedido montarPedido(Cursor c) {
        Pedido pedido = new Pedido();

        pedido.setId(c.getLong(c.getColumnIndex("id")));
        pedido.setCliente(clienteDao.buscarPorId(c.getLong(c.getColumnIndex("id_cliente"))));
        pedido.setData(new Date(c.getLong(c.getColumnIndex("data"))));
        pedido.setMesa(c.getLong(c.getColumnIndex("mesa")));
        pedido.setValorTotal(c.getDouble(c.getColumnIndex("valor")));

        pedido.setPratosEntrada(getItensCardapioByPedidoId(c.getLong(c.getColumnIndex("id")), DominioCategoriaCardapio.ENTRADAS));
        pedido.setPratosPrincipais(getItensCardapioByPedidoId(c.getLong(c.getColumnIndex("id")), DominioCategoriaCardapio.PRATOS));
        pedido.setPratosSobremesa(getItensCardapioByPedidoId(c.getLong(c.getColumnIndex("id")), DominioCategoriaCardapio.SOBREMESAS));
        pedido.setSaladas(getItensCardapioByPedidoId(c.getLong(c.getColumnIndex("id")), DominioCategoriaCardapio.SALADAS));
        pedido.setBebidas(getItensCardapioByPedidoId(c.getLong(c.getColumnIndex("id")), DominioCategoriaCardapio.BEBIDAS));

        return pedido;
    }

    private List<Cardapio> getItensCardapioByPedidoId(long id, DominioCategoriaCardapio categoria) {
        List<Cardapio> itensCardapio = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c.id AS id_cardapio, p.id AS id_pedido, c.descricao, c.valor, c.categoria FROM cardapio c ");
        sql.append("JOIN pedido_cardapio pc ");
        sql.append("ON  pc.id_cardapio = c.id  AND c.categoria = ? ");
        sql.append("JOIN pedido p ON p.id = pc.id_pedido AND p.id = ?");

        Cursor cursor = reader.rawQuery(sql.toString(), new String[]{ String.valueOf(id), categoria.name() });

        while(cursor.moveToNext()) {
            Cardapio cardapio = new Cardapio();

            cardapio.setId(cursor.getLong(cursor.getColumnIndex("id_cardapio")));
            cardapio.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
            cardapio.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            cardapio.setValor(cursor.getDouble(cursor.getColumnIndex("valor")));

            itensCardapio.add(cardapio);
        }

        return itensCardapio;
    }
}
