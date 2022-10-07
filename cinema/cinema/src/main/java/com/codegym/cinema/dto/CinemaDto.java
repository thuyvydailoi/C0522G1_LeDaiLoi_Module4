package com.codegym.cinema.dto;

import org.hibernate.annotations.Parent;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CinemaDto {
    @NotBlank(message = "Cannot be blank!")
    private Integer cinemaId;

    @NotBlank(message = "Cannot be blank!")
    @Pattern(regexp = "[C][l]//d{4}", message = "The cinema id  must be in the correct format CI-XXXX  (X is 0-9)!")
    private String cinemaCode;


    private String cinemaName;


    private String cinemaDate;

    @Min(value = 0, message = "Số lượng phải là số nguyên dương")
    private String cinemaAmounts;
    private boolean isDelete = false;


    public CinemaDto() {
    }

    public CinemaDto(Integer cinemaId, String cinemaCode, String cinemaName, String cinemaDate, String cinemaAmounts, boolean isDelete) {
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
}
