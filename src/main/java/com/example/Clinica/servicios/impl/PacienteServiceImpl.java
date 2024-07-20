package com.example.Clinica.servicios.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Clinica.clases.Paciente;
import com.example.Clinica.clases.Usuario;
import com.example.Clinica.repositorios.PacienteRepository;
import com.example.Clinica.servicios.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
   /*  @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    } */

    @Override
    public Paciente findByUsuario(Usuario usuario) {
        return pacienteRepository.findByUsuario(usuario);
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    
}