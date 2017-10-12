package br.com.restaurantemobile.infra;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import br.com.restaurantemobile.R;
import br.com.restaurantemobile.model.Cardapio;

/**
 * Created by kone on 9/30/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    public List<Cardapio> cardapios;

    public RecyclerViewAdapter (List<Cardapio> cardapios){
        this.cardapios = cardapios;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtDescription.setText(cardapios.get(position).getDescricao());
        holder.txtPrice.setText(String.valueOf(cardapios.get(position).getValor()));
        holder.imgSalad.setImageResource(R.drawable.salada);
    }


    @Override
    public int getItemCount() {
        return cardapios.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtDescription;
        private TextView txtPrice;
        private ImageView imgSalad;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtDescription = (TextView)itemView.findViewById(R.id.description);
            txtPrice = (TextView)itemView.findViewById(R.id.price);
            imgSalad = (ImageView)itemView.findViewById(R.id.salada);
        }
    }
}