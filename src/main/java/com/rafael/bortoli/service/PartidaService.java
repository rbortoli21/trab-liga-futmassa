package com.rafael.bortoli.service;

import com.rafael.bortoli.dtos.PartidaRequestDto;
import com.rafael.bortoli.dtos.PartidaResponseDto;
import com.rafael.bortoli.model.Partida;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PartidaService {
    List<Partida> getAll();

    Partida findById(long id);

    PartidaResponseDto save(PartidaRequestDto partida);

    void delete(long id);

    void flush();
}
