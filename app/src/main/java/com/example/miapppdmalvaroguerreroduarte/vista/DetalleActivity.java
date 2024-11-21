package com.example.miapppdmalvaroguerreroduarte.vista;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miapppdmalvaroguerreroduarte.R;
import com.example.miapppdmalvaroguerreroduarte.modelo.Usuario;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detalle_activity);

        String titulo = getIntent().getStringExtra("titulo");
        String descripcion = getIntent().getStringExtra("descripcion");
        int imagenId = getIntent().getIntExtra("imagenId", -1);

        TextView txtTitulo = findViewById(R.id.txtTitulo);
        ImageView imgVideojuego = findViewById(R.id.imgVideojuego);
        TextView txtDescripcion = findViewById(R.id.txtDescripcion);

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        txtTitulo.setText(titulo);
        txtDescripcion.setText(descripcion);

        if(usuario != null){
            txtTitulo.setText(usuario.getNombre());
            imgVideojuego.setImageResource(R.drawable.ic_launcher_background);
        }
        if (imagenId != -1) {
            imgVideojuego.setImageResource(imagenId);
        }

    }
}