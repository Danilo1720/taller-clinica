package com.example.Clinica.servicios;

import com.example.Clinica.clases.Usuario;

public interface UsuarioService {

    Usuario findByCorreo(String correo);
    Usuario save(Usuario usuario);
}