package br.com.restaurantemobile.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.restaurantemobile.R;
import br.com.restaurantemobile.infra.RecyclerViewAdapter;
import br.com.restaurantemobile.model.Pedido;

import java.util.List;

import br.com.restaurantemobile.infra.dao.CardapioDao;
import br.com.restaurantemobile.model.Cardapio;
import br.com.restaurantemobile.model.dominio.DominioCategoriaCardapio;

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
        return CardapioDao.build(this).buscarPorCategoria(DominioCategoriaCardapio.ENTRADAS);
    }
}
