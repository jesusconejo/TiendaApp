package com.tiendaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tiendaapp.db.Productos;

import java.util.List;

public class ProductosListAdapter extends ArrayAdapter<Productos> {
    private List<Productos> productosList;
    private Context context;
    private int resource;

    public ProductosListAdapter(Context context, int resource, List<Productos> productosList) {
        super(context, resource, productosList);
        this.context = context;
        this.resource = resource;
        this.productosList = productosList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(resource, parent, false);
        }

        // Obtener el producto actual
        Productos producto = productosList.get(position);

        // Obtener referencias a los elementos de tu layout personalizado
        ImageView imageView = convertView.findViewById(R.id.imageCard);
        TextView nombreTextView = convertView.findViewById(R.id.nombrePro);
        TextView marcaTextView = convertView.findViewById(R.id.marcaProd);
        TextView precioTextView = convertView.findViewById(R.id.precioPro);
        // Otros TextViews y elementos que quieras mostrar

        // Asignar valores a los elementos del layout según el producto actual
        imageView.setImageResource(R.drawable.teslapi); // Reemplaza con tu lógica para obtener la imagen
        nombreTextView.setText(producto.getNombre());
        marcaTextView.setText(producto.getMarca());
        precioTextView.setText(String.valueOf(producto.getPrecio()));
        // Configura otros elementos de tu diseño

        return convertView;
    }
}

