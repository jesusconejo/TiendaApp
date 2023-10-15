package com.tiendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CarritoCompra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_compra);
    }
     public void pagar(View view){
         Toast.makeText(this.getApplicationContext(), "Carrito de Compras esta vacio",Toast.LENGTH_LONG).show();

     }
}