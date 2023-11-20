package com.tiendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tiendaapp.db.Productos;
import com.tiendaapp.db.ProductosDAO;

public class Administracion extends AppCompatActivity {
    private ProductosDAO productosDAO;
    private EditText nombre, marca, precio, cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Inicializar los EditText
        nombre = findViewById(R.id.productNameEditText);
        marca = findViewById(R.id.marcaProductoEditText);
        precio = findViewById(R.id.precioProductoEditText3);
        cantidad = findViewById(R.id.cantidadProductoEditText4);

        productosDAO = new ProductosDAO(this);
    }

    public void newProduct(View view) {
        String nombreProducto = nombre.getText().toString();
        String marcaProducto = marca.getText().toString();
        String precioProducto = precio.getText().toString();
        String cantidadProducto = cantidad.getText().toString();

        if (nombreProducto.isEmpty() || marcaProducto.isEmpty() || precioProducto.isEmpty() || cantidadProducto.isEmpty()) {
            Toast.makeText(this, "No puede haber ningún campo vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        productosDAO.open();
        try {
            double precio = Double.parseDouble(precioProducto);
            int cantidad = Integer.parseInt(cantidadProducto);

            Productos producto = new Productos(nombreProducto, precio, marcaProducto, cantidad);
            productosDAO.insertProducto(producto);
            Toast.makeText(this, "Producto registrado exitosamente", Toast.LENGTH_SHORT).show();
            productosDAO.close();
            cleanForm();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Error al convertir precio o cantidad", Toast.LENGTH_SHORT).show();
            cleanForm();
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            productosDAO.close();
        }
    }

    public void salirM(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

    public void verProductos(View view) {
        Intent listaProductos = new Intent(this, ListadoProductos.class);
        startActivity(listaProductos);
    }

    private void cleanForm() {
        nombre.setText("");
        marca.setText("");
        precio.setText("");
        cantidad.setText("");
    }
}
