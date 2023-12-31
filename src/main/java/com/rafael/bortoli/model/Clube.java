package com.rafael.bortoli.model;

import com.rafael.bortoli.service.ClubeService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Clube {
    public Clube(){}
    public Clube(String nome){
        this.nome = nome;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull(message = "Nome em [Clube] não pode ser nulo")
    private String nome;

    @Column
    private Integer jogos = 0;

    @Column
    private Integer vitorias = 0;

    @Column
    private Integer derrotas = 0;

    @Column
    private Integer empates = 0;

    @Column
    private Integer golsFeitos = 0;

    @Column
    private Integer golsSofridos = 0;

    @Column
    private Integer saldoGols = 0;

    @Column
    private Integer pontos = 0;

    public void incrementJogos() {
        jogos++;
    }

    public void incrementVitorias() {
        vitorias++;
        pontos += 3;
    }

    public void incrementDerrotas() {
        derrotas++;
    }

    public void incrementEmpates() {
        empates++;
        pontos += 1;
    }

    public void incrementGolsFeitos(Integer gols) {
        golsFeitos += gols;
    }

    public void incrementGolsSofridos(Integer gols) {
        golsSofridos += gols;
    }

    public Integer calcularSaldoGols() {
        saldoGols = golsFeitos - golsSofridos;
        return saldoGols;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getJogos() {
        return jogos;
    }

    public void setJogos(Integer jogos) {
        this.jogos = jogos;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public Integer getGolsFeitos() {
        return golsFeitos;
    }

    public void setGolsFeitos(Integer golsFeitos) {
        this.golsFeitos = golsFeitos;
    }

    public Integer getGolsSofridos() {
        return golsSofridos;
    }

    public void setGolsSofridos(Integer golsSofridos) {
        this.golsSofridos = golsSofridos;
    }

    public Integer getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(Integer saldoGols) {
        this.saldoGols = saldoGols;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }
}
