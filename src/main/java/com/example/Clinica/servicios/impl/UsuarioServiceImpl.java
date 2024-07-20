package com.example.Clinica.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Clinica.clases.Usuario;
import com.example.Clinica.repositorios.UsuarioRepository;
import com.example.Clinica.servicios.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreoUsu(correo);
    }


    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}