package br.com.restaurantemobile.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.restaurantemobile.R;
import br.com.restaurantemobile.infra.EntrancePlateRecyclerViewAdapter;
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
    private RecyclerView entrancePlatesRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrance_plates);

        initializeComponents();
    }

    private void initializeComponents() {
        setTitle("Pratos de Entrada");

        pedido = (Pedido) getIntent().getSerializableExtra("pedido");

        entrancePlatesRecyclerView = (RecyclerView) findViewById(R.id.entrance_plates_view);

        entrancePlatesRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        entrancePlatesRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new EntrancePlateRecyclerViewAdapter(getDataBase());

        entrancePlatesRecyclerView.setAdapter(mAdapter);

    }

    public List<Cardapio> getDataBase() {
        return CardapioDao.build(this).buscarPorCategoria(DominioCategoriaCardapio.ENTRADAS);
    }
}
