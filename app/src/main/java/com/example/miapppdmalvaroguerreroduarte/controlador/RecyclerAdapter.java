package com.example.miapppdmalvaroguerreroduarte.controlador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miapppdmalvaroguerreroduarte.R;
import com.example.miapppdmalvaroguerreroduarte.modelo.Videojuego;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>{

    List<Videojuego> listvideojuego;
    private OnItemClickListener listener;

    public RecyclerAdapter(List<Videojuego> listvideojuego, OnItemClickListener listener) {
        this.listvideojuego = listvideojuego;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_list, parent, false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder holder, int position) {
        Videojuego videojuego = listvideojuego.get(position);
        holder.txtViewDesc.setText(videojuego.getDescripcion());
        holder.txtViewTitle.setText(videojuego.getTitulo());
        holder.imgVideojuego.setImageResource(videojuego.getImagenId());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(videojuego));
        holder.itemView.setOnLongClickListener(v -> {
            listener.onItemLongClick(videojuego, position);
            return true;
        });

    }

    @Override
    public int getItemCount() {
        return listvideojuego.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Videojuego videojuego);
        void onItemLongClick(Videojuego videojuego, int position);
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        ImageView imgVideojuego;
        TextView txtViewTitle;
        TextView  txtViewDesc;


        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            imgVideojuego  = (ImageView) itemView.findViewById(R.id.imgVideojuego);
            txtViewTitle = (TextView)  itemView.findViewById(R.id.txtTitulo);
            txtViewDesc  = (TextView)  itemView.findViewById(R.id.txt_item_desc);


        }
    }
}
