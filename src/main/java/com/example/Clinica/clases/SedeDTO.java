package com.example.Clinica.clases;

public class SedeDTO {
    private Long sedeId;
    private String direcSede;
    private String nombSede;
    
    public SedeDTO() {
    }

    public SedeDTO(Long sedeId, String direcSede, String nombSede) {
        this.sedeId = sedeId;
        this.direcSede = direcSede;
        this.nombSede = nombSede;
    }

    public SedeDTO(Long sedeId2, String nombSede2) {
        //TODO Auto-generated constructor stub
    }

    public Long getSedeId() {
        return sedeId;
    }

    public void setSedeId(Long sedeId) {
        this.sedeId = sedeId;
    }

    public String getDirecSede() {
        return direcSede;
    }

    public void setDirecSede(String direcSede) {
        this.direcSede = direcSede;
    }

    public String getNombSede() {
        return nombSede;
    }

    public void setNombSede(String nombSede) {
        this.nombSede = nombSede;
    }
    
    
}
