package com.rafael.bortoli.service;

import com.rafael.bortoli.model.Partida;
import com.rafael.bortoli.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaServiceImpl implements PartidaService {

    @Autowired
    PartidaRepository partidaRepository;

    @Override
    public List<Partida> getAll() {
        return partidaRepository.findAll();
    }

    @Override
    public void save(Partida partida) {
        partidaRepository.save(partida);
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
    public Page<Partida> find(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        return partidaRepository.findAll(pageable);
    }
}
