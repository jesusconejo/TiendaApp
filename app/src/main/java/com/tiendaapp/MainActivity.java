package com.tiendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tiendaapp.db.Productos;
import com.tiendaapp.db.ProductosDAO;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Productos> productosList;
    private ProductosDAO productosDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productosDAO = new ProductosDAO(this);
        productosDAO.open();
        productosList = productosDAO.getAllProductos();
        //  ProductosListAdapter adapter = new ProductosListAdapter(this, R.layout.card_product, productosList);
        // listView.setAdapter(adapter);
    }

    public void carrito(View view) {
        Intent carritoCompra = new Intent(this, CarritoCompra.class);
        startActivity(carritoCompra);
    }

    public void mapa(View view) {
        Intent mapaGeo = new Intent(this, MainMap.class);
        startActivity(mapaGeo);
    }

    public void loginUsuario(View view) {
        Intent login = new Intent(this, Login.class);
        startActivity(login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_opcion1) {
            Toast.makeText(this, "You clicked Logout", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.action_opcion2) {
            Toast.makeText(this, "You clicked About", Toast.LENGTH_LONG).show();
            return true;

        }
        return super.onOptionsItemSelected(item);

    }
}