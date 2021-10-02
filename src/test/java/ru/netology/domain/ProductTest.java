package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    Product product = new Product();

    @Test
    void shouldFindByName() {
        product.setName("Iphone SE");
        boolean actual = product.matches("Iphone");
        assertEquals(true, actual);
    }

    @Test
    void shouldFindByWrongName() {
        product.setName("Samsung");
        boolean actual = product.matches("Iphone");
        assertEquals(false, actual);
    }
}