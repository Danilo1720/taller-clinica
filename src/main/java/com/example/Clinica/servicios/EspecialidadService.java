package com.example.Clinica.servicios;

import java.util.List;

import com.example.Clinica.clases.Especialidad;

public interface EspecialidadService {
    List<Especialidad> getAllEspecialidades();
    Especialidad getEspecialidadById(Long especialidadId);
    Especialidad saveEspecialidad(Especialidad especialidad);
    void deleteEspecialidad(Long id);
}