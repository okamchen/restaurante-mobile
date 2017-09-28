package com.fontoura.jabel.restaurantemobile.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Jabel on 09/23/2017.
 */

public class Pedido {

    private long id;
    private long id_cliente;
    private long mesa;
    private Date data;
    private double valor_total;

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
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
}
