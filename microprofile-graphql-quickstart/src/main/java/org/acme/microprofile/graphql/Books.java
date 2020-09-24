package org.acme.microprofile.graphql;

import java.util.List;
import org.eclipse.microprofile.graphql.Description;

public class Books {

    public transient GalaxyService service;
    
    public Books(){
    
    }
    
    public Books(GalaxyService service){
        this.service = service;
    }
    
    @Description("Get all Books from a galaxy far far away")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }
    
}
