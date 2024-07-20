package com.example.Clinica.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Clinica.clases.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByDoctorDoctorId(Long doctorId);
}