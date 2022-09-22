package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    Book borrow(Book book);

    Book save(Book book);

}

