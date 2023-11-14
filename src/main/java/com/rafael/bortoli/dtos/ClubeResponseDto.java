package com.rafael.bortoli.dtos;

import com.rafael.bortoli.model.Clube;

import java.util.ArrayList;
import java.util.List;

public class ClubeResponseDto {
    private List<String> errors = new ArrayList<>();
    private Clube clube;

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }

    public List<String> getErrors() {
        return errors;
    }
}
