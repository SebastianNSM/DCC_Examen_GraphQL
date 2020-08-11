package com.snsm.examen3.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.snsm.examen3.model.Pelicula;
import com.snsm.examen3.service.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeliculaMutation implements GraphQLMutationResolver {

    @Autowired
    private PeliculaService peliculaService;

    public Pelicula createPelicula(String title, int budget, float runtime, String lang, String releaseDate) {
        return peliculaService.createPelicula(title, budget, runtime, lang, releaseDate);
    }

    public Pelicula updatePelicula(int id, String title, int budget, float runtime, String lang, String releaseDate) {
        return peliculaService.updatePelicula(id, title, budget, runtime, lang, releaseDate);
    }

    public Pelicula deletePelicula(int id) {
        return peliculaService.deletePelicula(id);
    }

}
