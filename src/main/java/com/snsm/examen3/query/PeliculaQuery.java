package com.snsm.examen3.query;

import com.snsm.examen3.model.Pelicula;

import java.util.List;
import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.snsm.examen3.service.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeliculaQuery implements GraphQLQueryResolver {

    @Autowired
    private PeliculaService peliculaService;

    public List<Pelicula> getAll() {
        return peliculaService.getAll();
    }

    public Optional<Pelicula> getById(int id) {
        return this.peliculaService.getById(id);
    }

    public List<Pelicula> getAllFromYear(int year) {
        return this.peliculaService.getAllFromYear(year);
    }

    public List<Pelicula> getByTitle(String title) {
        return this.peliculaService.getByTitle(title);
    }
}
