package com.example.Clinica.clases;

import java.time.LocalDateTime;

public class HorarioDTO {
    private Long idHora;
    private Boolean disponible;
    private LocalDateTime fechaHora;

    

    public HorarioDTO(Long idHora, Boolean disponible, LocalDateTime fechaHora) {
        this.idHora = idHora;
        this.disponible = disponible;
        this.fechaHora = fechaHora;
    }

    public Long getIdHora() {
        return idHora;
    }

    public void setIdHora(Long idHora) {
        this.idHora = idHora;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    
}
