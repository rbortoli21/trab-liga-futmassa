package com.rafael.bortoli.repository;

import com.rafael.bortoli.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long>{
    @Query("SELECT e FROM Clube e ORDER BY e.pontos DESC, e.saldoGols DESC, e.vitorias DESC, e.golsFeitos DESC")
    List<Clube> findAllOrdered();
}
