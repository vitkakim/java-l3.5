package ru.netology.domain;

import lombok.Data;

@Data
public class Smartphone extends Product {
    private String developer;

    public Smartphone(){
    }

    public Smartphone(int id, String name, int price, String developer){
        super(id, name, price);
        this.developer = developer;
    }

    public Smartphone(String name, String developer){
        super(name);
        this.developer = developer;
    }

}
