package com.tiendaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.inicio){
            Toast.makeText(this,"You clicked Logout",Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.login) {
            Toast.makeText(this,"You clicked About",Toast.LENGTH_LONG).show();

        }
        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void carrito(View view){
        Intent carritoCompra = new Intent(this, CarritoCompra.class);
        startActivity(carritoCompra);
    }
    public void loginUsuario(View view){
        Intent login = new Intent(this, Login.class);
        startActivity(login);
    }
}