package org.acme.microprofile.graphql;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import javax.inject.Inject;
import java.util.List;
import org.eclipse.microprofile.graphql.GraphQLApi;

@GraphQLApi
public class FilmResource {

    @Inject
    GalaxyService service;

    
    @Query("Films")
    public Films getFilms(){
        return new Films();
    }
    
    @Description("Get all Films from a galaxy far far away")
    public List<Film> getAllFilms(@Source Films films) {
        return service.getAllFilms();
    }

//    @Query("getFilm")
//    @Description("Get a Films from a galaxy far far away")
//    public Film getFilm(@Name("filmId") int id) {
//        return service.getFilm(id);
//    }
//
//    public List<Hero> heroes(@Source Film film) {
//        return service.getHeroesByFilm(film);
//    }
//
//    @Mutation("createHero")
//    public Hero createHero(Hero hero) {
//        service.addHero(hero);
//        return hero;
//    }
//
//    @Mutation("deleteHero")
//    public Hero deleteHero(int id) {
//        return service.deleteHero(id);
//    }
//
//    @Query("getHeroesWithSurname")
//    public List<Hero> getHeroesWithSurname(@DefaultValue("Skywalker") String surname) {
//        return service.getHeroesBySurname(surname);
//    }

}
