package com.tiendaapp.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDAO {
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    private DatabaseReference mDatabase;

    public UserDAO(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public UserDAO(Context context) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {

        dbHelper.close();
    }

    public long insertUser(User user) {
        ContentValues values = new ContentValues();
        values.put("nombre", user.getNombre());
        values.put("usuario", user.getUsuario());
        values.put("correo", user.getCorreo());
        values.put("contrasena", user.getContrasena());

        return database.insert("users", null, values);
    }

    public boolean existeUsuario(String usuario) {
        Log.d("existeUsuario", " " + usuario);
        Cursor cursor = database.query("users", null, "usuario = ?", new String[]{usuario}, null, null, null);
        boolean existe = cursor != null && cursor.getCount() > 0;

        if (cursor != null) {
            cursor.close();
        }

        return existe;
    }

    public boolean existeCorreo(String correo) {

        Cursor cursor = database.query("users", null, "correo = ?", new String[]{correo}, null, null, null);
        boolean existe = cursor != null && cursor.getCount() > 0;

        if (cursor != null) {
            cursor.close();
        }

        return existe;
    }

    @SuppressLint("Range")
    public String obtenerContrasena(String usuario) {
        String contrasena = null;
        Log.d("obtenerContrasena", usuario);
        Cursor cursor = database.query("users", new String[]{"contrasena"}, "usuario = ?", new String[]{usuario}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            contrasena = cursor.getString(cursor.getColumnIndex("contrasena"));
            cursor.close();
        }

        return contrasena;
    }

    public void writeUser(String nombreUser,String nombre,String email,String contrasena){
        User user = new User(nombreUser,nombre,email,contrasena);
        mDatabase.child("users").child(nombreUser).setValue(user);

    }

}

