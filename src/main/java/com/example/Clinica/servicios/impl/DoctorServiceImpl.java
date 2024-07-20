package com.example.Clinica.servicios.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Clinica.clases.Doctor;
import com.example.Clinica.repositorios.DoctorRepository;
import com.example.Clinica.servicios.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getDoctoresBySedeAndEspecialidad(Long sedeId, Long especialidadId) {
        return doctorRepository.findBySedeSedeIdAndEspecialidadEspecialidadId(sedeId, especialidadId);

    }


    
}