package com.rafael.bortoli.service;

import java.util.List;

import com.rafael.bortoli.dtos.ClubeResponseDto;
import com.rafael.bortoli.model.Clube;
import org.springframework.data.domain.Page;

public interface ClubeService {
	List<Clube> getAll();
	List<Clube> getAllSorted();
	Clube findById(long id);
	void save(Clube clube);
	ClubeResponseDto delete(long id);
	void flush();
    Clube edit(Long id, Clube clube);
}
