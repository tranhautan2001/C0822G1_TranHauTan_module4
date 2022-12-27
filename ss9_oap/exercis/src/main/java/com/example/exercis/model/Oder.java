package com.example.exercis.model;

import javax.persistence.*;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codeBook;

    @OneToOne(mappedBy = "oderBook")
    private Book book;

    public Oder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(int codeBook) {
        this.codeBook = codeBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
