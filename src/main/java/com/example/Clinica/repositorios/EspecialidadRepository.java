package com.example.Clinica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Clinica.clases.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
}