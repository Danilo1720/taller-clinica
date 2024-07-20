package com.example.Clinica.servicios;

import java.util.List;
import java.util.Optional;

import com.example.Clinica.clases.Horario;

public interface HorarioService {
    List<Horario> getAllHorarios();
    Optional<Horario> getHorarioById(Long id);
    Horario saveHorario(Horario horario);
    void deleteHorario(Long idHora);
    List<Horario> getHorariosByDoctorId(Long doctorId);
    Horario findHorarioById(Long idHora);
    
    
}