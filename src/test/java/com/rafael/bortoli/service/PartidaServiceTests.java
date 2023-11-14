package com.rafael.bortoli.service;

import com.rafael.bortoli.dtos.PartidaRequestDto;
import com.rafael.bortoli.dtos.PartidaResponseDto;
import com.rafael.bortoli.model.Clube;
import com.rafael.bortoli.model.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PartidaServiceTests {
    @Autowired
    PartidaService partidaService;

    @Autowired
    ClubeService clubeService;

    @Test
    public void getAll() {
        assertNotNull(partidaService.getAll());
    }

    @Test
    public void salvarPartida() {
        Clube clubeCasa = new Clube("Palmeiras");
        Clube clubeFora = new Clube("Corinthians");

        clubeService.save(clubeCasa);
        clubeService.save(clubeFora);

        PartidaRequestDto partidaRequestDto = new PartidaRequestDto();
        partidaRequestDto.setClubeCasaId(clubeCasa.getId());
        partidaRequestDto.setClubeForaId(clubeFora.getId());
        partidaRequestDto.setNumeroGolsCasa(2);
        partidaRequestDto.setNumeroGolsFora(0);

        PartidaResponseDto responseDto = partidaService.save(partidaRequestDto);

        assertNotNull(responseDto.getPartida());
    }

    @Nested
    public class TestsForGetById {
        Partida partida = null;

        @BeforeEach
        public void beforeGetById() {
            Clube clubeCasa = new Clube("Palmeiras");
            Clube clubeFora = new Clube("Corinthians");

            clubeService.save(clubeCasa);
            clubeService.save(clubeFora);

            PartidaRequestDto partidaRequestDto = new PartidaRequestDto();
            partidaRequestDto.setClubeCasaId(clubeCasa.getId());
            partidaRequestDto.setClubeForaId(clubeFora.getId());
            partidaRequestDto.setNumeroGolsCasa(2);
            partidaRequestDto.setNumeroGolsFora(0);

            PartidaResponseDto responseDto = partidaService.save(partidaRequestDto);
            partida = responseDto.getPartida();
        }

        @Test
        public void getById() {
            assertNotNull(partidaService.findById(partida.getId()));
        }
    }

}
