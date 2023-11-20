package com.tiendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tiendaapp.db.UserDAO;

public class Login extends AppCompatActivity {

    private EditText editTextNombreUsuario, editTextContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextNombreUsuario = findViewById(R.id.usernameEditText);
        editTextContrasena = findViewById(R.id.passwordEditText);
    }

    public void verificarLogin(View view) {
        UserDAO userDAO = new UserDAO(this);
        userDAO.open();
        String usuario = editTextNombreUsuario.getText().toString();
        String clave = editTextContrasena.getText().toString();

        if (usuario.isEmpty() || clave.isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "Usuario  Password no pueden estar vacios", Toast.LENGTH_LONG).show();
            userDAO.close();
            return;
        }
        if (userDAO.existeUsuario(usuario)) {
            if (userDAO.obtenerContrasena(usuario).equals(clave)) {
                //Toast.makeText(this.getApplicationContext(), "Usuario SII Existe y pass valido",Toast.LENGTH_LONG).show();
                Intent admin = new Intent(this, Administracion.class);
                userDAO.close();
                startActivity(admin);
            } else {
                userDAO.close();
                Toast.makeText(this.getApplicationContext(), "Password Invalido", Toast.LENGTH_LONG).show();
            }
        } else {
            userDAO.close();
            Toast.makeText(this.getApplicationContext(), "Usuario no Existe", Toast.LENGTH_LONG).show();
        }
    }

    public void registrarUsuario(View view) {
        Intent registrar = new Intent(this, RegistroClientes.class);
        startActivity(registrar);
    }
}