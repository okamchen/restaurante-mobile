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

public class SaladPlatesActivity extends AppCompatActivity {

    private Pedido pedido;
    private RecyclerView dessertPlatesRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView txtTotalPedido;
    private Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salad);

        initializeComponents();
    }

    public void initializeComponents(){
        setTitle("Saladas");

        pedido = (Pedido) getIntent().getSerializableExtra("pedido");

        dessertPlatesRecyclerView = (RecyclerView) findViewById(R.id.salad_view);

        dessertPlatesRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        dessertPlatesRecyclerView.setLayoutManager(layoutManager);

        txtTotalPedido = (TextView) findViewById(R.id.txtTotalPedido);

        txtTotalPedido.setText(pedido.getValorTotalFormatado());

        mAdapter = new MenuRecyclerViewAdapter(getDataBase(), pedido, txtTotalPedido );

        dessertPlatesRecyclerView.setAdapter(mAdapter);

        btnAvancar = (Button) findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent dessertPlatesActivity = new Intent(SaladPlatesActivity.this, DessertActivity.class);
                dessertPlatesActivity.putExtra("pedido", pedido);
                startActivity(dessertPlatesActivity);
            }
        });
    }

    public List<Cardapio> getDataBase() {
        return CardapioDao.build(this).buscarPorCategoria(DominioCategoriaCardapio.SALADAS);
    }

}
