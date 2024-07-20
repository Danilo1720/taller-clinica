package com.example.Clinica.clases;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHora;

    @ManyToOne
    @JoinColumn(name = "id_doc")
    @JsonBackReference
    private Doctor doctor;

    private Boolean disponible;

    private LocalDateTime fechaHora;
    
    
}
