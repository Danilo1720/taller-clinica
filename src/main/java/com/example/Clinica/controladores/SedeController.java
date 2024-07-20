package com.example.Clinica.controladores;


import com.example.Clinica.clases.Sede;
import com.example.Clinica.servicios.impl.SedeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sedes")
public class SedeController {
    @Autowired
    private SedeServiceImpl sedeServiceImpl;

    @GetMapping
    public List<Sede> getAllSedes() {
        return sedeServiceImpl.getAllSedes();
    }

  /*   @GetMapping("/{id}")
    public Optional<Sede> getSedeById(@PathVariable Long id) {
        return sedeServiceImpl.getSedeById(id);
    }
 */
    @PostMapping
    public Sede createSede(@RequestBody Sede sede) {
        return sedeServiceImpl.saveSede(sede);
    }

    @DeleteMapping("/{id}")
    public void deleteSede(@PathVariable Long id) {
        sedeServiceImpl.deleteSede(id);
    }
}