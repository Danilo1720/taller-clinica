package com.example.Clinica.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Clinica.clases.Cita;
import com.example.Clinica.clases.Horario;
import com.example.Clinica.repositorios.CitaRepository;
import com.example.Clinica.repositorios.HorarioRepository;
import com.example.Clinica.servicios.CitaService;
import com.example.Clinica.servicios.HorarioService;

@Service
public class CitaServiceImpl implements CitaService, HorarioService {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private HorarioRepository horarioRepository;

/*     @Override
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Optional<Cita> getCitaById(Long idCita) {
        return citaRepository.findById(idCita);
    }

    @Override
    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public void deleteCita(Long idCita) {
        citaRepository.deleteById(idCita);
    } */
    @Override
    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Horario findHorarioById(Long idHora) {
        return horarioRepository.findById(idHora).orElse(null);
    }

    @Override
    public Horario saveHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public List<Horario> getAllHorarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllHorarios'");
    }

    @Override
    public Optional<Horario> getHorarioById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHorarioById'");
    }

    @Override
    public void deleteHorario(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteHorario'");
    }

    @Override
    public List<Horario> getHorariosByDoctorId(Long doctorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHorariosByDoctorId'");
    }
/*     @Override
    public List<Cita> getCitasByPacienteId(Long idUsu) {
        return citaRepository.findByPacienteUsuarioId(idUsu);
    } */

    @Override
    public List<Cita> obtenerCitas() {
        return (List<Cita>) citaRepository.findAll();
    }

    @Override
    public List<Cita> obtenerCitasPorCorreoPaciente(String correo) {
        return citaRepository.findByPacienteCorreo(correo);
    }

    
}