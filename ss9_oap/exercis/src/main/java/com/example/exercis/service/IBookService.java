package com.example.exercis.service;

import com.example.exercis.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book book);

}
