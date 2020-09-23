package org.acme.microprofile.graphql;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class FilmResourceTest {

    @BeforeAll
    static void setupAll() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void allFilms() {

        String requestBody =
                "{\"query\":" +
                        "\"" +
                        "{" +
                        " Films { " +
                        "           allFilms  {" +
                                    " title" +
                                    " director" +
                                    " releaseDate" +
                                    " episodeID" +
                                "}" +
                            "}" +
                        "}" +
                        "\"" +
                        "}";

        given()
                .body(requestBody)
                .post("/graphql/")
                .then()
                .contentType(ContentType.JSON)
                .body("data.Films.allFilms.size()", is(3))
                .body("data.Films.allFilms.director", hasItem("George Lucas"))
                .statusCode(200);
    }

    @Test
    public void getFilm() {

        String requestBody =
                "{\"query\":" +
                        "\"" +
                        "{" +
                        " Films { " +
                        "film (filmId: 1)  {" +
                        " title" +
                        " director" +
                        " releaseDate" +
                        " episodeID" +
                        "}" +
                        "}" +
                        "}" +
                        "\"" +
                        "}";

        given()
                .body(requestBody)
                .post("/graphql/")
                .then()
                .contentType(ContentType.JSON)
                .body("data.Films.size()", is(1))
                .body("data.Films.film.director", is("George Lucas"))
                .statusCode(200);
    }

    @Test
    public void getFilmWithHero() {

        String requestBody =
                "{\"query\":" +
                        "\"" +
                        "{" +
                        "Films {film (filmId: 0)  {" +
                        " title" +
                        " director" +
                        " releaseDate" +
                        " episodeID" +
                        " heroes { " +
                        "name" +
                        "}}" +
                        "}" +
                        "}" +
                        "\"" +
                        "}";

        given()
                .body(requestBody)
                .post("/graphql/")
                .then()
                .contentType(ContentType.JSON)
                .body("data.Films.size()", is(1))
                .body("data.Films.film.title", containsString("Hope"))
                .body("data.Films.film.director", is("George Lucas"))
                .body("data.Films.film.heroes.name", hasItem("Luke"))
                .statusCode(200);
    }

    @Test
    public void createHero() {

        String requestBody =
                "{\"query\":" +
                        "\"" +
                        "mutation Films { addHero { " +
                        "createHero" +
                        "(hero: " +
                        "{" +
                        "name: \\\"Han\\\" " +
                        "surname: \\\"Solo\\\" " +
                        "height: 1.85" +
                        "}" +
                        ")" +
                        "{" +
                        "name " +
                        "surname" +
                        "}" +
                        "}" +
                        "}" +
                        "\"" +
                        "}";

        given()
                .body(requestBody)
                .contentType(ContentType.JSON)
                .post("/graphql/")
                .then()
                .contentType(ContentType.JSON)
                .body("data.Films.createHero.name", is("Han"))
                .body("data.Films.createHero.surname", is("Solo"))
                .statusCode(200);

    }


    @Test
    public void deleteHero() {

        String requestBody =
                "{\"query\":" +
                        "\"" +
                        "mutation Films { DeleteHero { " +
                        "deleteHero" +
                        "(id: 3)" +
                        "{" +
                        "name " +
                        "surname" +
                        "}" +
                        "}" +
                        "}" +
                        "\"" +
                        "}";

        given()
                .body(requestBody)
                .contentType(ContentType.JSON)
                .post("/graphql/")
                .then()
                .contentType(ContentType.JSON)
                .body("data.Films.deleteHero.name", is("Han"))
                .body("data.Films.deleteHero.surname", is("Solo"))
                .statusCode(200);

    }

}
