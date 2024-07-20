package com.example.Clinica.clases;


public class EspecialidadDTO {
    private Long especialidadId;
    private String nombEspe;
    
    public EspecialidadDTO() {
    }
    public EspecialidadDTO(Long especialidadId, String nombEspe) {
        this.especialidadId = especialidadId;
        this.nombEspe = nombEspe;
    }
    public Long getEspecialidadId() {
        return especialidadId;
    }
    public void setEspecialidadId(Long especialidadId) {
        this.especialidadId = especialidadId;
    }
    public String getNombEspe() {
        return nombEspe;
    }
    public void setNombEspe(String nombEspe) {
        this.nombEspe = nombEspe;
    }
    
    
}