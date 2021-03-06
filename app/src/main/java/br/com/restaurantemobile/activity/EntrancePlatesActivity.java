package br.com.restaurantemobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.restaurantemobile.R;
import br.com.restaurantemobile.dao.CardapioDao;
import br.com.restaurantemobile.business.MenuRecyclerViewAdapter;
import br.com.restaurantemobile.model.Cardapio;
import br.com.restaurantemobile.model.Pedido;
import br.com.restaurantemobile.model.dominio.DominioCategoriaCardapio;

public class EntrancePlatesActivity extends AppCompatActivity {

    private Pedido pedido;
    private RecyclerView entrancePlatesRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView txtTotalPedido;
    Button btnAvancar;

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

        txtTotalPedido = (TextView) findViewById(R.id.txtTotalPedido);

        txtTotalPedido.setText(pedido.getValorTotalFormatado());

        mAdapter = new MenuRecyclerViewAdapter(getDataBase(), pedido, txtTotalPedido );

        entrancePlatesRecyclerView.setAdapter(mAdapter);

        btnAvancar = (Button) findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mainPlatesActivity = new Intent(EntrancePlatesActivity.this, MainPlatesActivity.class);
                mainPlatesActivity.putExtra("pedido", pedido);
                startActivity(mainPlatesActivity);
            }
        });
    }

    public List<Cardapio> getDataBase() {
        return CardapioDao.build(this).buscarPorCategoria(DominioCategoriaCardapio.ENTRADAS);
    }
}
