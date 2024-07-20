package com.example.Clinica.clases;

import jakarta.persistence.Column;
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
@Table(name = "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita; 

    @ManyToOne
    @JoinColumn(name = "id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_hora")
    private Horario horario;

    private String descripcion;
}