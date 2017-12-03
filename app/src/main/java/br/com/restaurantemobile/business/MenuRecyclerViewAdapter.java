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

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.MyViewHolder> {

    public List<Cardapio> cardapios;
    public Pedido pedido;
    public TextView txtTotalPedido;

    public MenuRecyclerViewAdapter(List<Cardapio> cardapios, Pedido pedido, TextView txtTotalPedido){
        this.cardapios = cardapios;
        this.pedido = pedido;
        this.txtTotalPedido = txtTotalPedido;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new MyViewHolder(listItem, pedido, txtTotalPedido);
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
        private Pedido pedido;
        private TextView txtTotalPedido;

        public MyViewHolder(View itemView, Pedido pedido, final TextView txtTotalPedido) {
            super(itemView);

            this.pedido = pedido;
            this.txtTotalPedido = txtTotalPedido;

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

                    System.out.print("Valor do item: " + price);

                    getPedido().somarValorTotal(price.getText().toString());

                    txtTotalPedido.setText(getPedido().getValorTotalFormatado());

                    amount.setText(qtd.toString());
                }
            });

            rowView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    Integer qtd = Integer.valueOf(amount.getText().toString());
                    qtd = qtd > 0 ? qtd - 1 : 0;

                    System.out.print("Valor do item: " + price);

                    getPedido().subtraiValorTotal(price.getText().toString());
                    amount.setText(qtd.toString());

                    txtTotalPedido.setText(getPedido().getValorTotalFormatado());

                    return false;
                }
            });
        }

        public Pedido getPedido(){
            return this.pedido;
        }

    }
}