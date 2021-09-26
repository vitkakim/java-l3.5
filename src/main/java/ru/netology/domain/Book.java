package ru.netology.domain;

import lombok.Data;

@Data
public class Book extends Product {
    private String author;

    public Book(){
    }

    public Book(String name, String author){
        super(name);
        this.author = author;
    }
}
