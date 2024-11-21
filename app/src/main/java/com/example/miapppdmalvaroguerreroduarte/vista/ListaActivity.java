package com.example.miapppdmalvaroguerreroduarte.vista;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miapppdmalvaroguerreroduarte.R;
import com.example.miapppdmalvaroguerreroduarte.controlador.RecyclerAdapter;
import com.example.miapppdmalvaroguerreroduarte.modelo.Usuario;
import com.example.miapppdmalvaroguerreroduarte.modelo.Videojuego;
import com.example.miapppdmalvaroguerreroduarte.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recAdapter;
    List<Videojuego> listVideojuegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_activity);

        recyclerView = (RecyclerView) findViewById(R.id.recView);
        listVideojuegos = getListVideojuegos();

        recAdapter = new RecyclerAdapter(listVideojuegos, new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Videojuego videojuego) {

                Intent intent = new Intent(ListaActivity.this, DetalleActivity.class);
                intent.putExtra("titulo", videojuego.getTitulo());
                intent.putExtra("descripcion", videojuego.getDescripcion());
                intent.putExtra("imagenId", videojuego.getImagenId());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(Videojuego videojuego, int position) {

                showDeleteConfirmationDialog(videojuego, position);
            }
        });


        recyclerView.setAdapter(recAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<Videojuego> getListVideojuegos() {
        ArrayList<Videojuego> list = new ArrayList<Videojuego>();

        list.add(new Videojuego("The Legend of Zelda BOTW", "Un juego de aventuras de mundo abierto donde Link explora el vasto reino de Hyrule para derrotar a Calamity Ganon.", R.drawable.img_breath_of_the_wild));
        list.add(new Videojuego("Minecraft", "Un juego de construcción y supervivencia en un mundo generado aleatoriamente hecho de bloques, permitiendo exploración y creación ilimitada.", R.drawable.img_minecraft));
        list.add(new Videojuego("The Witcher 3", "Juego de rol en el que Geralt de Rivia, un cazador de monstruos, explora un vasto mundo medieval buscando a su hija adoptiva.", R.drawable.img_witcher_3));
        list.add(new Videojuego("Red Dead Redemption 2", "Un juego de acción y aventura ambientado en el Viejo Oeste donde se sigue la vida del forajido Arthur Morgan y su lucha por la supervivencia.", R.drawable.img_red_dead_redemption_2));
        list.add(new Videojuego("Super Mario Odyssey", "Mario emprende una aventura en diferentes reinos para rescatar a la princesa Peach, utilizando su nuevo aliado, Cappy, un sombrero encantado.", R.drawable.img_super_mario_odyssey));
        list.add(new Videojuego("Dark Souls III", "Un desafiante juego de rol de acción donde el jugador enfrenta difíciles enemigos en un mundo oscuro y medieval.", R.drawable.img_dark_souls_3));
        list.add(new Videojuego("Fortnite", "Un juego de batalla real donde hasta 100 jugadores luchan hasta ser el último en pie, combinando construcción y combate rápido.", R.drawable.img_fortnite));
        list.add(new Videojuego("Animal Crossing NH", "Juego de simulación de vida en una isla desierta donde el jugador puede recolectar recursos, decorar y construir una comunidad.", R.drawable.img_animal_crossing));
        list.add(new Videojuego("Cyberpunk 2077", "Juego de rol de mundo abierto en un futuro distópico donde el jugador toma decisiones que afectan el desarrollo de la historia.", R.drawable.img_cyberpunk_2077));
        list.add(new Videojuego("Hades", "Un juego de acción roguelike donde Zagreus, el hijo de Hades, intenta escapar del inframundo enfrentando a diversos dioses y criaturas.", R.drawable.img_hades));
        list.add(new Videojuego("Resident Evil Village", "Un juego de horror de supervivencia en el que Ethan Winters busca a su hija en un extraño pueblo europeo habitado por monstruos.", R.drawable.img_resident_evil_village));
        list.add(new Videojuego("Genshin Impact", "Un juego de rol de acción en un mundo abierto lleno de personajes únicos y habilidades elementales, inspirado en un estilo de animación japonesa.", R.drawable.img_genshin_impact));


        return list;
    }


    private void showDeleteConfirmationDialog(Videojuego videojuego, int position) {
        new AlertDialog.Builder(this)
                .setTitle("Confirmar Borrado")
                .setMessage("¿Estás seguro de que deseas eliminar este elemento?")
                .setIcon(R.drawable.papelera)
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        listVideojuegos.remove(position);
                        recAdapter.notifyItemRemoved(position);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(ListaActivity.this, "Operación Cancelada", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .show();

    }

}