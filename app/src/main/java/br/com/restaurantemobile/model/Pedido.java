package br.com.restaurantemobile.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
    private BigDecimal valorTotal = new BigDecimal("0");
    private List<Cardapio> bebidas = new ArrayList<>();
    private List<Cardapio> saladas = new ArrayList<>();
    private List<Cardapio> pratosEntrada = new ArrayList<>();
    private List<Cardapio> pratosPrincipais = new ArrayList<>();
    private List<Cardapio> pratosSobremesa = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Cardapio> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Cardapio> bebidas) {
        this.bebidas = bebidas;
    }

    public List<Cardapio> getSaladas() {
        return saladas;
    }

    public void setSaladas(List<Cardapio> saladas) {
        this.saladas = saladas;
    }

    public List<Cardapio> getPratosEntrada() {
        return pratosEntrada;
    }

    public void setPratosEntrada(List<Cardapio> pratosEntrada) {
        this.pratosEntrada = pratosEntrada;
    }

    public List<Cardapio> getPratosPrincipais() {
        return pratosPrincipais;
    }

    public void setPratosPrincipais(List<Cardapio> pratosPrincipais) {
        this.pratosPrincipais = pratosPrincipais;
    }

    public List<Cardapio> getPratosSobremesa() {
        return pratosSobremesa;
    }

    public void setPratosSobremesa(List<Cardapio> pratosSobremesa) {
        this.pratosSobremesa = pratosSobremesa;
    }

    public void somarValorTotal(String valor){
        BigDecimal valorReal = getValorReal(valor);
        this.valorTotal = this.valorTotal.add(valorReal);
    }

    public void subtraiValorTotal(String valor){
        BigDecimal valorReal = getValorReal(valor);
        this.valorTotal = this.valorTotal.subtract(valorReal);
    }

    private BigDecimal getValorReal(String valor){
        return new BigDecimal(valor.replace("R$", "").replace(",", "."));
    }

    public String getValorTotalFormatado(){
        return "Valor Total: R$ " + this.valorTotal;
    }

}
