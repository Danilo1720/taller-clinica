package com.example.Clinica.controladores;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Clinica.clases.Paciente;
import com.example.Clinica.servicios.impl.PacienteServiceImpl;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteServiceImpl;
/* 
    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteServiceImpl.getAllPacientes();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteServiceImpl.getPacienteById(id);
    }

    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteServiceImpl.savePaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteServiceImpl.deletePaciente(id);
    } */
}
