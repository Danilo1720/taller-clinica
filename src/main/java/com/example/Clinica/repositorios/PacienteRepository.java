package com.example.Clinica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Clinica.clases.Paciente;
import com.example.Clinica.clases.Usuario;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByUsuario(Usuario usuario);
    
}
