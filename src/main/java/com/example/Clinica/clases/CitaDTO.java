package com.example.Clinica.clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDTO {
    private LocalDate fecha;
    private LocalTime hora;
    private DoctorDTO doctor;
    private SedeDTO sede;
    private EspecialidadDTO especialidad;
    
    public CitaDTO(LocalDate fecha, LocalTime hora, DoctorDTO doctor, SedeDTO sede, EspecialidadDTO especialidad) {
        this.fecha = fecha;
        this.hora = hora;
        this.doctor = doctor;
        this.sede = sede;
        this.especialidad = especialidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public SedeDTO getSede() {
        return sede;
    }

    public void setSede(SedeDTO sede) {
        this.sede = sede;
    }

    public EspecialidadDTO getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadDTO especialidad) {
        this.especialidad = especialidad;
    }

    // Constructor, getters y setters
    

    // Getters y setters
}
