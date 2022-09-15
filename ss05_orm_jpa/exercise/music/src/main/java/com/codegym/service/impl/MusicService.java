package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicrepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    IMusicrepository iMusicrepository;
    @Override
    public List<Music> findAll() {
        return iMusicrepository.findAll();
    }

    @Override
    public void save(Music music) {
    iMusicrepository.save(music);
    }

    @Override
    public void update(Music music) {
        iMusicrepository.update(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicrepository.findById(id);

    }

    @Override
    public void remove(int id) {
        iMusicrepository.remove(id);
    }
}
