package com.example.Clinica.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Clinica.clases.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySedeSedeIdAndEspecialidadEspecialidadId(Long sedeId, Long especialidadId);
   
}
