package com.tiendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void listado(View view){
        Intent listado = new Intent(this, ListadoProductos.class);
        startActivity(listado);
    }
    public void registrarUsuario(View view){
        Intent registrar = new Intent(this, RegistroClientes.class);
        startActivity(registrar);
    }
}