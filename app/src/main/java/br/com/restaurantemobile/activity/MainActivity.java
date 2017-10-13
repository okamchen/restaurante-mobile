package br.com.restaurantemobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import br.com.restaurantemobile.R;
import br.com.restaurantemobile.model.Cliente;
import br.com.restaurantemobile.model.Pedido;

public class MainActivity extends AppCompatActivity {

    Pedido pedido = new Pedido();
    EditText txtNumber;
    EditText txtName;
    Button btnStartOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    private void initializeComponents(){

        txtName = (EditText)findViewById(R.id.txtName);
        txtNumber = (EditText)findViewById(R.id.txtNumber);

        btnStartOrder = (Button) findViewById(R.id.btnStartOrder);

        btnStartOrder.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                if(txtName.getText().toString().trim().equals("")){
                    txtName.setError( "Nome do cliente é obrigatório!" );
                    return;
                }

                if(txtNumber.getText().toString().trim().equals("")){
                    txtNumber.setError( "Número da mesa é obrigatório!" );
                    return;
                }

                pedido.setMesa(Long.valueOf(txtNumber.getText().toString()));
                pedido.setCliente(new Cliente(txtName.getText().toString()));

                Intent entrancePlatesActivity = new Intent(MainActivity.this, EntrancePlatesActivity.class);
                entrancePlatesActivity.putExtra("pedido", pedido);
                startActivity(entrancePlatesActivity);
            }

        });

    }
}
