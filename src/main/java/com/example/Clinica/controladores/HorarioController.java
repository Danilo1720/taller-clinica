package com.example.Clinica.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Clinica.clases.Horario;
import com.example.Clinica.servicios.impl.HorarioServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
    @Autowired
    private HorarioServiceImpl horarioServiceImpl;

    @GetMapping
    public List<Horario> getAllHorarios() {
        return horarioServiceImpl.getAllHorarios();
    }

    @GetMapping("/{id}")
    public Optional<Horario> getHorarioById(@PathVariable Long id) {
        return horarioServiceImpl.getHorarioById(id);
    }

    @PostMapping
    public Horario createHorario(@RequestBody Horario horario) {
        return horarioServiceImpl.saveHorario(horario);
    }

    @DeleteMapping("/{id}")
    public void deleteHorario(@PathVariable Long id) {
        horarioServiceImpl.deleteHorario(id);
    }
}
