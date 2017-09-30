package com.fontoura.jabel.restaurantemobile.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fontoura.jabel.restaurantemobile.R;
import com.fontoura.jabel.restaurantemobile.model.Pedido;

/**
 * Created by kone on 9/30/17.
 */

public class EntrancePlatesActivity extends AppCompatActivity {

    Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrance_plates);

        initializeComponents();
    }

    private void initializeComponents(){
        setTitle("Pratos de Entrada");
        pedido = (Pedido)getIntent().getSerializableExtra("pedido");
    }
}
