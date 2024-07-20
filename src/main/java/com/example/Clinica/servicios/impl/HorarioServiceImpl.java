package com.example.Clinica.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Clinica.clases.Horario;
import com.example.Clinica.repositorios.HorarioRepository;
import com.example.Clinica.servicios.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> getHorariosByDoctorId(Long doctorId){
        return horarioRepository.findByDoctorDoctorId(doctorId);
    }

    @Override
    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Optional<Horario> getHorarioById(Long id) {
        return horarioRepository.findById(id);
    }

    @Override
    public Horario saveHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public void deleteHorario(Long idHora) {
        horarioRepository.deleteById(idHora);
    }

    @Override
    public Horario findHorarioById(Long idHora) {
        return horarioRepository.findById(idHora).orElse(null);
    }

}