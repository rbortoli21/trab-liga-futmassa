package com.rafael.bortoli.model;

import jakarta.persistence.*;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Clube clubeCasa;

    @OneToOne
    private Clube clubeFora;

    @Column
    private Integer numeroGolsCasa;

    @Column
    private Integer numeroGolsFora;

    public long getId() {
        return id;
    }

    public Clube getClubeCasa() {
        return clubeCasa;
    }

    public void setClubeCasa(Clube clubeCasa) {
        this.clubeCasa = clubeCasa;
    }

    public Clube getClubeFora() {
        return clubeFora;
    }

    public void setClubeFora(Clube clubeFora) {
        this.clubeFora = clubeFora;
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
