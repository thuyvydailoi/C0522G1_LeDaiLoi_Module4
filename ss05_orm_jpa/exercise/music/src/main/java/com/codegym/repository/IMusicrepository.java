package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicrepository {
    List<Music> findAll();

    void save(Music music);

    void update(Music music);

    Music findById(int id);

    void remove(int id);
}
