package com.example.Clinica.servicios;

import com.example.Clinica.clases.Paciente;
import com.example.Clinica.clases.Usuario;

public interface PacienteService {
    Paciente findByUsuario(Usuario usuario);
    Paciente save(Paciente paciente);
    
}