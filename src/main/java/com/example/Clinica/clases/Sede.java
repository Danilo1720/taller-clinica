package com.example.Clinica.clases;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Long sedeId;
    @Column(name = "nomb_sede")
    private String nombSede;
    @Column(name = "direc_sede")
    private String direcSede;

    
    @OneToMany(mappedBy = "sede")
    private List<Doctor> doctores;
}