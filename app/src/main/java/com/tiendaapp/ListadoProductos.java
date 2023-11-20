package com.tiendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tiendaapp.db.Productos;
import com.tiendaapp.db.ProductosDAO;

import java.util.ArrayList;
import java.util.List;

public class ListadoProductos extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ProductosDAO productosDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_productos);
        productosDAO = new ProductosDAO(this);
        listView = findViewById(R.id.listViewProducto);

        // Simulando una lista de nombres de productos
        ArrayList<String> listaNombresProductos = obtenerNombresProductos(); // Aquí debes obtener los nombres de los productos de tu base de datos o de donde estén almacenados

        // Crear un ArrayAdapter para mostrar los nombres de los productos en el ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNombresProductos);

        // Establecer el adaptador en el ListView
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
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

    public void salir(View view) {
        Intent admin = new Intent(this, Administracion.class);
        startActivity(admin);
    }

    // Método de ejemplo para obtener nombres de productos (debes reemplazarlo con tu lógica para obtener los nombres reales de tu base de datos)
    private ArrayList<String> obtenerNombresProductos() {
        productosDAO.open();
        ArrayList<String> nombresProductos = new ArrayList<>();
        List<Productos> listaProductos = new ArrayList<>();
        listaProductos = productosDAO.getAllProductos();
        nombresProductos.add("Nombre   -   Marca   -   Precio  -  Cant");
        for (Productos producto : listaProductos) {
            nombresProductos.add(producto.getNombre() + " - "
                    + producto.getMarca() + " -   "
                    + producto.getPrecio() + " -   "
                    + producto.getCantidad());
        }
        productosDAO.close();
        return nombresProductos;
    }
}