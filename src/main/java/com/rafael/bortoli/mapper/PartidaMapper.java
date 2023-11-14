package com.rafael.bortoli.mapper;

import com.rafael.bortoli.dtos.PartidaRequestDto;
import com.rafael.bortoli.model.Partida;
import com.rafael.bortoli.service.ClubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidaMapper {
    @Autowired
    ClubeService clubeService;

    public Partida toDomain(PartidaRequestDto dto){
        Partida partida = new Partida();

        partida.setClubeCasa(clubeService.findById(dto.getClubeCasaId()));
        partida.setClubeFora(clubeService.findById(dto.getClubeForaId()));
        partida.setNumeroGolsCasa(dto.getNumeroGolsCasa());
        partida.setNumeroGolsFora(dto.getNumeroGolsFora());

        return partida;
    }
}
