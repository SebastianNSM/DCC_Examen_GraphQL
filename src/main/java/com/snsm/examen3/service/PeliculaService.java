package com.snsm.examen3.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.snsm.examen3.model.Pelicula;
import com.snsm.examen3.repository.PeliculaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Pelicula> getAll() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> getById(int id) {
        return this.peliculaRepository.findById(id);
    }

    public Pelicula createPelicula(String title, int budget, float runtime, String lang, String releaseDate) {
        Pelicula peli = new Pelicula();
        peli.setTitle(title);
        peli.setBudget(budget);
        peli.setRuntime(runtime);
        peli.setLang(lang);
        peli.setReleaseDate(LocalDate.parse(releaseDate));
        return this.peliculaRepository.save(peli);
    }

    public Pelicula updatePelicula(int id, String title, int budget, float runtime, String lang, String releaseDate) {
        Pelicula peli = new Pelicula();
        peli.setId(id);
        peli.setTitle(title);
        peli.setBudget(budget);
        peli.setRuntime(runtime);
        peli.setLang(lang);
        peli.setReleaseDate(LocalDate.parse(releaseDate));
        return this.peliculaRepository.save(peli);
    }

    public Pelicula deletePelicula(int id) {
        Pelicula p = this.peliculaRepository.findById(id).orElse(null);
        if (p != null)
            this.peliculaRepository.deleteById(id);
        return p;
    }

    public List<Pelicula> getByTitle(String title) {
        return this.peliculaRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Pelicula> getAllFromYear(int year) {
        List<Pelicula> lst = this.peliculaRepository.findAll();
        return lst.stream().filter(p -> p.getReleaseDate().getYear() == year).collect(Collectors.toList());
    }

}
