package com.example.Clinica.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Clinica.clases.Sede;
import com.example.Clinica.repositorios.SedeRepository;
import com.example.Clinica.servicios.SedeService;

@Service
public class SedeServiceImpl implements SedeService{
    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public List<Sede> getAllSedes() {
        return sedeRepository.findAll();
    }

    @Override
    public Sede getSedeById(Long sedeId) {
        return sedeRepository.findById(sedeId).orElse(null);
    }

    @Override
    public Sede saveSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public void deleteSede(Long id) {
        sedeRepository.deleteById(id);
    }
}