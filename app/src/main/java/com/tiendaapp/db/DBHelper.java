package com.tiendaapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "usuarios.db";
    private static final int DATABASE_VERSION = 1;

    // Sentencia SQL para crear la tabla de usuarios
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT, usuario TEXT, correo TEXT, contrasena TEXT);";
    private static final String CREATE_TABLE_PRODUCTOS =
            "CREATE TABLE productos (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT, precio REAL, marca TEXT, cantidad INTEGER);";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla de usuarios
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_PRODUCTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Manejar actualizaciones de la base de datos si es necesario
    }
}

