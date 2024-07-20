package com.example.Clinica.clases;

import lombok.Data;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_espe")
    private Long especialidadId;
    @Column(name = "nomb_espe")
    private String nombEspe;

    @OneToMany(mappedBy = "especialidad")
    private List<Doctor> doctores;
    
}