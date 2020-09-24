package org.acme.microprofile.graphql;

import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;

@GraphQLApi
public class BookResource {

    @Inject
    GalaxyService service;

    @Query("Books")
    public Books getBooks(){
        return new Books(service);
    }
    
}
