package com.example.Clinica.clases;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DoctorDTO {
    private Long doctorId;
    private String nombDoc;
    private SedeDTO sede;
    private EspecialidadDTO especialidad;
    private List<HorarioDTO> horarios;
    
    public DoctorDTO() {
    }

   
    public DoctorDTO(Long doctorId, String nombDoc, SedeDTO sede, EspecialidadDTO especialidad,
            List<HorarioDTO> horarios) {
        this.doctorId = doctorId;
        this.nombDoc = nombDoc;
        this.sede = sede;
        this.especialidad = especialidad;
        this.horarios = horarios;
    }


    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getNombDoc() {
        return nombDoc;
    }

    public void setNombDoc(String nombDoc) {
        this.nombDoc = nombDoc;
    }

    public List<HorarioDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioDTO> horarios) {
        this.horarios = horarios;
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

    public Map<String, List<HorarioDTO>> getHorariosByDay() {
        return horarios.stream()
                .collect(Collectors.groupingBy(horario -> horario.getFechaHora().toLocalDate().toString()));
    }
   
}