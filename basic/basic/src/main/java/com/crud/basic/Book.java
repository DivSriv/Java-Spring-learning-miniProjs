package com.crud.basic;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @BookValidation
    @NotNull
    private String title;

    @Column(name = "author_name")
    private String authorName;
    @Column(name = "released_year")
    private int releasedYear;

    public Book() {
    }


    public Book(int id, String title, String authorName, int releasedYear) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.releasedYear = releasedYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", releasedYear=" + releasedYear +
                '}';
    }
}
