package com.example.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    private String nameBook;
    private String nameType;
    private int amount;
    private int firstAmount;

    public Book() {
    }

    public Book(int idBook, String nameBook, String nameType, int amount, int firstAmount) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.nameType = nameType;
        this.amount = amount;
        this.firstAmount = firstAmount;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(int firstAmount) {
        this.firstAmount = firstAmount;
    }
}
