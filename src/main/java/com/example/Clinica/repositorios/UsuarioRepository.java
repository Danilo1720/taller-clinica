package com.example.Clinica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Clinica.clases.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByCorreoUsu(String correoUsu);
}
