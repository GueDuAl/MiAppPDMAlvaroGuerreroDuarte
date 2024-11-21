package com.example.miapppdmalvaroguerreroduarte.vista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.miapppdmalvaroguerreroduarte.R;
import com.example.miapppdmalvaroguerreroduarte.modelo.Usuario;
import com.example.miapppdmalvaroguerreroduarte.utilidades.Utilidades;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registro_activity);


        EditText etNombre = findViewById(R.id.etNombre);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etEdad = findViewById(R.id.etEdad);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String email = etEmail.getText().toString();
            String edadStr = etEdad.getText().toString();
            if (nombre.isEmpty() || email.isEmpty() || edadStr.isEmpty() || Integer.parseInt(edadStr) < 18) {
                Toast.makeText(this, "Los campos deben completarse y la edad ser mayor de 18 años", Toast.LENGTH_LONG).show();
            } else {
                int edad = Integer.parseInt(edadStr);
                Utilidades.registrarUsuario(new Usuario(nombre, email, edad));
                Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}