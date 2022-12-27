package com.example.exercis.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String author;
    private int amount;
    private int startAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="oder_book_id",referencedColumnName = "id")
    private Oder oderBook;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(int startAmount) {
        this.startAmount = startAmount;
    }

    public Oder getOderBook() {
        return oderBook;
    }

    public void setOderBook(Oder oderBook) {
        this.oderBook = oderBook;
    }
}
