package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product();

    @Test
    void shouldFindByName() {
        product.setName("Iphone SE");
        boolean actual = product.matches("Iphone");
        assertTrue(actual);
    }

    @Test
    void shouldFindByWrongName() {
        product.setName("Samsung");
        boolean actual = product.matches("Iphone");
        assertFalse(actual);
    }
}