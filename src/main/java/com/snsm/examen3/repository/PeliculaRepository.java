package com.snsm.examen3.repository;

import java.util.List;

import com.snsm.examen3.model.Pelicula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByTitleContainingIgnoreCase(String text);
}
