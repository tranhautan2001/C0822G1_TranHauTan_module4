package com.example.exercis.service.impl;

import com.example.exercis.model.Book;
import com.example.exercis.repository.IBookRepository;
import com.example.exercis.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Book book) {
     repository.save(book);
    }
}
