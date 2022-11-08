package com.example.BookShop.entity;

import org.apache.logging.log4j.message.Message;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Book title is required")
    private String title;

    @NotBlank(message = "Book author is required")
    private String author;


    @NotBlank(message = "Book genre is required")
    private String genre;

    @NotNull(message = "Stock must be filled")
    @Digits(fraction = 0, integer = 4 , message = "stock must be a number")
    private Integer stock;


    public Book(Long id, String title, String author, Double price, String genre, Integer stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.stock = stock;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock=stock;
    }


}

