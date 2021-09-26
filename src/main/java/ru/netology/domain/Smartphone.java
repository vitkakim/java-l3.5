package ru.netology.domain;

import lombok.Data;

@Data
public class Smartphone extends Product {
    private String developer;

    public Smartphone(){
    }


    public Smartphone(String name, String developer){
        super(name);
        this.developer = developer;
    }

}
