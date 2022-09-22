package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.getById(id);
    }


    @Override
    public Book borrow(Book book) {
        book.setAmount(book.getAmount() - 1);
        return iBookRepository.save(book);
    }

    @Override
    public Book save(Book book) {
        book.setAmount(book.getAmount() + 1);
        return iBookRepository.save(book);
    }
}
