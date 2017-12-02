package br.com.restaurantemobile.activity;

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
import br.com.restaurantemobile.infra.MenuRecyclerViewAdapter;
import br.com.restaurantemobile.model.Cardapio;
import br.com.restaurantemobile.model.Pedido;
import br.com.restaurantemobile.model.dominio.DominioCategoriaCardapio;

/**
 * Created by kone on 12/2/17.
 */

public class DessertPlatesActivity extends AppCompatActivity {

    private Pedido pedido;
    private RecyclerView dessertPlatesRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView txtTotalPedido;
    Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dessert_plates);

        initializeComponents();
    }

    public void initializeComponents(){
        setTitle("Soremesas");

        pedido = (Pedido) getIntent().getSerializableExtra("pedido");

        dessertPlatesRecyclerView = (RecyclerView) findViewById(R.id.dessert_plates_view);

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
//                Intent mainPlatesActivity = new Intent(DessertPlatesActivity.this, DessertPlatesActivity.class);
//                mainPlatesActivity .putExtra("pedido", pedido);
//                startActivity(mainPlatesActivity);
            }
        });
    }

    public List<Cardapio> getDataBase() {
        return CardapioDao.build(this).buscarPorCategoria(DominioCategoriaCardapio.SOBREMESAS);
    }

}
