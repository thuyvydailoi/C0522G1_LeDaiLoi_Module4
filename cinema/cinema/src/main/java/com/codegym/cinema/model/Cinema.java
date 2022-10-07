package com.codegym.cinema.model;

import javax.persistence.*;

@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaId;
    private String cinemaCode;
    private String cinemaName;
    private String cinemaDate;
    private String cinemaAmounts;
    private boolean isDelete = false;

    @ManyToOne()
    @JoinColumn(name = "film_id", referencedColumnName = "filmId")
    private Film film;

    public Cinema() {
    }

    public Cinema(Integer cinemaId, String cinemaCode, String cinemaName, String cinemaDate, String cinemaAmounts, boolean isDelete) {
        this.cinemaId = cinemaId;
        this.cinemaCode = cinemaCode;
        this.cinemaName = cinemaName;
        this.cinemaDate = cinemaDate;
        this.cinemaAmounts = cinemaAmounts;
        this.isDelete = isDelete;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaCode() {
        return cinemaCode;
    }

    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }


    public String getCinemaDate() {
        return cinemaDate;
    }

    public void setCinemaDate(String cinemaDate) {
        this.cinemaDate = cinemaDate;
    }

    public String getCinemaAmounts() {
        return cinemaAmounts;
    }

    public void setCinemaAmounts(String cinemaAmounts) {
        this.cinemaAmounts = cinemaAmounts;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
