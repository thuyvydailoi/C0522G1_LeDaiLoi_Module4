package com.codegym.cinema.repository;

import com.codegym.cinema.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICinemaRepository extends JpaRepository<Cinema, Integer> {
    @Query(value = "select * from cinema where is_delete = 0", nativeQuery = true)
    List<Cinema> findAll();

    @Modifying
    @Query(value = "update cinema set is_delete = 1 where cinema_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);

}
