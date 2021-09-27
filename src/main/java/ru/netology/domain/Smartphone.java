package ru.netology.domain;


public class Smartphone extends Product {
    private String developer;

    public Smartphone() {
        super();
    }


    public Smartphone(int id, String name, int price, String developer) {
        super(id, name, price);
        this.developer = developer;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
