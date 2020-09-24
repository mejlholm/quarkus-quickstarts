package org.acme.microprofile.graphql;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GalaxyService {

    private List<Hero> heroes = new ArrayList<>();

    private List<Film> films = new ArrayList<>();

    private List<Book> books = new ArrayList<>();
    
    public GalaxyService() {

        Film aNewHope = new Film();
        aNewHope.setTitle("A New Hope");
        aNewHope.setReleaseDate(LocalDate.of(1977, Month.MAY, 25));
        aNewHope.setEpisodeID(4);
        aNewHope.setDirector("George Lucas");

        Film theEmpireStrikesBack = new Film();
        theEmpireStrikesBack.setTitle("The Empire Strikes Back");
        theEmpireStrikesBack.setReleaseDate(LocalDate.of(1980, Month.MAY, 21));
        theEmpireStrikesBack.setEpisodeID(5);
        theEmpireStrikesBack.setDirector("George Lucas");

        Film returnOfTheJedi = new Film();
        returnOfTheJedi.setTitle("Return Of The Jedi");
        returnOfTheJedi.setReleaseDate(LocalDate.of(1983, Month.MAY, 25));
        returnOfTheJedi.setEpisodeID(6);
        returnOfTheJedi.setDirector("George Lucas");

        films.add(aNewHope);
        films.add(theEmpireStrikesBack);
        films.add(returnOfTheJedi);

        Book aNewHopeBook = new Book();
        aNewHopeBook.setTitle("A New Hope");
        aNewHopeBook.setReleaseDate(LocalDate.of(1977, Month.MAY, 25));
        aNewHopeBook.setISDN(4);
        aNewHopeBook.setAuthor("George Lucas");

        Book theEmpireStrikesBackBook = new Book();
        theEmpireStrikesBackBook.setTitle("The Empire Strikes Back");
        theEmpireStrikesBackBook.setReleaseDate(LocalDate.of(1980, Month.MAY, 21));
        theEmpireStrikesBackBook.setISDN(5);
        theEmpireStrikesBackBook.setAuthor("George Lucas");

        Book returnOfTheJediBook = new Book();
        returnOfTheJediBook.setTitle("Return Of The Jedi");
        returnOfTheJediBook.setReleaseDate(LocalDate.of(1983, Month.MAY, 25));
        returnOfTheJediBook.setISDN(6);
        returnOfTheJediBook.setAuthor("George Lucas");

        books.add(aNewHopeBook);
        books.add(theEmpireStrikesBackBook);
        books.add(returnOfTheJediBook);

        
        Hero luke = new Hero();
        luke.setName("Luke");
        luke.setSurname("Skywalker");
        luke.setHeight(1.7);
        luke.setMass(73);
        luke.setLightSaber(LightSaber.GREEN);
        luke.setDarkSide(false);
        luke.getEpisodeIds().addAll(Arrays.asList(4, 5, 6));

        Hero leia = new Hero();
        leia.setName("Leia");
        leia.setSurname("Organa");
        leia.setHeight(1.5);
        leia.setMass(51);
        leia.setDarkSide(false);
        leia.getEpisodeIds().addAll(Arrays.asList(4, 5, 6));


        Hero vader = new Hero();
        vader.setName("Darth");
        vader.setSurname("Vader");
        vader.setHeight(1.9);
        vader.setMass(89);
        vader.setDarkSide(true);
        vader.setLightSaber(LightSaber.RED);
        vader.getEpisodeIds().addAll(Arrays.asList(4, 5, 6));

        heroes.add(luke);
        heroes.add(leia);
        heroes.add(vader);

    }

    public List<Film> getAllFilms() {
        return films;
    }

    public Film getFilm(int id) {
        return films.get(id);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBook(int id) {
        return books.get(id);
    }
    
    public List<Hero> getHeroesByFilm(Film film) {
        return heroes.stream()
                .filter(hero -> hero.getEpisodeIds().contains(film.getEpisodeID()))
                .collect(Collectors.toList());
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public Hero deleteHero(int id) {
        return heroes.remove(id);
    }

    public List<Hero> getHeroesBySurname(String surname) {
        return heroes.stream()
                .filter(hero -> hero.getSurname().equals(surname))
                .collect(Collectors.toList());
    }
}
