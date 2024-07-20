package com.example.Clinica.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Clinica.clases.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
     List<Cita> findByPacienteCorreo(String correo); 
    
}