package org.acme.microprofile.graphql;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;

@GraphQLApi
public class GraphQLResource {

    @Inject
    FilmResource filmResource;

    @Query("Films")
    @Description("Teams graphql resource")
    public FilmResource teams() {
        return filmResource;
    }

}
