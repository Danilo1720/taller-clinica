package com.example.Clinica.clases;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doc")
    private Long doctorId;
    @Column(name = "nomb_doc")
    private String nombDoc;

    @ManyToOne
    @JoinColumn(name = "id_espe")
    @JsonIgnore
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "id_sede")
    @JsonIgnore
    private Sede sede;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Horario> horarios;
}
