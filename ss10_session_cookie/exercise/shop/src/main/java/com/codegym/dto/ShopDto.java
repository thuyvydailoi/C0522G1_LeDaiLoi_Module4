package com.codegym.dto;

import java.util.Objects;

public class ShopDto {

    private int id;

    private String name;

    private String code;

    private int oldPrice;

    private int newPrice;

    private String description;

    private String image;

    public ShopDto() {
    }

    public ShopDto(int id, String name, String code, int oldPrice, int newPrice, String description, String image) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String describe) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopDto shopDto = (ShopDto) o;
        return id == shopDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
