package com.example.Clinica.controladores;

import com.example.Clinica.clases.Especialidad;
import com.example.Clinica.servicios.impl.EspecialidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {
    @Autowired
    private EspecialidadServiceImpl especialidadServiceImpl;

    @GetMapping
    public List<com.example.Clinica.clases.Especialidad> getAllEspecialidades() {
        return especialidadServiceImpl.getAllEspecialidades();
    }


    @PostMapping
    public Especialidad createEspecialidad(@RequestBody Especialidad especialidad) {
        return especialidadServiceImpl.saveEspecialidad(especialidad);
    }

    @DeleteMapping("/{id}")
    public void deleteEspecialidad(@PathVariable Long id) {
        especialidadServiceImpl.deleteEspecialidad(id);
    }
}