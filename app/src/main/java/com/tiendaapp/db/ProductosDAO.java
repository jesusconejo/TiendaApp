package com.tiendaapp.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public ProductosDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Método para insertar un producto en la base de datos
    public long insertProducto(Productos producto) {
        ContentValues values = new ContentValues();
        values.put("nombre", producto.getNombre());
        values.put("marca", producto.getMarca());
        values.put("precio", producto.getPrecio());
        values.put("cantidad", producto.getCantidad());

        return db.insert("productos", null, values);
    }

    // Método para obtener todos los productos de la base de datos
    @SuppressLint("Range")
    public List<Productos> getAllProductos() {
        List<Productos> productosList = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = db.query("productos", null, null, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    Productos producto = new Productos();
                    producto.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    producto.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                    producto.setPrecio(cursor.getDouble(cursor.getColumnIndex("precio")));
                    producto.setMarca(cursor.getString(cursor.getColumnIndex("marca")));
                    producto.setCantidad(cursor.getInt(cursor.getColumnIndex("cantidad")));

                    productosList.add(producto);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return productosList;
    }


}

