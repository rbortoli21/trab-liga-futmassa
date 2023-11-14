package com.rafael.bortoli.service;

import com.rafael.bortoli.dtos.PartidaRequestDto;
import com.rafael.bortoli.dtos.PartidaResponseDto;
import com.rafael.bortoli.mapper.PartidaMapper;
import com.rafael.bortoli.model.Clube;
import com.rafael.bortoli.model.Partida;
import com.rafael.bortoli.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PartidaServiceImpl implements PartidaService {
    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    PartidaMapper partidaMapper;
    @Autowired
    ClubeService clubeService;

    @Override
    public List<Partida> getAll() {
        return partidaRepository.findAll();
    }

    @Override
    public PartidaResponseDto save(PartidaRequestDto partidaRequest) {
        PartidaResponseDto response = new PartidaResponseDto();
        if (partidaRequest.getClubeCasaId() == null || partidaRequest.getClubeForaId() == null) {
            String error = "Os campos clube casa e clube fora devem ser preenchidos";
            response.getErrors().add(error);
        }
        if(partidaRequest.getNumeroGolsCasa() == null || partidaRequest.getNumeroGolsFora() == null){
            String error = "Todos os campos devem ser preenchidos, verifique e tente novamente.";
            response.getErrors().add(error);
        }
        if(Objects.equals(partidaRequest.getClubeForaId(), partidaRequest.getClubeCasaId())){
            String error = "Os clubes da partida não podem ser os mesmos";
            response.getErrors().add(error);
        }
        if(!response.getErrors().isEmpty())
            return response;

        Clube clubeCasa = clubeService.findById(partidaRequest.getClubeCasaId());
        Clube clubeFora = clubeService.findById(partidaRequest.getClubeForaId());


        clubeCasa.incrementGolsFeitos(partidaRequest.getNumeroGolsCasa());
        clubeFora.incrementGolsFeitos(partidaRequest.getNumeroGolsFora());

        clubeCasa.incrementGolsSofridos(partidaRequest.getNumeroGolsFora());
        clubeFora.incrementGolsSofridos(partidaRequest.getNumeroGolsCasa());

        clubeCasa.incrementJogos();
        clubeFora.incrementJogos();

        if (partidaRequest.getNumeroGolsCasa() > partidaRequest.getNumeroGolsFora()) {
            clubeCasa.incrementVitorias();
            clubeFora.incrementDerrotas();
        } else if (Objects.equals(partidaRequest.getNumeroGolsCasa(), partidaRequest.getNumeroGolsFora())) {
            clubeCasa.incrementEmpates();
            clubeFora.incrementEmpates();
        } else {
            clubeFora.incrementVitorias();
            clubeCasa.incrementDerrotas();
        }
        clubeCasa.calcularSaldoGols();
        clubeFora.calcularSaldoGols();

        clubeService.flush();

        partidaRepository.save(partidaMapper.toDomain(partidaRequest));

        return response;
    }

    @Override
    public Partida findById(long id) {
        Optional<Partida> optional = partidaRepository.findById(id);
        Partida partida = null;
        if (optional.isPresent()) {
            partida = optional.get();
        } else {
            throw new RuntimeException("Partida não foi encontrado para o id: " + id);
        }
        return partida;
    }

    @Override
    public void delete(long id) {
        partidaRepository.deleteById(id);
    }

    @Override
    public void flush() {
        partidaRepository.flush();
    }
}
