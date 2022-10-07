package com.codegym.cinema.service;

import com.codegym.cinema.model.Cinema;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ICinemaService {
    List<Cinema> findAll();

    void delete(Integer id);

    Optional<Cinema> findById(Integer id);

    void  save(Cinema cinema);
}
