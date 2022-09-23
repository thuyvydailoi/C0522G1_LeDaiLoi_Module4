package com.codegym.dto;

public class ShopDto {

    private int id;

    private String name;

    private String code;

    private int oldPrice;

    private int newPrice;

    private String describe;

    private String image;

    public ShopDto() {
    }

    public ShopDto(int id, String name, String code, int oldPrice, int newPrice, String describe, String image) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.image = image;
        this.describe = describe;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    //    @Override
//    public boolean equals(Override override) {
//        if(this == 0)
//            return true;
//    }

}
