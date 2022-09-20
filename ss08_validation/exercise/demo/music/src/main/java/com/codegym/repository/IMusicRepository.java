package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music, Integer> {
    Music findById(int id);
}
