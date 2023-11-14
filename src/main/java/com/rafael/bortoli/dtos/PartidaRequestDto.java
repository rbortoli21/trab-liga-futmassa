package com.rafael.bortoli.dtos;

import com.rafael.bortoli.model.Clube;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

public class PartidaRequestDto {
    private Long clubeCasaId;
    private Long clubeForaId;
    private Integer numeroGolsCasa;
    private Integer numeroGolsFora;


    public Long getClubeCasaId() {
        return clubeCasaId;
    }

    public void setClubeCasaId(Long clubeCasaId) {
        this.clubeCasaId = clubeCasaId;
    }

    public Long getClubeForaId() {
        return clubeForaId;
    }

    public void setClubeForaId(Long clubeForaId) {
        this.clubeForaId = clubeForaId;
    }

    public Integer getNumeroGolsCasa() {
        return numeroGolsCasa;
    }

    public void setNumeroGolsCasa(Integer numeroGolsCasa) {
        this.numeroGolsCasa = numeroGolsCasa;
    }

    public Integer getNumeroGolsFora() {
        return numeroGolsFora;
    }

    public void setNumeroGolsFora(Integer numeroGolsFora) {
        this.numeroGolsFora = numeroGolsFora;
    }
}
