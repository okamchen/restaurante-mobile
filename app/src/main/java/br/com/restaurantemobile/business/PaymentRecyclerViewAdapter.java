package br.com.restaurantemobile.business;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.restaurantemobile.R;
import br.com.restaurantemobile.model.Cardapio;
import br.com.restaurantemobile.model.Pedido;
import br.com.restaurantemobile.model.dominio.DominioCategoriaCardapio;
import br.com.restaurantemobile.model.dominio.ITipoCategoria;
import br.com.restaurantemobile.util.CurrencyUtil;

public class PaymentRecyclerViewAdapter extends RecyclerView.Adapter<PaymentRecyclerViewAdapter.MyViewHolder> {

    public HashMap<Cardapio, Integer> itensQuantidade;
    public List<Cardapio> itensCarregados = new ArrayList<>();

    public PaymentRecyclerViewAdapter(HashMap<Cardapio, Integer> itensQuantidade){
        this.itensQuantidade= itensQuantidade;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_card, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Map.Entry<Cardapio, Integer> itemSelecionado = null;
        Iterator<Map.Entry<Cardapio, Integer>> iterator = itensQuantidade.entrySet().iterator();

        while (iterator.hasNext()){
            itemSelecionado = iterator.next();
            if(!itensCarregados.contains(itemSelecionado.getKey())){
                itensCarregados.add(itemSelecionado.getKey());
                break;
            }
        }

        Cardapio cardapio = Cardapio.clone(itemSelecionado.getKey());
        Integer total = new Integer(itemSelecionado.getValue());

        holder.description.setText(cardapio.getDescricao());
        holder.price.setText(getPriceWithCurrency(cardapio.getValor()));
        holder.image.setImageResource(getImage(cardapio));
        holder.amount.setText(total.toString());

        itensCarregados.add(itemSelecionado.getKey());

    }

    private int getImage(Cardapio cardapio) {
        ITipoCategoria[] tipos = DominioCategoriaCardapio.valueOf(cardapio.getCategoria()).getTipos();
        int image = 1;

        for(ITipoCategoria tipo : tipos){
            if(tipo.getCodigo() == cardapio.getCodigo()){
                image = new Integer(tipo.getImage());
            }
        }

        return image;
    }

    private String getPriceWithCurrency(double price) {
        return CurrencyUtil.getCurrency(String.valueOf(price));
    }

    @Override
    public int getItemCount() {
        return itensQuantidade.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView description;
        private TextView price;
        private TextView amount;
        private ImageView image;
        private RelativeLayout rowView;

        public MyViewHolder(View itemView) {
            super(itemView);

            description = (TextView)itemView.findViewById(R.id.description);
            price = (TextView)itemView.findViewById(R.id.price);
            amount = (TextView)itemView.findViewById(R.id.amount);
            image = (ImageView)itemView.findViewById(R.id.image);
            rowView = (RelativeLayout)itemView.findViewById(R.id.rowView);
        }
    }
}