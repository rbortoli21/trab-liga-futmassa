package com.rafael.bortoli.service;

import java.util.List;

import com.rafael.bortoli.model.Clube;
import org.springframework.data.domain.Page;

public interface ClubeService {
	List<Clube> getAll();
	void save(Clube clube);
	Clube findById(long id);
	void delete(long id);
	Page<Clube> find(int pageNo, int pageSize, String sortField, String sortDirection);
}
