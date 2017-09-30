package com.fontoura.jabel.restaurantemobile.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fontoura.jabel.restaurantemobile.R;
import com.fontoura.jabel.restaurantemobile.infra.RecyclerViewAdapter;
import com.fontoura.jabel.restaurantemobile.model.Cardapio;
import com.fontoura.jabel.restaurantemobile.model.Pedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kone on 9/30/17.
 */

public class EntrancePlatesActivity extends AppCompatActivity {

    private Pedido pedido;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrance_plates);

        initializeComponents();
    }

    private void initializeComponents() {
        setTitle("Pratos de Entrada");
        pedido = (Pedido) getIntent().getSerializableExtra("pedido");

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerViewAdapter(getDataBase());
        mRecyclerView.setAdapter(mAdapter);

    }

    public List<Cardapio> getDataBase() {
        List<Cardapio> cardapiosEntrada = new ArrayList<>();

        cardapiosEntrada.add(new Cardapio(1L, "Salada Julis", 12.98, Cardapio.CATEGORIA_ENTRADAS));
        cardapiosEntrada.add(new Cardapio(2L, "Degoste de onte", 20.32, Cardapio.CATEGORIA_ENTRADAS));
        cardapiosEntrada.add(new Cardapio(3L, "Salada mista", 32.97, Cardapio.CATEGORIA_ENTRADAS));
        cardapiosEntrada.add(new Cardapio(4L, "Maionese de maçã", 23.98, Cardapio.CATEGORIA_ENTRADAS));

        return cardapiosEntrada;
    }
}
