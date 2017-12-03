package br.com.restaurantemobile.business;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.com.restaurantemobile.R;
import br.com.restaurantemobile.model.Cardapio;
import br.com.restaurantemobile.model.Pedido;
import br.com.restaurantemobile.model.dominio.DominioCategoriaCardapio;
import br.com.restaurantemobile.model.dominio.ITipoCategoria;
import br.com.restaurantemobile.util.CurrencyUtil;

public class PaymentRecyclerViewAdapter extends RecyclerView.Adapter<PaymentRecyclerViewAdapter.MyViewHolder> {

    public List<Cardapio> cardapios;

    public PaymentRecyclerViewAdapter(List<Cardapio> cardapios){
        this.cardapios = cardapios;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.description.setText(cardapios.get(position).getDescricao());
        holder.price.setText(getPriceWithCurrency(position));
        holder.image.setImageResource(getImage(cardapios.get(position)));
        holder.amount.setText("0");
    }

    private int getImage(Cardapio cardapio) {
        ITipoCategoria[] tipos = DominioCategoriaCardapio.valueOf(cardapio.getCategoria()).getTipos();
        int image = 1;

        for(ITipoCategoria tipo : tipos){
            if(tipo.getCodigo() == cardapio.getCodigo()){
                image = tipo.getImage();
            }
        }

        return image;
    }

    private String getPriceWithCurrency(int position) {
        String price = String.valueOf(cardapios.get(position).getValor());
        return CurrencyUtil.getCurrency(price);
    }

    @Override
    public int getItemCount() {
        return cardapios.size();
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