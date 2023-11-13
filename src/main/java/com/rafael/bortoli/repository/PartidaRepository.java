package com.rafael.bortoli.repository;

import com.rafael.bortoli.model.Clube;
import com.rafael.bortoli.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long>{

}
