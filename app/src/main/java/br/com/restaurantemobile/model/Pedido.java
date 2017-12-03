package br.com.restaurantemobile.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable {

    private long id;
    private Cliente cliente;
    private long mesa;
    private Date data;
    private BigDecimal valorTotal = new BigDecimal("0");
    private List<Cardapio> itens;

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

    public List<Cardapio> getItens(){
        return this.itens;
    }

    public void addItem(Cardapio item){

        if(this.itens == null) {
            this.itens = new ArrayList<>();
        }
        this.getItens().add(item);
    }

    public void removeItem(Cardapio item){

        if(this.itens == null) {
            return;
        }

        if(this.getItens().contains(item)){
            this.getItens().remove(item);
        }
    }


}
