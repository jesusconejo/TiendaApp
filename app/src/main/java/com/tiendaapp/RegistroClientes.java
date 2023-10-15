package com.tiendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RegistroClientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_clientes);
    }
    public void registrarse(View view){
        Intent registro = new Intent(this, ListadoProductos.class);
        Toast.makeText(this.getApplicationContext(), "Registrado Correctamente",Toast.LENGTH_SHORT).show();
        startActivity(registro);
    }
}