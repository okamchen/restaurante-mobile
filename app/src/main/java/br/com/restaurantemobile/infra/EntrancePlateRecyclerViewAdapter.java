package br.com.restaurantemobile.infra;

import android.support.annotation.NonNull;
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
import br.com.restaurantemobile.util.CurrencyUtil;

/**
 * Created by kone on 9/30/17.
 */

public class EntrancePlateRecyclerViewAdapter extends RecyclerView.Adapter<EntrancePlateRecyclerViewAdapter.MyViewHolder> {

    public List<Cardapio> cardapios;

    public EntrancePlateRecyclerViewAdapter(List<Cardapio> cardapios){
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
        holder.image.setImageResource(R.drawable.salada);
        holder.amount.setText("0");
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

            amount.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Integer qtd = Integer.valueOf(amount.getText().toString());
                    qtd = qtd + 1;
                    amount.setText(qtd.toString());
                }
            });

            rowView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    Integer qtd = Integer.valueOf(amount.getText().toString());
                    qtd = qtd > 0 ? qtd - 1 : 0;
                    amount.setText(qtd.toString());

                    return false;
                }
            });

        }

    }
}