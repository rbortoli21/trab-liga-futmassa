package com.rafael.bortoli.dtos;

import java.util.ArrayList;
import java.util.List;

public class PartidaResponseDto {
    private List<String> errors = new ArrayList<>();

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}