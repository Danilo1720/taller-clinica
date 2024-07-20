package com.example.Clinica.servicios;

import java.util.List;

import com.example.Clinica.clases.Sede;

public interface SedeService {
    List<Sede> getAllSedes();
    Sede getSedeById(Long sedeId);
    Sede saveSede(Sede sede);
    void deleteSede(Long id);
}