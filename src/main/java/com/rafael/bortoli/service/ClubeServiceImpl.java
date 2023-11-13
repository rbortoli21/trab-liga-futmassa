package com.rafael.bortoli.service;

import java.util.List;
import java.util.Optional;

import com.rafael.bortoli.model.Clube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public void delete(long id) {
        clubeRepository.deleteById(id);
    }

    @Override
    public Page<Clube> find(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        return clubeRepository.findAll(pageable);
    }
}
