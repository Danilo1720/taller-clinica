package com.example.Clinica.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Clinica.clases.Especialidad;
import com.example.Clinica.repositorios.EspecialidadRepository;
import com.example.Clinica.servicios.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
    @Autowired
    private EspecialidadRepository especialidadRepository;

    
    @Override
    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad getEspecialidadById(Long especialidadId) {
        return especialidadRepository.findById(especialidadId).orElse(null);
    }

    @Override
    public Especialidad saveEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public void deleteEspecialidad(Long id) {
        especialidadRepository.deleteById(id);
    }
}