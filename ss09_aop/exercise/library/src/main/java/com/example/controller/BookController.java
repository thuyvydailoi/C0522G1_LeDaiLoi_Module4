package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("/list")
    public String index(Model model) {
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("books", bookList);
        return "list";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable int id) {
        Book book = iBookService.findById(id);
        if (book.getAmount() == 0) {
            return "error";
        } else {
            iBookService.borrow(book);
        }
        return "redirect:/book/list";
    }

    @GetMapping("/save/{id}")
    public String refund(@PathVariable int id) {
        Book book = iBookService.findById(id);
        if (book.getAmount() == book.getFirstAmount()) {
            return "error";
        } else {
            iBookService.save(book);
        }
        return "redirect:/book/list";
    }
}
