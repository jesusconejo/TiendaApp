package com.tiendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void listado(View view){
        Toast.makeText(this.getApplicationContext(), "Usuario no Existe",Toast.LENGTH_LONG).show();
        //Intent listado = new Intent(this, ListadoProductos.class);
        //startActivity(listado);
    }
    public void registrarUsuario(View view){
        Intent registrar = new Intent(this, RegistroClientes.class);
        startActivity(registrar);
    }
}