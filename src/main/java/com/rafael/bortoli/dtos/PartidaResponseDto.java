package com.rafael.bortoli.dtos;

import com.rafael.bortoli.model.Partida;

import java.util.ArrayList;
import java.util.List;

public class PartidaResponseDto {
    private List<String> errors = new ArrayList<>();

    private Partida partida;

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
