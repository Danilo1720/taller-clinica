package com.example.Clinica.servicios;

import java.util.List;


import com.example.Clinica.clases.Doctor;

public interface DoctorService {
    List<Doctor> getDoctoresBySedeAndEspecialidad(Long sedeId, Long especialidadId);
    

}