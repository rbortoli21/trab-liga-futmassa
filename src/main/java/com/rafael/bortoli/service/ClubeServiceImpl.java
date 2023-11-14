package com.rafael.bortoli.service;

import java.util.List;
import java.util.Optional;

import com.rafael.bortoli.dtos.ClubeResponseDto;
import com.rafael.bortoli.model.Clube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.bortoli.repository.ClubeRepository;

@Service
public class ClubeServiceImpl implements ClubeService {

    @Autowired
    ClubeRepository clubeRepository;

    @Override
    public List<Clube> getAll() {
        return clubeRepository.findAll();
    }

    @Override
    public List<Clube> getAllSorted() {
        return clubeRepository.findAllOrdered();
    }

    @Override
    public void save(Clube clube) {
        clubeRepository.save(clube);
    }

    @Override
    public Clube findById(long id) {
        Optional<Clube> optional = clubeRepository.findById(id);
        Clube clube = null;
        if (optional.isPresent()) {
            clube = optional.get();
        } else {
            throw new RuntimeException("Clube não foi encontrado para o id: " + id);
        }
        return clube;
    }

    @Override
    public ClubeResponseDto delete(long id) {
        ClubeResponseDto responseDto = new ClubeResponseDto();
        try {
            clubeRepository.deleteById(id);
        } catch (Exception exception) {
            responseDto.getErrors().add("Não é possível deletar um clube que já participou de alguma partida.");
        }
        return responseDto;
    }

    @Override
    public void flush() {
        clubeRepository.flush();
    }

    @Override
    public Clube edit(Long id, Clube clube) {
        Optional<Clube> clubeOptional = clubeRepository.findById(id);
        Clube clubeOld = clubeOptional.orElse(null);

        if (clube != null && clubeOld != null) {
            if (clube.getNome() != null && !clube.getNome().isEmpty())
                clubeOld.setNome(clube.getNome());
        }
        flush();

        return clubeOld;
    }
}
