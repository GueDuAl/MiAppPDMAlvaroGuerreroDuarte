package com.example.miapppdmalvaroguerreroduarte.utilidades;

import com.example.miapppdmalvaroguerreroduarte.modelo.Usuario;

import java.util.ArrayList;

public class Utilidades {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
}
