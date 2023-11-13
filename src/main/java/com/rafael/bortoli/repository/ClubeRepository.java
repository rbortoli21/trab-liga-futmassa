package com.rafael.bortoli.repository;

import com.rafael.bortoli.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long>{

}
