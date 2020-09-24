package org.acme.microprofile.graphql;

import java.time.LocalDate;

public class Book {

    private String title;
    private Integer isdn;
    private String author;
    private LocalDate releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getISDN() {
        return isdn;
    }

    public void setISDN(Integer isdn) {
        this.isdn = isdn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

}