package br.com.restaurantemobile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jabel on 09/23/2017.
 */

public class Pedido implements Serializable {

    private long id;
    private Cliente cliente;
    private long mesa;
    private Date data;
    private double valor_total;
    private List<Cardapio> itens = new ArrayList<Cardapio>();

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getMesa() {
        return mesa;
    }

    public void setMesa(long mesa) {
        this.mesa = mesa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cardapio> getItens() { return itens; }

    public void setItens(List<Cardapio> itens) { this.itens = itens; }
}
