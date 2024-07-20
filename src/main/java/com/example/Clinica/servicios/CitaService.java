package com.example.Clinica.servicios;



import java.util.List;

import com.example.Clinica.clases.Cita;

public interface CitaService {
    /* List<Cita> getAllCitas();
    Optional<Cita> getCitaById(Long idCita);
    Cita saveCita(Cita cita);
    void deleteCita(Long idCita); */
    Cita save(Cita cita);
/*     List<Cita> getCitasByPacienteId(Long idUsu); */
    public List<Cita> obtenerCitas();
    List<Cita> obtenerCitasPorCorreoPaciente(String correo);
}