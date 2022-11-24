package com.example.projetofinal.repository;

import com.example.projetofinal.model.Usuario;

import java.util.ArrayList;

public class UsuarioRepository {
    private ArrayList<Usuario> usuarios;

    public UsuarioRepository() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1, "Paloma", "palomaarces@outlook.com", "51986874571", "12345"));
        usuarios.add(new Usuario(2, "Paloma2", "palomaarces2@outlook.com", "51986874571", "12345"));
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
