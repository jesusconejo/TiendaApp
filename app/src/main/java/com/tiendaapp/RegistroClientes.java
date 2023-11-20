package com.tiendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tiendaapp.db.User;
import com.tiendaapp.db.UserDAO;

public class RegistroClientes extends AppCompatActivity {

    UserDAO userDAO = new UserDAO(this);
    private EditText editTextNombreApellido, editTextNombreUsuario, editTextCorreo, editTextContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_clientes);
        // Inicializar los EditText
        editTextNombreApellido = findViewById(R.id.nombreApellido);
        editTextNombreUsuario = findViewById(R.id.nombreUsuario);
        editTextCorreo = findViewById(R.id.correo);
        editTextContrasena = findViewById(R.id.password);
    }

    public void registrarse(View view) {
        // Obtener datos de los EditText
        String nombreApellido = editTextNombreApellido.getText().toString();
        String nombreUsuario = editTextNombreUsuario.getText().toString();
        String correo = editTextCorreo.getText().toString();
        String contrasena = editTextContrasena.getText().toString();

        // Verificar si algún campo está vacío
        if (nombreApellido.isEmpty() || nombreUsuario.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "No puede haber ningun campo vacio", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent login = new Intent(this, Login.class);
        userDAO.open();
        if (userDAO.existeUsuario(nombreUsuario)) {
            Toast.makeText(this.getApplicationContext(), "Usuario ya existe", Toast.LENGTH_SHORT).show();
            userDAO.close();
            return;
        }
        if (userDAO.existeCorreo(correo)) {
            Toast.makeText(this.getApplicationContext(), "Correo ya tiene cuenta", Toast.LENGTH_SHORT).show();
            userDAO.close();
            return;
        }
        User nuevoUsuario = new User(nombreApellido, nombreUsuario, correo, contrasena);
        long resultado = userDAO.insertUser(nuevoUsuario);

        if (resultado > 0) {
            Toast.makeText(this.getApplicationContext(), "Registrado Correctamente", Toast.LENGTH_SHORT).show();
            userDAO.close();
            startActivity(login);
        } else {
            Toast.makeText(this.getApplicationContext(), "Error de Registro", Toast.LENGTH_SHORT).show();
            userDAO.close();
        }

    }

    private void validarUsuario(String nombreUsuario) {
        userDAO.open();

    }
}