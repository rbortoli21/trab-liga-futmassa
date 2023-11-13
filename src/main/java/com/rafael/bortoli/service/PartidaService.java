package com.rafael.bortoli.service;

import com.rafael.bortoli.model.Partida;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PartidaService {
	List<Partida> getAll();
	void save(Partida Partida);
	Partida findById(long id);
	void delete(long id);
	Page<Partida> find(int pageNo, int pageSize, String sortField, String sortDirection);
}
